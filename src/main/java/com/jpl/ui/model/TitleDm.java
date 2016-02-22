package com.jpl.ui.model;

public class TitleDm {
	

	private int titleId;
	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public int getFunctionalDetailsId() {
		return functionalDetailsId;
	}

	public void setFunctionalDetailsId(int functionalDetailsId) {
		this.functionalDetailsId = functionalDetailsId;
	}

	private String titleName;
	private int functionalDetailsId;

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nTitleDm : [");
		sb.append("\ntitle Id : " + this.titleId);
		sb.append("\ntitle name : " + this.titleName);
		sb.append("\nfunctional details id : " + this.functionalDetailsId );
		sb.append("]");
		return sb.toString();
	}

}
