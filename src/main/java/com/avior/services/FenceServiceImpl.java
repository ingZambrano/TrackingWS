package com.avior.services;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avior.dao.FencesDAO;
import com.avior.model.tav.Tavcatcerca;
import com.avior.model.tav.Tavcercadisp;
import com.avior.model.view.FenceView;

@Service("fenceService")
public class FenceServiceImpl implements FenceService {	
	
	@Autowired
	FencesDAO fencesDAO;	
	
	@Override
	@Transactional
	public List<FenceView> listCercas(Long idCliente) {
		
		List<FenceView> ret = new ArrayList<FenceView>();
		
		List<Tavcatcerca> listCercas = (List<Tavcatcerca>) fencesDAO.getCercas(idCliente);
		
		FenceView fv;
		for(Tavcatcerca t: listCercas){
			
			fv = new FenceView();
			boolean status = false;
			
			fv.setArea(t.getFiArea());
			fv.setColor(Long.valueOf(t.getFcColor()));
			
			if(t.getFiIdStatus() == 1){
				status = true;
			}else{
				status = false;
			}
			fv.setEnabled(status);
			
			fv.setId(Long.parseLong(t.getFiIdCerca()));
			fv.setIdCliente(Long.parseLong(t.getTavUsuario().getFiIdUsuario()));
			fv.setNombre(t.getFcNombre());
			
			String poligono = fencesDAO.getPolyString(t.getFiIdCerca());
			fv.setPoligono(poligono);			
			//fv.setPoligono(t.getTavCatCerca().getFdPoligono());
			
			ret.add(fv);
		}
		
		
		
		return ret;
	}

	@Override
	@Transactional
	public List<Tavcercadisp> listCercasUsuario(Long idCliente, Long id) {
		// TODO Auto-generated method stub
		return fencesDAO.listCercasUsuario(idCliente, id);
	}

	@Override
	@Transactional
	public Tavcatcerca crearCerca(Tavcatcerca cerca) {
		// TODO Auto-generated method stub
		return fencesDAO.crearCerca(cerca);
	}

	@Override
	@Transactional
	public void actualizaCerca(Tavcatcerca cerca) {
		// TODO Auto-generated method stub
		fencesDAO.actualizaCerca(cerca);
	}

	@Override
	@Transactional
	public void insertaCercaDisp(Tavcercadisp cercaDisp) {
		// TODO Auto-generated method stub
		fencesDAO.insertaCercaDisp(cercaDisp);
	}
	
	@Override
	@Transactional
	public void actualizaCercaDisp(Tavcercadisp cercaDisp){
		fencesDAO.actualizaCercaDisp(cercaDisp);
	}
	
	@Override
	@Transactional
	public Tavcercadisp obtenercercaDisp(BigInteger fiIdCerca, BigInteger fiIdUsuario, String fcNumeroSerie){
		return fencesDAO.obtenercercaDisp(fiIdCerca, fiIdUsuario, fcNumeroSerie);
	}
	
	@Override
	@Transactional
	public void borrarTavCerca(Tavcercadisp tavCercaDisp){
		fencesDAO.borrarTavCerca(tavCercaDisp);
	}

	@Override
	@Transactional
	public void deleteFence(Tavcatcerca tavCatCerca) {
		fencesDAO.deleteFence(tavCatCerca);
		
	}

	@Override
	@Transactional
	public <T> T consulta(Class<T> entidad, Serializable id) {
		// TODO Auto-generated method stub
		return fencesDAO.consulta(entidad, id);
	}

	@Override
	public void deleteFenceDisp(String idCercaDisp) {
		fencesDAO.deleteFenceDisp(idCercaDisp);
		
	}
}
