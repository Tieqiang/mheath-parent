package com.mheath.service.base;

import com.mheath.base.facade.MenuDictFacade;
import com.mheath.base.facade.UserDictFacade;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by heren on 2016/10/30.
 */
@Produces("application/json")
@Path("sys")
public class SysService {

    private UserDictFacade userDictFacade ;
    private MenuDictFacade menuDictFacade ;

    @Inject
    public SysService(UserDictFacade userDictFacade, MenuDictFacade menuDictFacade) {
        this.userDictFacade = userDictFacade;
        this.menuDictFacade = menuDictFacade;
    }





}
