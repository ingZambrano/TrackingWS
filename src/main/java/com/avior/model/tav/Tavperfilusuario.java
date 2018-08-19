package com.avior.model.tav;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the tavperfilusuario database table.
 * 
 */
@Entity
@Table(name="TAVperfilUsuario")
public class Tavperfilusuario implements Serializable, GrantedAuthority {
	private static final long serialVersionUID = 1L;

	@Id
	private String fiId;

	private String fcUsuarioModifico;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fdFechaUltimaModificacion;

	
	@Column(name = "fiIdPerfil", insertable = false, updatable = false)
	private byte fiIdPerfil;

	private byte fiIdStatus;

	private BigInteger fiIdUsuario;
	
	@ManyToOne
	@JoinColumn(name = "fiIdPerfil", referencedColumnName = "fiId")
	Tavcatperfile tavCatPerfil;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return tavCatPerfil.getFcNombre();
	}

	

	public Tavperfilusuario() {
	}

	
	
	public Tavcatperfile getTavCatPerfil() {
		return tavCatPerfil;
	}



	public void setTavCatPerfil(Tavcatperfile tavCatPerfil) {
		this.tavCatPerfil = tavCatPerfil;
	}



	public String getFiId() {
		return this.fiId;
	}

	public void setFiId(String fiId) {
		this.fiId = fiId;
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

	public byte getFiIdPerfil() {
		return this.fiIdPerfil;
	}

	public void setFiIdPerfil(byte fiIdPerfil) {
		this.fiIdPerfil = fiIdPerfil;
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