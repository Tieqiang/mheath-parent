package com.mheath.service;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Calendar;

/**
 * Created by heren on 2016/10/23.
 */
@Produces("application/json")
@Path("time")
public class TimeService {

    @GET
    @RequiresPermissions("create")
    public String getTime(){
        return Calendar.getInstance().getTime().toString();
    }

}
