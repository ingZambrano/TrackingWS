package com.avior.model.tav;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TAVusuarios")
public class Tavusuario implements Serializable,
		org.springframework.security.core.userdetails.UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(insertable=false, updatable=false)
	private String fiIdUsuario;

	
	private String fcCorreoUsuario;

	private String fcPassword;

	private String fcUsuarioModifico;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fdFechaUltimaConexion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fdFechaUltimaModificacion;

	private byte fiIdStatus;

	private byte fiIntentosFallidos;

	@ManyToOne
	@JoinColumn(name = "fiIdUsuario", referencedColumnName = "fiIdUsuario", insertable=false, updatable=false)
	private Tavperfilusuario perfiles;
	
	

	// Metodos para Srping Security

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();

		auth.add((GrantedAuthority) this.perfiles);

		return auth;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.fcPassword;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.fcCorreoUsuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	//Getters and setters
	
	

	public Tavusuario() {
	}

	public Tavperfilusuario getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(Tavperfilusuario perfiles) {
		this.perfiles = perfiles;
	}

	public String getFiIdUsuario() {
		return this.fiIdUsuario;
	}

	public void setFiIdUsuario(String fiIdUsuario) {
		this.fiIdUsuario = fiIdUsuario;
	}

	public String getFcCorreoUsuario() {
		return this.fcCorreoUsuario;
	}

	public void setFcCorreoUsuario(String fcCorreoUsuario) {
		this.fcCorreoUsuario = fcCorreoUsuario;
	}

	public String getFcPassword() {
		return this.fcPassword;
	}

	public void setFcPassword(String fcPassword) {
		this.fcPassword = fcPassword;
	}

	public String getFcUsuarioModifico() {
		return this.fcUsuarioModifico;
	}

	public void setFcUsuarioModifico(String fcUsuarioModifico) {
		this.fcUsuarioModifico = fcUsuarioModifico;
	}

	public Date getFdFechaUltimaConexion() {
		return this.fdFechaUltimaConexion;
	}

	public void setFdFechaUltimaConexion(Date fdFechaUltimaConexion) {
		this.fdFechaUltimaConexion = fdFechaUltimaConexion;
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

	public byte getFiIntentosFallidos() {
		return this.fiIntentosFallidos;
	}

	public void setFiIntentosFallidos(byte fiIntentosFallidos) {
		this.fiIntentosFallidos = fiIntentosFallidos;
	}

}