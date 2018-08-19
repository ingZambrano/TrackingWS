package com.avior.model.tav;

import java.io.Serializable;
import javax.persistence.*;



import java.util.Date;

@Entity
@Table(name="TAVcatPerfiles")
public class Tavcatperfile implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private byte fiId;

	
	private String fcNombre;

	private String fcDescripcion;

	private String fcUsuarioModifico;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fdFechaUltimaModificacion;

	private byte fiIdStatus;

	public Tavcatperfile() {
	}

	public byte getFiId() {
		return this.fiId;
	}

	public void setFiId(byte fiId) {
		this.fiId = fiId;
	}

	
	

	
	public String getFcNombre() {
		return fcNombre;
	}

	public void setFcNombre(String fcNombre) {
		this.fcNombre = fcNombre;
	}

	public String getFcDescripcion() {
		return fcDescripcion;
	}

	public void setFcDescripcion(String fcDescripcion) {
		this.fcDescripcion = fcDescripcion;
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

	public byte getFiIdStatus() {
		return this.fiIdStatus;
	}

	public void setFiIdStatus(byte fiIdStatus) {
		this.fiIdStatus = fiIdStatus;
	}


}