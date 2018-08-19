package com.avior.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import com.avior.model.tav.Tavcatcerca;
import com.avior.model.tav.Tavcercadisp;

public interface FencesDAO {
	//Nueva base
	public String getPolyString(String idCerca);
	public List<Tavcatcerca> getCercas(Long idCliente);
	public List<Tavcercadisp> listCercasUsuario(Long idCliente, Long idCerca);
	public Tavcatcerca crearCerca(Tavcatcerca cerca);
	public void actualizaCerca(Tavcatcerca cerca);
	public void insertaCercaDisp(Tavcercadisp cercaDisp);
	public void actualizaCercaDisp(Tavcercadisp cercaDisp);
	public Tavcercadisp obtenercercaDisp(BigInteger fiIdCerca, BigInteger fiIdUsuario, String fcNumeroSerie);
	public void borrarTavCerca(Tavcercadisp tavCercaDisp);
	public void deleteFence(Tavcatcerca tavCatCerca);
	public <T> T consulta(Class<T> entidad, Serializable id);
	public void deleteFenceDisp(String idCercaDisp);
	
}
