package com.mheath.service.base;

import com.mheath.base.entity.RoleDict;
import com.mheath.base.facade.RoleDictFacade;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.secnod.shiro.jaxrs.Auth;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by heren on 2016/10/27.
 */
@Path("role")
@Produces("application/json")
public class RoleSerivce {

    private RoleDictFacade roleDictFacade ;

    @Inject
    public RoleSerivce(RoleDictFacade roleDictFacade) {
        this.roleDictFacade = roleDictFacade;
    }


    @GET
    @RequiresPermissions("role:view")
    @Path("list")
    public List<RoleDict> listRoleDict(){
        return roleDictFacade.findAll(RoleDict.class) ;
    }



}
