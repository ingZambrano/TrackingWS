package com.avior.model.tav;

import java.io.Serializable;
import javax.persistence.*;


import java.util.Date;


/**
 * The persistent class for the tavcatcercas database table.
 * 
 */
@Entity
@Table(name="TAVcatCercas")
public class Tavcatcerca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String fiIdCerca;

	private String fcColor;

	private String fcNombre;

	private String fcUsuarioModifico;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fdFechaUltimaModificacion;

	private String fdPoligono;

	private Double fiArea;

	private byte fiIdStatus;
	
	@ManyToOne
	@JoinColumn(name = "fcUsuarioModifico", referencedColumnName = "fcCorreoUsuario", insertable=false, updatable=false)
	private Tavusuario tavUsuario;
	
	
	

	public Tavusuario getTavUsuario() {
		return tavUsuario;
	}

	public void setTavUsuario(Tavusuario tavUsuario) {
		this.tavUsuario = tavUsuario;
	}

	public Tavcatcerca() {
	}

	public String getFiIdCerca() {
		return this.fiIdCerca;
	}

	public void setFiIdCerca(String fiIdCerca) {
		this.fiIdCerca = fiIdCerca;
	}

	public String getFcColor() {
		return this.fcColor;
	}

	public void setFcColor(String fcColor) {
		this.fcColor = fcColor;
	}

	public String getFcNombre() {
		return this.fcNombre;
	}

	public void setFcNombre(String fcNombre) {
		this.fcNombre = fcNombre;
	}

	public String getFcUsuarioModifico() {
		return this.fcUsuarioModifico;
	}

	public void setFcUsuarioModifico(String fcUsuarioModifico) {
		this.fcUsuarioModifico = fcUsuarioModifico;
	}

	public Date getFdFechaUltimaModificacion() {
		return this.fdFechaUltimaModificacion;
	}

	public void setFdFechaUltimaModificacion(Date fdFechaUltimaModificacion) {
		this.fdFechaUltimaModificacion = fdFechaUltimaModificacion;
	}

	
	public String getFdPoligono() {
		return fdPoligono;
	}

	public void setFdPoligono(String fdPoligono) {
		this.fdPoligono = fdPoligono;
	}

	

	public Double getFiArea() {
		return fiArea;
	}

	public void setFiArea(Double fiArea) {
		this.fiArea = fiArea;
	}

	public byte getFiIdStatus() {
		return this.fiIdStatus;
	}

	public void setFiIdStatus(byte fiIdStatus) {
		this.fiIdStatus = fiIdStatus;
	}

}