package com.avior.model.web;

import javax.validation.constraints.NotNull;

public class LinkClientDev {

	@NotNull
	private Long clientId;
	@NotNull
	private Long nroserie;
	
	
	
	
	//----------------------------Getters and setters
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getNroserie() {
		return nroserie;
	}
	public void setNroserie(Long nroserie) {
		this.nroserie = nroserie;
	}
	
	
}
