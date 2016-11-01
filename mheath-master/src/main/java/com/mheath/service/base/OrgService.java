package com.mheath.service.base;

import com.mheath.base.facade.OrgDictFacade;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by heren on 2016/10/27.
 */
@Path("org")
@Produces("application/json")
public class OrgService {

    private OrgDictFacade orgDictFacade ;


    @Inject
    public OrgService(OrgDictFacade orgDictFacade) {
        this.orgDictFacade = orgDictFacade;
    }

    
}
