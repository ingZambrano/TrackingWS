package com.avior.model.tav;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the tavusuariodisp database table.
 * 
 */
@Entity
@Table(name="TAVusuarioDisp")
public class Tavusuariodisp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String fiId;

	private String fcAliasDispositivo;

	private String fcNumeroserie;

	private String fcSerieChip;

	private String fcUsuarioModifico;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fdFechaUltimaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fdFechaVenta;

	private byte fiIdStatus;

	private BigInteger fiIdUsuario;

	private byte fiTiempoActualizacion;

	public Tavusuariodisp() {
	}

	public String getFiId() {
		return this.fiId;
	}

	public void setFiId(String fiId) {
		this.fiId = fiId;
	}

	public String getFcAliasDispositivo() {
		return this.fcAliasDispositivo;
	}

	public void setFcAliasDispositivo(String fcAliasDispositivo) {
		this.fcAliasDispositivo = fcAliasDispositivo;
	}

	public String getFcNumeroserie() {
		return this.fcNumeroserie;
	}

	public void setFcNumeroserie(String fcNumeroserie) {
		this.fcNumeroserie = fcNumeroserie;
	}

	public String getFcSerieChip() {
		return this.fcSerieChip;
	}

	public void setFcSerieChip(String fcSerieChip) {
		this.fcSerieChip = fcSerieChip;
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

	public Date getFdFechaVenta() {
		return this.fdFechaVenta;
	}

	public void setFdFechaVenta(Date fdFechaVenta) {
		this.fdFechaVenta = fdFechaVenta;
	}

	public byte getFiIdStatus() {
		return this.fiIdStatus;
	}

	public void setFiIdStatus(byte fiIdStatus) {
		this.fiIdStatus = fiIdStatus;
	}

	public BigInteger getFiIdUsuario() {
		return this.fiIdUsuario;
	}

	public void setFiIdUsuario(BigInteger fiIdUsuario) {
		this.fiIdUsuario = fiIdUsuario;
	}

	public byte getFiTiempoActualizacion() {
		return this.fiTiempoActualizacion;
	}

	public void setFiTiempoActualizacion(byte fiTiempoActualizacion) {
		this.fiTiempoActualizacion = fiTiempoActualizacion;
	}

}