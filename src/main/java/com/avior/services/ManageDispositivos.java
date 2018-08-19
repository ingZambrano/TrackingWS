package com.avior.services;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.avior.model.view.RegistroView;
import com.avior.model.routine.RSchipDispositivo;
import com.avior.model.tav.Tavcatdispositivo;
import com.avior.model.tav.Tavusuario;
import com.avior.model.view.DispXUsuarioView;

public interface ManageDispositivos {

	
	//Metodos de la nueva base
	public RSchipDispositivo getChipDisp(String idDispositivo);
	public List<DispXUsuarioView> getDispositivosXUsuario(String idUsuario);
	public List<String> getDispXCerca(String idCerca);
	
	public RegistroView getUltimoPunto(String idDispositivo);
	public List<RegistroView> getListaPuntos(String idDispositivo, Date fIni, Date fFin);
	public List<RegistroView> getListaPuntosByQty(String idDispositivo, int cal);
	public Tavusuario getUsuario(String nombre);
	
	public boolean insertaDispositivo(Tavcatdispositivo tavCatDispositivo);
	public Tavcatdispositivo getDispositivo(BigInteger fiIdDispositivo);
	public boolean getStatusParking(BigInteger fiIdDispositivo);
}
