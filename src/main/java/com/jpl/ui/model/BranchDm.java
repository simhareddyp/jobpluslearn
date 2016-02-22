package com.jpl.ui.model;

public class BranchDm {
	private int branchId;
	private String branchCode;
	private String description;
	private int levelId;

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nBranchDm : [");
		sb.append("\nbranch id : " + this.branchId);
		sb.append("\nbranch code : " + this.branchCode);
		sb.append("\ndescription : " + this.description);
		sb.append("\nlevel id : " + this.levelId);
		sb.append("]");
		return sb.toString();
	}

}
