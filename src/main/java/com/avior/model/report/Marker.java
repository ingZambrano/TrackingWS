package com.avior.model.report;

public class Marker {
	private String cName;
	private Double mark;	
	
	@Override
	public String toString() {
		return "Marker [cName=" + cName + ", mark=" + mark + "]";
	}
	
	
	public Marker(String cName, Double mark) {
		super();
		this.cName = cName;
		this.mark = mark;
	}
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Double getMark() {
		return mark;
	}
	public void setMark(Double mark) {
		this.mark = mark;
	}
	
	
}
