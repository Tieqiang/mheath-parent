package com.mheath.test;

import com.mheath.realm.PasswordAndSalt;
import com.mheath.realm.SystemPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.junit.*;

/**
 * Created by heren on 2016/10/31.
 */

public class PasswordServiceTest {

    @Test
    public void testEnscript(){
        SystemPasswordService systemPasswordService = new SystemPasswordService();
        PasswordAndSalt passwordAndSalt =systemPasswordService.enscriptPassword("zhao", "1234") ;
        System.out.println(passwordAndSalt.getPassword());
    }
}
