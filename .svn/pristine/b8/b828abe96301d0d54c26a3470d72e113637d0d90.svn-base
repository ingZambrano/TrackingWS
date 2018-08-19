package com.avior.model.tav;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the tavregisdispvistas database table.
 * 
 */
@Entity
@Table(name="TAVregisDispVistas")
@NamedQuery(name="Tavregisdispvista.findAll", query="SELECT t FROM Tavregisdispvista t")
public class Tavregisdispvista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String fiIdOriginal;

	private String fcNoSatelite;

	private String fcNumeroSerie;

	private String fcUsuarioModifico;

	private String fcVoltaje;

	private Timestamp fdFecha;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fdFechaUltimaModificacion;

	private BigDecimal fiAltura;

	private byte fiBatConectada;

	private BigDecimal fiLatitud;

	private BigDecimal fiLongitud;

	private Byte fiPuntoValido;

	private BigDecimal fiVelocidad;

	public Tavregisdispvista() {
	}

	public String getFiIdOriginal() {
		return this.fiIdOriginal;
	}

	public void setFiIdOriginal(String fiIdOriginal) {
		this.fiIdOriginal = fiIdOriginal;
	}

	public String getFcNoSatelite() {
		return this.fcNoSatelite;
	}

	public void setFcNoSatelite(String fcNoSatelite) {
		this.fcNoSatelite = fcNoSatelite;
	}

	public String getFcNumeroSerie() {
		return this.fcNumeroSerie;
	}

	public void setFcNumeroSerie(String fcNumeroSerie) {
		this.fcNumeroSerie = fcNumeroSerie;
	}

	public String getFcUsuarioModifico() {
		return this.fcUsuarioModifico;
	}

	public void setFcUsuarioModifico(String fcUsuarioModifico) {
		this.fcUsuarioModifico = fcUsuarioModifico;
	}

	public String getFcVoltaje() {
		return this.fcVoltaje;
	}

	public void setFcVoltaje(String fcVoltaje) {
		this.fcVoltaje = fcVoltaje;
	}

	public Timestamp getFdFecha() {
		return this.fdFecha;
	}

	public void setFdFecha(Timestamp fdFecha) {
		this.fdFecha = fdFecha;
	}

	public Date getFdFechaUltimaModificacion() {
		return this.fdFechaUltimaModificacion;
	}

	public void setFdFechaUltimaModificacion(Date fdFechaUltimaModificacion) {
		this.fdFechaUltimaModificacion = fdFechaUltimaModificacion;
	}

	public BigDecimal getFiAltura() {
		return this.fiAltura;
	}

	public void setFiAltura(BigDecimal fiAltura) {
		this.fiAltura = fiAltura;
	}

	public byte getFiBatConectada() {
		return this.fiBatConectada;
	}

	public void setFiBatConectada(byte fiBatConectada) {
		this.fiBatConectada = fiBatConectada;
	}

	public BigDecimal getFiLatitud() {
		return this.fiLatitud;
	}

	public void setFiLatitud(BigDecimal fiLatitud) {
		this.fiLatitud = fiLatitud;
	}

	public BigDecimal getFiLongitud() {
		return this.fiLongitud;
	}

	public void setFiLongitud(BigDecimal fiLongitud) {
		this.fiLongitud = fiLongitud;
	}

	
	public BigDecimal getFiVelocidad() {
		return this.fiVelocidad;
	}

	public void setFiVelocidad(BigDecimal fiVelocidad) {
		this.fiVelocidad = fiVelocidad;
	}

	public Byte getFiPuntoValido() {
		return fiPuntoValido;
	}

	public void setFiPuntoValido(Byte fiPuntoValido) {
		this.fiPuntoValido = fiPuntoValido;
	}
	
	

}