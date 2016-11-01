package com.mheath.provider;

import com.mheath.common.entity.ErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by heren on 2016/10/23.
 */
@Provider
public class ExceptionProvider implements ExceptionMapper<Exception>{

    @Context
    private HttpServletRequest httpServletRequest ;

    @Context
    private HttpServletResponse response ;


    @Override
    @Produces("text/html")
    public Response toResponse(Exception exception) {

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception.getMessage()).build();
    }
}
