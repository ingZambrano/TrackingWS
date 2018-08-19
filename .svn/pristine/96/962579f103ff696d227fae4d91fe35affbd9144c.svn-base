package com.avior.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avior.model.tav.Tavcatcerca;
import com.avior.model.tav.Tavcercadisp;

@Repository("fencesDAO")
public class FencesDAOImpl implements FencesDAO {
	
	@Autowired
	@Qualifier("sessionFactoryTav")
	private SessionFactory sessionFactoryTav;

	@Override
	public String getPolyString(String idCerca){
		
		SQLQuery q2 = sessionFactoryTav
				.getCurrentSession()
				.createSQLQuery("SELECT ASTEXT(fdPoligono) FROM trackerBD.TAVcatCercas WHERE fiIdCerca = ?;");
		q2.setString(0,idCerca);
		String cerca = (String) q2.uniqueResult();
		return cerca;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tavcatcerca> getCercas(Long idCliente) {
		
		List<Tavcatcerca> ret;
		StringBuilder sb = new StringBuilder();
		 
		sb.append("from Tavcatcerca c ");
		sb.append("where c.tavUsuario.fiIdUsuario = ? ");
		
		Query q = sessionFactoryTav.getCurrentSession()
				.createQuery(sb.toString());
						
		q.setBigInteger(0, BigInteger.valueOf(idCliente));
		
		ret = q.list();
		
		
		return ret;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tavcercadisp> listCercasUsuario(Long idCliente, Long idCerca) {
		
		Query q = sessionFactoryTav.getCurrentSession()
				.createQuery("from Tavcercadisp d " +
						"where d.fiIdUsuario = ? and d.fiIdCerca = ? " +
						"and d.fiIdStatus = 1");
						
		q.setBigInteger(0, BigInteger.valueOf(idCliente));
		q.setLong(1, idCerca);
		
		return q.list();
	}

	@Override
	public Tavcatcerca crearCerca(Tavcatcerca cerca) {
		// TODO Auto-generated method stub
		
		Query q1 = sessionFactoryTav.getCurrentSession()
				.createSQLQuery("select max(fiIdCerca)+1 from TAVcatCercas;");
		BigInteger idCerca;
		
		idCerca = ((BigInteger)q1.uniqueResult());
		
		if(idCerca == null){
			idCerca = BigInteger.ONE;
		}
		
		cerca.setFiIdCerca(idCerca.toString());
		StringBuilder query= new StringBuilder();
		query.append("INSERT INTO trackerBD.TAVcatCercas (fiIdCerca, fcNombre, fcColor, fiArea, fdPoligono, fiIdStatus, fdFechaUltimaModificacion, fcUsuarioModifico)");
		query.append("VALUES (?, ?, ?, ?,GeomFromText( ? ), ?, ? , ?);");
	    
		
	    Query q2 = sessionFactoryTav.getCurrentSession()
	    		.createSQLQuery(query.toString());
	    q2.setBigInteger(0, idCerca);
	    q2.setString(1, cerca.getFcNombre());
	    q2.setString(2, cerca.getFcColor());
	    q2.setDouble(3, cerca.getFiArea());
	    q2.setString(4, cerca.getFdPoligono());
	    q2.setByte(5, cerca.getFiIdStatus());
	    q2.setDate(6, cerca.getFdFechaUltimaModificacion());
	    q2.setString(7, cerca.getFcUsuarioModifico());
	    
	    q2.executeUpdate();
		
	    return cerca;
	}

	@Override
	public void actualizaCerca(Tavcatcerca cerca) {
		// TODO Auto-generated method stub
		
		StringBuilder query = new StringBuilder();
		query.append("UPDATE trackerbd.TAVcatCercas ");
		query.append("SET fcNombre=?, fcColor=?, fiArea=?, fdPoligono=GeomFromText( ?), fiIdStatus=?, fdFechaUltimaModificacion=?, fcUsuarioModifico=? ");
		query.append("WHERE fiIdCerca=?;");
		
		Query q = sessionFactoryTav.getCurrentSession()
	    		.createSQLQuery(query.toString());
	    
	    q.setString(0, cerca.getFcNombre());
	    q.setString(1, cerca.getFcColor());
	    q.setDouble(2, cerca.getFiArea());
	    q.setString(3, cerca.getFdPoligono());
	    q.setByte(4, cerca.getFiIdStatus());
	    q.setDate(5, cerca.getFdFechaUltimaModificacion());
	    q.setString(6, cerca.getFcUsuarioModifico());
	    q.setString(7, cerca.getFiIdCerca());
	    
	    q.executeUpdate();
		
		
		
	}

	@Override
	public void insertaCercaDisp(Tavcercadisp cercaDisp) {
		// TODO Auto-generated method stub
		
		
		Query q1 = sessionFactoryTav.getCurrentSession()
				.createSQLQuery("select max(fiId)+1 from TAVcercaDisp;");
		BigInteger idCercaDisp = (BigInteger)q1.uniqueResult();
		
		if(idCercaDisp == null){
			idCercaDisp = BigInteger.ONE;
		}
		
		cercaDisp.setFiId(idCercaDisp.toString());
		
		sessionFactoryTav.getCurrentSession().persist(cercaDisp);
	
	}
	
	@Override
	public void actualizaCercaDisp(Tavcercadisp cercaDisp){
		
		sessionFactoryTav.getCurrentSession().saveOrUpdate(cercaDisp);
	
	}

	@Override
	public Tavcercadisp obtenercercaDisp(BigInteger fiIdCerca, BigInteger fiIdUsuario, String fcNumeroSerie){
		
		SQLQuery q = sessionFactoryTav
				.getCurrentSession()
				.createSQLQuery("select * from TAVcercaDisp where fiIdCerca = ? and fiIdUsuario = ? and fcNumeroSerie = ?; ")
				.addEntity(Tavcercadisp.class);
		q.setBigInteger(0, fiIdCerca);
		q.setBigInteger(1, fiIdUsuario);
		q.setString(2, fcNumeroSerie);
		
		Tavcercadisp ret =(Tavcercadisp) q.uniqueResult();
		
		
		return ret;
		
	}
	
	@Override
	@Transactional
	public void borrarTavCerca(Tavcercadisp tavCercaDisp){
		
		sessionFactoryTav.getCurrentSession().delete(tavCercaDisp);
		
	}

	@Override
	@Transactional
	public void deleteFence(Tavcatcerca tavCatCerca) {
		sessionFactoryTav.getCurrentSession().delete(tavCatCerca);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T consulta(Class<T> entidad, Serializable id) {
		
		return (T) sessionFactoryTav.getCurrentSession().get(Tavcatcerca.class, id);
	}

	@Override
	@Transactional
	public void deleteFenceDisp(String idCercaDisp) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("delete from TAVcercaDisp where fiIdCerca = ?; ");
		
		SQLQuery q = sessionFactoryTav
				.getCurrentSession()
				.createSQLQuery(sb.toString())
				.addEntity(Tavcercadisp.class);
		
		q.setString(0, idCercaDisp);
		
		q.executeUpdate();
	}
	
	
}
