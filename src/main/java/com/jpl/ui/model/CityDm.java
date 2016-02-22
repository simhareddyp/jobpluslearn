package com.jpl.ui.model;

public class CityDm {

	private int cityId;
	private String cityNm;
	private int stateId;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityNm() {
		return cityNm;
	}

	public void setCityNm(String cityNm) {
		this.cityNm = cityNm;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nCityDm : [");
		sb.append("\ncity Id : " + this.cityId);
		sb.append("\ncity name : " + this.cityNm);
		sb.append("\nstate id : " + this.stateId);
		sb.append("]");
		return sb.toString();
	}

}
