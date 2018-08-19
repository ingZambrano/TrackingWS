package com.avior.dao;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.avior.model.routine.RSchipDispositivo;
import com.avior.model.routine.RSultimoPunto;
import com.avior.model.tav.Tavcatdispositivo;
import com.avior.model.tav.Tavregisdispvista;
import com.avior.model.tav.Tavusuariodisp;

@Repository("dispositivoDAO")
public class DispositivoDAOImpl implements DispositivoDAO {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	@Qualifier("sessionFactoryTav")
	private SessionFactory sf;
	
	@Override
	public RSchipDispositivo getChipDisp(String idDispositivo) {
		
		log.info("Se busca el chip asociado al Dipositivo: "+idDispositivo);
		RSchipDispositivo ret;
		Query query = sf.getCurrentSession()
				.createSQLQuery("CALL RSchipDispositivo(:idDispositivo)")
				.addEntity(RSchipDispositivo.class)
				.setParameter("idDispositivo", idDispositivo);
		ret = (RSchipDispositivo) query.uniqueResult();
		log.info("Consulta: "+query.getQueryString());
		return ret;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tavusuariodisp> getDispXUsuario(String idUsuario) {
		
		log.info("Se buscan los dispositivos asociados al usuario: "+idUsuario);
		List<Tavusuariodisp> ret;
		StringBuilder sb = new StringBuilder();
		sb.append("from Tavusuariodisp a ");
		sb.append("where a.fiIdUsuario =:idUsuario");

		Query q = sf.getCurrentSession().createQuery(sb.toString());
		q.setParameter("idUsuario", new BigInteger(idUsuario));

		ret = (List<Tavusuariodisp>) q.list();
		log.info("Consulta: "+q.getQueryString());
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getDispXCerca(String idCerca) {

		SQLQuery q = sf.getCurrentSession().createSQLQuery(
				"select fcNumeroSerie from TAVcercaDisp where fiIdCerca = ?;");
		q.setString(0, idCerca);

		return q.list();
	}

	@Override
	public RSultimoPunto getUltimoPunto(String idDispositivo) {
		RSultimoPunto ret;
		Query query = sf.getCurrentSession()
				.createSQLQuery("CALL RSultimoPunto(:idDispositivo)")
				.addEntity(RSultimoPunto.class)
				.setParameter("idDispositivo", idDispositivo);

		ret = (RSultimoPunto) query.uniqueResult();

		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RSultimoPunto> getListaPuntos(String idDispositivo, Date fIni,
			Date fFin) {

		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HHmm");
		String fechaIni = sdf.format(fIni);
		String fechaFin = sdf.format(fFin);

		StringBuilder sb = new StringBuilder();
		sb.append("CALL RSconsultaPuntos(");
		sb.append("?, ?, ?)");

		Query q = sf.getCurrentSession().createSQLQuery(sb.toString())
				.addEntity(RSultimoPunto.class);
		q.setParameter(0, idDispositivo);
		q.setParameter(1, fechaIni);
		q.setParameter(2, fechaFin);

		return (List<RSultimoPunto>) q.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tavregisdispvista> getListaPuntosByQty(String idDispositivo,
			int cal) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("from Tavregisdispvista a ");
		sb.append("where a.fcNumeroSerie =:idDispositivo ");
		sb.append("order by a.fdFecha desc ");

		Query q = sf.getCurrentSession().createQuery(sb.toString());
		q.setParameter("idDispositivo", idDispositivo);
		q.setMaxResults(cal);
		// q.setParameter("cal", cal);

		return (List<Tavregisdispvista>) q.list();
	}

	@Override
	public boolean insertaDispositivo(Tavcatdispositivo tavCatDispositivo) {
		
		try{
			sf.getCurrentSession().saveOrUpdate(tavCatDispositivo);
		}catch(HibernateException e){
			return false;
		}
		
		return true;
	}

	@Override
	public Tavcatdispositivo getDispositivo(BigInteger fiIdDispositivo) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("from Tavcatdispositivo a ");
		sb.append("where a.fcNumeroserie =:fiIdDispositivo");
		Query q = sf.getCurrentSession().createQuery(sb.toString());
		q.setParameter("fiIdDispositivo", fiIdDispositivo.toString());
		
		Tavcatdispositivo t = (Tavcatdispositivo)q.uniqueResult();
		
		return t;
	}

}
