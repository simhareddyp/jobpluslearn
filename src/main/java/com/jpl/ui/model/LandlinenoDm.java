package com.jpl.ui.model;

public class LandlinenoDm {

	private int LandlinenoId;
	private String countrystdcode;
	private int countryId;
	public int getLandlinenoId() {
		return LandlinenoId;
	}
	public void setLandlinenoId(int landlinenoId) {
		LandlinenoId = landlinenoId;
	}
	public String getCountrystdcode() {
		return countrystdcode;
	}
	public void setCountrystdcode(String countrystdcode) {
		this.countrystdcode = countrystdcode;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nLandlinenoDm : [");
		sb.append("\nlandlineno Id : " + this.LandlinenoId);
		sb.append("\ncountry stdcode : " + this.countrystdcode);
		sb.append("\ncountry id : " + this.countryId);
		sb.append("]");
		return sb.toString();
	}

	
}
