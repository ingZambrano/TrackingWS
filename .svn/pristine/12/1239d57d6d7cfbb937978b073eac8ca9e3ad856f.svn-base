package com.avior.model.routine;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"codigoOk", "msgOk"})
public class RSchipDispositivo implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private BigDecimal fiIdChip;
	private String fcNumeroTelefonico;
	private int fiIdTipo;
	private String fcNombre;
	@JsonIgnore
	private String codigoOk;
	@JsonIgnore
	private String msgOk;
	
	public BigDecimal getFiIdChip() {
		return fiIdChip;
	}
	public void setFiIdChip(BigDecimal fiIdChip) {
		this.fiIdChip = fiIdChip;
	}
	public String getFcNumeroTelefonico() {
		return fcNumeroTelefonico;
	}
	public void setFcNumeroTelefonico(String fcNumeroTelefonico) {
		this.fcNumeroTelefonico = fcNumeroTelefonico;
	}
	public int getFiIdTipo() {
		return fiIdTipo;
	}
	public void setFiIdTipo(int fiIdTipo) {
		this.fiIdTipo = fiIdTipo;
	}
	public String getFcNombre() {
		return fcNombre;
	}
	public void setFcNombre(String fcNombre) {
		this.fcNombre = fcNombre;
	}
	
	
	public String getCodigoOk() {
		return codigoOk;
	}
	public void setCodigoOk(String codigoOk) {
		this.codigoOk = codigoOk;
	}
	public String getMsgOk() {
		return msgOk;
	}
	public void setMsgOk(String msgOk) {
		this.msgOk = msgOk;
	}
	
	
	
}
