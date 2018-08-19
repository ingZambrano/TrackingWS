package com.avior.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.RequestMatcher;

public class NonAjaxRequestMatcher implements RequestMatcher {

	@Override
	public boolean matches(HttpServletRequest request) {
		/* El estandar defacto en javascript es enviar las peticiones AJAX con el encabezado XmlHttpRequest
		 * en base a eso se puede discriminar las llamadas de AJAX de las del usuario*/
		return !"XmlHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
	}

}
