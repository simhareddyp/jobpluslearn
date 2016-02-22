package com.jpl.ui.model;

public class CountryDm {

	private int countryId;
	private String countryName;
	private String countryCode;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nCountryDm : [");
		sb.append("\ncountry id : " + this.countryId);
		sb.append("\ncountry name : " + this.countryName);
		sb.append("\ncountry code : " + this.countryCode);

		sb.append("]");
		return sb.toString();
	}

}





