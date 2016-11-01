package com.mheath.base.facade;

import com.mheath.common.facade.BaseFacade;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by heren on 2016/10/27.
 */
public class UserDictFacade extends BaseFacade {

    @Inject
    private EntityManager entityManager ;



    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
