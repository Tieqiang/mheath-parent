package com.mheath.realm;

import com.google.inject.Provider;
import com.google.inject.persist.PersistService;
import com.google.inject.servlet.GuiceFilter;
import com.mheath.base.entity.UserDict;
import com.mheath.base.facade.UserDictFacade;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by heren on 2016/10/24.
 */
public class HashSystemRealm extends AuthorizingRealm {


    //@Inject
    //private UserDictFacade userDictFacade ;
    @Inject
    private Provider<UserDictFacade> userDictFacadeProvider ;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //userDictFacade.findAll(UserDict.class);
        //EntityManager entityManager=entityManagerProvider.get() ;
        //UserDictFacade userDictFacade = userDictFacadeProvider.get();
        //List<UserDict> userDictList = userDictFacade.findAll(UserDict.class) ;
        String userName = (String)authenticationToken.getPrincipal() ;
        String salt = "1b699fdc7b8975bedd698dae48995342" ;
        String password = "0ef82ae5b35704db0b7d4a1431039067" ;

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(authenticationToken.getPrincipal(),password, ByteSource.Util.bytes(authenticationToken.getPrincipal()+salt), getName()) ;
        return authenticationInfo;

    }

}
