package com.avior.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.avior.model.routine.RSchipDispositivo;
import com.avior.model.routine.RSultimoPunto;
import com.avior.model.tav.Tavcatdispositivo;
import com.avior.model.tav.Tavregisdispvista;
import com.avior.model.tav.Tavusuariodisp;

public interface DispositivoDAO {		
	
	//Metodos de la nueva base
	public RSchipDispositivo getChipDisp(String idDispositivo);
	public List<Tavusuariodisp> getDispXUsuario(String idUsuario);
	public List<String> getDispXCerca(String idCerca);
	
	public RSultimoPunto getUltimoPunto(String idDispositivo);
	public List<RSultimoPunto> getListaPuntos(String idDispositivo, Date fIni, Date fFin);
	public List<Tavregisdispvista> getListaPuntosByQty(String idDispositivo, int cal);
	
	public boolean insertaDispositivo(Tavcatdispositivo tavCatDispositivo);
	public Tavcatdispositivo getDispositivo(BigInteger fiIdDispositivo);
	
}
