package com.avior.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

public class CustomHttp403ForbiddenEntryPoint extends
		Http403ForbiddenEntryPoint implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(CustomHttp403ForbiddenEntryPoint.class);

    /**
     * Retorna un error 403 al cliente, aunque si la petición es de JSON, entonces debe de 
     * regresar la respuesta con JSON en vez de HTML
     */
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2) throws IOException,
            ServletException {
        if (logger.isDebugEnabled()) {
            logger.debug("Pre-authenticated entry point called. Rejecting access");
        }
        
        if("XmlHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))){
        	String jsonObject = "{\"message\":\"Please login first.\","+
        						"\"access-denied\":true,\"cause\":\"AUTHENTICATION_FAILURE\"}";
        	String contentType = "application/json";
        	response.setContentType(contentType);
        	response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        	PrintWriter out = response.getWriter();
        	out.print(jsonObject);
        	out.flush();
        	out.close();
        	return;        	
        }
        
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
    }
	
	
}
