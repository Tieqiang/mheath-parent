package com.mheath.service.base;

import com.mheath.base.entity.UserDict;
import com.mheath.base.facade.UserDictFacade;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by heren on 2016/10/27.
 */
@Path("user")
@Produces("application/json")
public class UserService {

    private UserDictFacade userDictFacade ;

    @Inject
    public UserService(UserDictFacade userDictFacade) {
        this.userDictFacade = userDictFacade;
    }

    @GET
    @Path("list-all")
    public List<UserDict> listUser(){
        return userDictFacade.findAll(UserDict.class) ;
    }

}
