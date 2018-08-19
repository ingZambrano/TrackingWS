package com.avior.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.avior.dao.UserDAO;
import com.avior.model.tav.Tavusuario;
import com.avior.model.tav.Tavusuariodisp;

@Service
@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
public class ManageUsersImpl implements ManageUsers {	
	
	@Autowired
	private UserDAO userDAO;


	//Metodos de la nueva base
	@Transactional(readOnly = true)
	@Override
	public Tavusuario getUsuario(String nombre) {		
		return userDAO.getusuario(nombre);
	}

	
	@Override
	public List<Tavusuariodisp> getDispXUsuario(BigInteger idUsuario) {
		return userDAO.getDispositivosXUsuario(idUsuario);
	}

	@Override
	public void updateusuario(Tavusuario usuario) {
		userDAO.updateUsuario(usuario);
		
	}
	
	
}
