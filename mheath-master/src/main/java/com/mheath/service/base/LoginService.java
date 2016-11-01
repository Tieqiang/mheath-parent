package com.mheath.service.base;

import org.apache.shiro.subject.Subject;
import org.secnod.shiro.jaxrs.Auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.io.IOException;

/**
 * Created by heren on 2016/10/29.
 */
@Produces("application/json")
@Path("login")
public class LoginService {

    @Context
    private HttpServletRequest request ;
    @Context
    private HttpServletResponse response ;

    @GET
    public void login() throws ServletException, IOException {
        request.getRequestDispatcher("../login.html").forward(request,response);
    }


    @POST
    public void postLogin(@Auth Subject subject){
        System.out.println(subject.getPrincipal());
    }


}
