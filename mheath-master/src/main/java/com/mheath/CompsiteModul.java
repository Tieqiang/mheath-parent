package com.mheath;

import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.mheath.filter.CorsFilter;
import com.mheath.realm.HashSystemRealm;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.google.inject.Singleton;
import org.apache.shiro.guice.web.GuiceShiroFilter;
import org.apache.shiro.web.servlet.ShiroFilter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by heren on 2015/8/24.
 */
public class CompsiteModul extends JerseyServletModule {


    @Override
    protected void configureServlets() {
        bind(GuiceContainer.class) ;
        bind(CorsFilter.class).in(Singleton.class);
        filter("/api/*").through(CorsFilter.class);

        Map<String, String> params = new HashMap<String, String>();
        params.put("com.sun.jersey.spi.container.ResourceFilters","org.secnod.shiro.jersey.ShiroResourceFilterFactory") ;
        params.put("com.sun.jersey.config.property.packages", "com.mheath"); //PROPERTY_PACKAGES
        params.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
        ServletKeyBindingBuilder servletKeyBindingBuilder= serve("/api/*");
        servletKeyBindingBuilder.with(GuiceContainer.class, params) ;
        install(new JpaPersistModule("domain"));
        filter("/api/*").through(PersistFilter.class);
        install(new ShiroModul(this.getServletContext()));
        filter("/*").through(GuiceShiroFilter.class);
    }
}
