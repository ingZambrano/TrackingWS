package com.avior.model.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class RegistroView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idregistros;
	
	private Timestamp ultimaFecha; 
	
	private Integer dentroCerca;
	
	private BigDecimal altura;
	
	private Timestamp fecha;
	
	private BigDecimal latitud;
	
	private BigDecimal longitud;
	
	private BigDecimal velocidad;
	
	private Integer porcentajeBateria;
	
	private boolean batConectada;
	
	private String alias;
	

	

	public Integer getPorcentajeBateria() {
		return porcentajeBateria;
	}

	public void setPorcentajeBateria(Integer porcentajeBateria) {
		this.porcentajeBateria = porcentajeBateria;
	}

	public boolean isBatConectada() {
		return batConectada;
	}

	public void setBatConectada(boolean batConectada) {
		this.batConectada = batConectada;
	}

	public Long getIdregistros() {
		return idregistros;
	}

	public void setIdregistros(Long idregistros) {
		this.idregistros = idregistros;
	}

	public Timestamp getUltimaFecha() {
		return ultimaFecha;
	}

	public void setUltimaFecha(Timestamp ultimaFecha) {
		this.ultimaFecha = ultimaFecha;
	}

	public Integer getDentroCerca() {
		return dentroCerca;
	}

	public void setDentroCerca(Integer dentroCerca) {
		this.dentroCerca = dentroCerca;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getLatitud() {
		return latitud;
	}

	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}

	public BigDecimal getLongitud() {
		return longitud;
	}

	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

	public BigDecimal getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(BigDecimal velocidad) {
		this.velocidad = velocidad;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	

}
