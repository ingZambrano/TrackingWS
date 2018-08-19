package com.avior.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.avior.model.tav.Tavusuario;
import com.avior.model.tav.Tavusuariodisp;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	@Qualifier("sessionFactoryTav")
	private SessionFactory sessionFactoryTav;
	
	//Base nueva
	@Override
	public Tavusuario getusuario(String nombre) {

		logger.debug("[DAO]Buscando al usuario " + nombre);
		Tavusuario user;
		
		StringBuilder sb = new StringBuilder();
		sb.append("from Tavusuario a ");
		sb.append("where a.fcCorreoUsuario =:nombre");
		
		
		
		Query q = sessionFactoryTav.getCurrentSession().createQuery(sb.toString());
		q.setParameter("nombre", nombre);
		
		user = (Tavusuario) q.uniqueResult();		
		
		return user;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tavusuariodisp> getDispositivosXUsuario(BigInteger idUsuario) {
		
		logger.debug("[DAO] Buscando dispositivos x usuario "+idUsuario);
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("from Tavusuariodisp a ");
		sb.append("where a.fiIdUsuario =:idUsuario ");
		Query q = sessionFactoryTav.getCurrentSession().createQuery(sb.toString());
		q.setBigInteger("idUsuario", idUsuario);
		
		
		return q.list();
	}

	@Override
	public void updateUsuario(Tavusuario usuario) {
		sessionFactoryTav.getCurrentSession().saveOrUpdate(usuario);
		
	}


}
