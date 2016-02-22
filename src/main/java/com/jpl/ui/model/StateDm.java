package com.jpl.ui.model;

public class StateDm {

	private int stateId;
	private int countryId;
	private String stateNm;
	private String stateCd;

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getStateNm() {
		return stateNm;
	}

	public void setStateNm(String stateNm) {
		this.stateNm = stateNm;
	}

	public String getStateCd() {
		return stateCd;
	}

	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nStateDm : [");
		sb.append("\nstate Id : " + this.stateId);
		sb.append("\ncountry id : " + this.countryId);
		sb.append("\nstate cd : " + this.stateCd);
		sb.append("\nstate name : " + this.stateNm);
		sb.append("]");
		return sb.toString();
	}
}
