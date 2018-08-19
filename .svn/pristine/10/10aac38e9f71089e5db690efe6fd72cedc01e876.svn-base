package com.avior.services;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avior.dao.DispositivoDAO;
import com.avior.dao.UserDAO;
import com.avior.model.view.RegistroView;
import com.avior.model.routine.RSchipDispositivo;
import com.avior.model.routine.RSultimoPunto;
import com.avior.model.tav.Tavcatdispositivo;
import com.avior.model.tav.Tavregisdispvista;
import com.avior.model.tav.Tavusuario;
import com.avior.model.tav.Tavusuariodisp;
import com.avior.model.view.DispXUsuarioView;

@Service("manageDispositivos")
@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
public class ManageDispositivosImpl implements ManageDispositivos {	

	private static final double voltMax = 4.32;
	private static final double voltMmin = 3.57;
	
	@Autowired
	private DispositivoDAO dispositivoDAO;
	
	@Autowired
	UserDAO userDao;


	@Override
	public RSchipDispositivo getChipDisp(String idDispositivo) {
		// TODO Auto-generated method stub
		return dispositivoDAO.getChipDisp(idDispositivo);
	}


	@Override
	public List<DispXUsuarioView> getDispositivosXUsuario(String idUsuario) {
		// TODO Auto-generated method stub
		
		List<DispXUsuarioView> ret = new ArrayList<DispXUsuarioView>();
		List<Tavusuariodisp> consultaDao = dispositivoDAO.getDispXUsuario(idUsuario);
		DispXUsuarioView dispXUs;
		
		RSchipDispositivo rschip; 
		
		for(Tavusuariodisp t: consultaDao){
			
			dispXUs = new DispXUsuarioView();
			dispXUs.setAlias(t.getFcAliasDispositivo());
			dispXUs.setContrato("");
			dispXUs.setFechaVenta(new Timestamp(t.getFdFechaVenta().getTime()));
			dispXUs.setNroSerie(Long.parseLong(t.getFcNumeroserie()));
			
			rschip = this.getChipDisp(t.getFcNumeroserie());			
			dispXUs.setTipoDispositivo(rschip.getFcNombre());
			dispXUs.setFiIdTipo(rschip.getFiIdTipo());
			
			Tavcatdispositivo tavCatDisp = dispositivoDAO.getDispositivo(new BigInteger(t.getFcNumeroserie()));
			try{
				if(tavCatDisp.getFiIdStatus() == 1){
					dispXUs.setStatus(true);
				}else{
					dispXUs.setStatus(false);
				}
				if(tavCatDisp.getFiStatus() == 1){
					dispXUs.setEstacionamiento(true);
				}else{
					dispXUs.setEstacionamiento(false);
				}
				
			}catch(NullPointerException e){
				dispXUs.setStatus(false);
				dispXUs.setEstacionamiento(false);
			}
			
			//Se agrega el estatus del modo estacionamiento
//			boolean me = this.getStatusParking(new BigInteger(dispXUs.getNroSerie().toString()));
//			dispXUs.setEstacionamiento(me);
			ret.add(dispXUs);
		}
		
		
		
		
		return ret;
	}


	//Nuevos
	@Override
	public RegistroView getUltimoPunto(String idDispositivo) {
		// TODO Auto-generated method stub

		RSultimoPunto ult = dispositivoDAO.getUltimoPunto(idDispositivo); 
		RegistroView ret = null;
		
		if(ult != null){
			ret = new RegistroView();
			ret.setAltura(ult.getFiAltura());
			ret.setDentroCerca(0);
			ret.setFecha(ult.getFdFecha());
			ret.setLatitud(ult.getFiLatitud());
			ret.setLongitud(ult.getFiLongitud());
			ret.setUltimaFecha(ult.getFdFecha());
			ret.setVelocidad(ult.getFiVelocidad());
			
			boolean bat = false;
			Byte b = ult.getFiBatConectada();
			if( b.intValue() == 1){
				bat = true;
			}else{
				bat = false;
			}				
			ret.setBatConectada(bat);
			
			String v = ult.getFcVoltaje();
			double voltaje = Double.parseDouble(v.substring(2, 6));
			
			
			ret.setPorcentajeBateria(this.normalizarVoltaje(voltaje));
			
		}
		return ret;
	}
	@Override
	public List<String> getDispXCerca(String idCerca){
		
		return dispositivoDAO.getDispXCerca(idCerca);
		
	}

	@Override
	public List<RegistroView> getListaPuntos(String idDispositivo, Date fIni,
			Date fFin) {	
		
		List<RSultimoPunto> listUlt = dispositivoDAO.getListaPuntos(idDispositivo, fIni, fFin);
		
		List<RegistroView> listRet = new ArrayList<RegistroView>();
		RegistroView r;
		for(RSultimoPunto ult: listUlt){
			r = new RegistroView();
			r.setAltura(ult.getFiAltura());
			r.setDentroCerca(0);
			r.setFecha(ult.getFdFecha());
			r.setLatitud(ult.getFiLatitud());
			r.setLongitud(ult.getFiLongitud());
			r.setUltimaFecha(ult.getFdFecha());
			r.setVelocidad(ult.getFiVelocidad());
			
			boolean bat = false;
			Byte b = ult.getFiBatConectada();
			if( b.intValue() == 1){
				bat = true;
			}else{
				bat = false;
			}				
			r.setBatConectada(bat);
			
			String v = ult.getFcVoltaje();
			double voltaje = Double.parseDouble(v.substring(2, 6));
			
			
			r.setPorcentajeBateria(this.normalizarVoltaje(voltaje));
			
			listRet.add(r);
		}
		
		
		return listRet;
	}

	@Override
	public Tavusuario getUsuario(String nombre) {
		// TODO Auto-generated method stub
		return userDao.getusuario(nombre);
	}

	@Override
	public List<RegistroView> getListaPuntosByQty(String idDispositivo, int cal) {
		
		List<Tavregisdispvista> lista = dispositivoDAO.getListaPuntosByQty(idDispositivo, cal);
		List<RegistroView> ret = new ArrayList<RegistroView>();
		RegistroView r;
		for(Tavregisdispvista t: lista){
			r = new RegistroView();
			
			r.setAltura(t.getFiAltura());
			r.setDentroCerca(0);
			r.setFecha(t.getFdFecha());
			r.setLatitud(t.getFiLatitud());
			r.setLongitud(t.getFiLongitud());
			r.setUltimaFecha(t.getFdFecha());
			r.setVelocidad(t.getFiVelocidad());
			
			
			boolean bat = false;
			Byte b = t.getFiBatConectada();
			if( b.intValue() == 1){
				bat = true;
			}else{
				bat = false;
			}	
			
			r.setBatConectada(bat);
			
			String v = t.getFcVoltaje();
			double voltaje = Double.parseDouble(v.substring(2, 6));
			
			
			r.setPorcentajeBateria(this.normalizarVoltaje(voltaje));
			
			
			ret.add(r);
		}
		
		
		
		
		return ret;
	}
	
	@Override
	@Transactional
	public boolean insertaDispositivo(Tavcatdispositivo tavCatDispositivo) {
		return dispositivoDAO.insertaDispositivo(tavCatDispositivo);
		
	}


	@Override
	@Transactional
	public Tavcatdispositivo getDispositivo(BigInteger fiIdDispositivo) {
		
		return dispositivoDAO.getDispositivo(fiIdDispositivo);
	}
	
	@Override
	public boolean getStatusParking(BigInteger fiIdDispositivo) {
		
		Tavcatdispositivo t = dispositivoDAO.getDispositivo(fiIdDispositivo);
		try{
			if(t != null){
				if(t.getFiStatus() == 1){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}catch(NullPointerException e){
			return false;
		}
		
	}


	private int normalizarVoltaje(double voltaje){
		
		double offSet = ManageDispositivosImpl.voltMax-ManageDispositivosImpl.voltMmin;
		
		double vNormalizado = voltaje-ManageDispositivosImpl.voltMmin;
		
		double porcentaje = vNormalizado/offSet*100;
		
		if(porcentaje > 100){
			return 100;
		}else{
			return (int)porcentaje;
		}		
		
		
	}

}
