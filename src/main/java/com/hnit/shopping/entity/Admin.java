package com.hnit.shopping.entity;

public class Admin {
	private Integer aId;
	private String aName;
	private String aPwd;
	private String aRole;
	private Integer aState;
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaPwd() {
		return aPwd;
	}
	public void setaPwd(String aPwd) {
		this.aPwd = aPwd;
	}
	public String getaRole() {
		return aRole;
	}
	public void setaRole(String aRole) {
		this.aRole = aRole;
	}
	public Integer getaState() {
		return aState;
	}
	public void setaState(Integer aState) {
		this.aState = aState;
	}
	@Override
	public String toString() {
		return "Admin [aId=" + aId + ", aName=" + aName + ", aPwd=" + aPwd + ", aRole=" + aRole + ", aState=" + aState
				+ "]";
	}

}
