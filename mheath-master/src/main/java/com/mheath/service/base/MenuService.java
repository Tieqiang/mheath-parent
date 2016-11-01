package com.mheath.service.base;

import com.mheath.base.entity.MenuDict;
import com.mheath.base.facade.MenuDictFacade;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.secnod.shiro.jaxrs.Auth;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by heren on 2016/10/27.
 */
@Path("menu")
@Produces("application/json")
public class MenuService {

    private MenuDictFacade menuDictFacade;

    @Inject
    public MenuService(MenuDictFacade menuDictFacade) {
        this.menuDictFacade = menuDictFacade;
    }

    @GET
    @Path("list")
    @RequiresPermissions("sys:menu:view")
    public List<MenuDict> listMenuDict(@Auth Subject subject) {
        String loginUser = subject.getPrincipal().toString();
        String hql = "select m from MenuDict as m ,RoleVsMenu as rm ,UserDict as ud ,UserVsRole as ur " +
                "where ud.userName = '" + loginUser + "'" +
                " and ud.id=ur.userId " +
                " and ur.roleId=rm.roleId " +
                " and rm.menuId=m.id";
        return menuDictFacade.find(MenuDict.class, hql);
    }

    /**
     * 添加菜单，修改菜单
     * @param menuDict
     * @return
     */
    @POST
    @Path("merge")
    public Response addMenuDict(MenuDict menuDict) {
        MenuDict menuDict1 = menuDictFacade.addMenuDict(menuDict);
        return Response.status(Response.Status.OK).entity(menuDict1).build() ;
    }


}
