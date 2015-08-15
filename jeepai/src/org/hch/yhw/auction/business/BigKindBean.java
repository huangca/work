package org.hch.yhw.auction.business;

public class BigKindBean {
	private int id;
	private String bigKindName;
	private String bigKindDesc;
	public BigKindBean() {
	
	}
	
	public BigKindBean(int id, String bigKindName, String bigKindDesc) {
	
		this.id = id;
		this.bigKindName = bigKindName;
		this.bigKindDesc = bigKindDesc;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBigKindName() {
		return bigKindName;
	}
	public void setBigKindName(String bigKindName) {
		this.bigKindName = bigKindName;
	}
	public String getBigKindDesc() {
		return bigKindDesc;
	}
	public void setBigKindDesc(String bigKindDesc) {
		this.bigKindDesc = bigKindDesc;
	}
	
	
}
