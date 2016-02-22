package com.jpl.ui.model;

public class LevelDm {

	private int levelId;
	private String levelCode;
	private String description;

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
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
		sb.append("\nLevelDm : [");
		sb.append("\nlevel id : " + this.levelId);
		sb.append("\nlevel code : " + this.levelCode);
		sb.append("\ndescription  : " + this.description);
		sb.append("]");
		return sb.toString();
	}
}
