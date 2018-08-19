package com.avior.model.view;

import java.io.Serializable;

public class DispXAutoView implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String nroSerie;
	private String alias;
	private Long idCerca;
	private Long idCliente;
	
	
	public String getNroSerie() {
		return nroSerie;
	}
	public void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Long getIdCerca() {
		return idCerca;
	}
	public void setIdCerca(Long idCerca) {
		this.idCerca = idCerca;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	

}
