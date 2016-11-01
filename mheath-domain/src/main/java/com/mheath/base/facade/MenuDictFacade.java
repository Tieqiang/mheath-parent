package com.mheath.base.facade;

import com.google.inject.persist.Transactional;
import com.mheath.base.entity.MenuDict;
import com.mheath.common.facade.BaseFacade;

/**
 * Created by heren on 2016/10/27.
 */
public class MenuDictFacade extends BaseFacade {

    @Transactional
    public MenuDict addMenuDict(MenuDict menuDict) {
        return merge(menuDict) ;
    }


}
