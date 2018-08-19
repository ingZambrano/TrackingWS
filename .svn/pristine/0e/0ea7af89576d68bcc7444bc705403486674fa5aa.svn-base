package com.avior.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avior.dao.UserDAO;
import com.avior.model.tav.Tavusuario;

@Service("servicioDetalleUsuario")
@Transactional(readOnly=true)
public class ServicioDetalleUsuario implements UserDetailsService {
	
	@Autowired
	UserDAO usuarioDAO;

	@Override
	public UserDetails loadUserByUsername(String nombre)
			throws UsernameNotFoundException, DataAccessException {

		Tavusuario theUser=null;
		
		theUser = usuarioDAO.getusuario(nombre);
		if (theUser == null) {			
			throw new UsernameNotFoundException(
			"[loadUserByUsername]No se encontró el usuario");			
		}
		
	
		return theUser;
		
		
	}

	
}
