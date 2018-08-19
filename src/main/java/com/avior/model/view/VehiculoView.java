package com.avior.model.view;

public class VehiculoView {
	
	private Long id;
	private String alias;
	private Long cerca;
	
	
	public VehiculoView(Long id, String alias, Long cerca) {
		super();
		this.id = id;
		this.alias = alias;
		this.cerca = cerca;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Long getCerca() {
		return cerca;
	}
	public void setCerca(Long cerca) {
		this.cerca = cerca;
	}


}
