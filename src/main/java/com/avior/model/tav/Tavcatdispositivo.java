package com.avior.model.tav;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the tavcatdispositivos database table.
 * 
 */
@Entity
@Table(name="TAVcatDispositivos")
public class Tavcatdispositivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String fcNumeroserie;

	private String fcContrato;

	private String fcDescripcion;

	private String fcUsuarioModifico;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fdfechaFabricacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fdFechaUltimaModificacion;

	private BigInteger fiIdChip;

	private BigInteger fiIdDispositivo;

	private byte fiIdStatus;

	private byte fiIdTipo;
	
	private BigDecimal fiLatitud;

	private BigDecimal fiLongitud;
	
	private Byte fiStatus;
	
	

	public Tavcatdispositivo() {
	}

	
	
	public BigDecimal getFiLatitud() {
		return fiLatitud;
	}



	public void setFiLatitud(BigDecimal fiLatitud) {
		this.fiLatitud = fiLatitud;
	}



	public BigDecimal getFiLongitud() {
		return fiLongitud;
	}



	public void setFiLongitud(BigDecimal fiLongitud) {
		this.fiLongitud = fiLongitud;
	}



	public Byte getFiStatus() {
		return fiStatus;
	}



	public void setFiStatus(Byte fiStatus) {
		this.fiStatus = fiStatus;
	}



	public String getFcNumeroserie() {
		return this.fcNumeroserie;
	}

	public void setFcNumeroserie(String fcNumeroserie) {
		this.fcNumeroserie = fcNumeroserie;
	}

	public String getFcContrato() {
		return this.fcContrato;
	}

	public void setFcContrato(String fcContrato) {
		this.fcContrato = fcContrato;
	}

	public String getFcDescripcion() {
		return this.fcDescripcion;
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

	public Date getFdfechaFabricacion() {
		return this.fdfechaFabricacion;
	}

	public void setFdfechaFabricacion(Date fdfechaFabricacion) {
		this.fdfechaFabricacion = fdfechaFabricacion;
	}

	public Date getFdFechaUltimaModificacion() {
		return this.fdFechaUltimaModificacion;
	}

	public void setFdFechaUltimaModificacion(Date fdFechaUltimaModificacion) {
		this.fdFechaUltimaModificacion = fdFechaUltimaModificacion;
	}

	public BigInteger getFiIdChip() {
		return this.fiIdChip;
	}

	public void setFiIdChip(BigInteger fiIdChip) {
		this.fiIdChip = fiIdChip;
	}

	public BigInteger getFiIdDispositivo() {
		return this.fiIdDispositivo;
	}

	public void setFiIdDispositivo(BigInteger fiIdDispositivo) {
		this.fiIdDispositivo = fiIdDispositivo;
	}

	public byte getFiIdStatus() {
		return this.fiIdStatus;
	}

	public void setFiIdStatus(byte fiIdStatus) {
		this.fiIdStatus = fiIdStatus;
	}

	public byte getFiIdTipo() {
		return this.fiIdTipo;
	}

	public void setFiIdTipo(byte fiIdTipo) {
		this.fiIdTipo = fiIdTipo;
	}

}