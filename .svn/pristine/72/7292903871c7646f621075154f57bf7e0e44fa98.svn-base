package com.avior.model.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class FenceIdView implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String name;
	private String id;
	private Long color;
	private String clientId;
	private List<Long> devices;
	private String polygon;

	public FenceIdView() {
		super();
	}

	
	public FenceIdView(FenceView f, List<String> devs){
		this.name = f.getNombre();
		this.id = f.getId().toString();
		this.clientId = f.getIdCliente().toString();
		this.devices = new ArrayList<Long>();
		for(String s: devs){
			if(s != null && !s.equals("null") && !s.equals("")){
				this.devices.add(Long.parseLong(s));
			}
		}
		 
		this.polygon = f.getPoligono();
		this.color = f.getColor();
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public List<Long> getDevices() {
		return devices;
	}


	public void setDevices(List<Long> devices) {
		this.devices = devices;
	}


	public String getPolygon() {
		return polygon;
	}


	public void setPolygon(String polygon) {
		this.polygon = polygon;
	}


	public Long getColor() {
		return color;
	}


	public void setColor(Long color) {
		this.color = color;
	}
	

}
