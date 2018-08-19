package com.avior.model.tav;

import java.io.Serializable;
import javax.persistence.*;


import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the tavcercadisp database table.
 * 
 */
@Entity
@Table(name="TAVcercaDisp")
public class Tavcercadisp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String fiId;
	
	private String fcNumeroSerie;

	private String fcUsuarioModifico;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fdFechaUltimaModificacion;

	private BigInteger fiIdCerca;

	private byte fiIdStatus;

	private BigInteger fiIdUsuario;
	
//	
//	@ManyToOne
//	@JoinColumn(name = "fiIdCerca", referencedColumnName = "fiIdCerca", insertable=false, updatable=false)
//	private Tavcatcerca tavCatCerca;
//

	public Tavcercadisp() {
	}


//	public Tavcatcerca getTavCatCerca() {
//		return tavCatCerca;
//	}
//
//
//
//	public void setTavCatCerca(Tavcatcerca tavCatCerca) {
//		this.tavCatCerca = tavCatCerca;
//	}



	public String getFiId() {
		return this.fiId;
	}

	public void setFiId(String fiId) {
		this.fiId = fiId;
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

	public Date getFdFechaUltimaModificacion() {
		return this.fdFechaUltimaModificacion;
	}

	public void setFdFechaUltimaModificacion(Date fdFechaUltimaModificacion) {
		this.fdFechaUltimaModificacion = fdFechaUltimaModificacion;
	}

	public BigInteger getFiIdCerca() {
		return this.fiIdCerca;
	}

	public void setFiIdCerca(BigInteger fiIdCerca) {
		this.fiIdCerca = fiIdCerca;
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

}