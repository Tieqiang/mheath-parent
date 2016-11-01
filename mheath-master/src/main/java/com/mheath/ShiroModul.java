package com.mheath;

import com.google.inject.MembersInjector;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.mheath.realm.HashSystemRealm;
import com.mheath.realm.NewPasswordMater;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.config.Ini;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.guice.web.ShiroWebModule;
import org.apache.shiro.realm.Realm;

import javax.servlet.ServletContext;

/**
 * Created by heren on 2016/10/30.
 */
public class ShiroModul extends ShiroWebModule {
    public ShiroModul(ServletContext servletContext) {
        super(servletContext);
    }

    @Override
    protected void configureShiroWeb() {

        bindRealm().to(Realm.class).in(Singleton.class);

        bindConstant().annotatedWith(Names.named("shiro.usernameParam")).to("username1");
        bindConstant().annotatedWith(Names.named("shiro.passwordParam")).to("password1");
        bindConstant().annotatedWith(Names.named("shiro.loginUrl")).to("/api/login");
        bindConstant().annotatedWith(Names.named("shiro.successUrl")).to("/index.html");


        addFilterChain("/assert/**", ANON);
        addFilterChain("/js/**",ANON);
        addFilterChain("/style/**",ANON);
        addFilterChain("/login.html",ANON);
        addFilterChain("/**",AUTHC);
        addFilterChain("/success.html",AUTHC);
        addFilterChain("/api/**",AUTHC);
    }



    @Provides
    public Realm provideRealm(){
        HashSystemRealm hashSystemRealm = new HashSystemRealm();
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher() ;
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        hashedCredentialsMatcher.setHashIterations(1024);
        hashedCredentialsMatcher.setHashAlgorithmName(Md5Hash.ALGORITHM_NAME);
        hashSystemRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return hashSystemRealm ;
    }
}
