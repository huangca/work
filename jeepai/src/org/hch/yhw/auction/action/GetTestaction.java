package org.hch.yhw.auction.action;

public class GetTestaction {
private String bigkind;
public String getBigkind() {
	return bigkind;
}
public void setBigkind(String bigkind) {
	this.bigkind = bigkind;
}
public String getKind() {
	return kind;
}
public void setKind(String kind) {
	this.kind = kind;
}
private String kind;

public String execute(){
	System.out.println("传过来的值是bigkind="+bigkind);
	System.out.println("[-------------------]");
	System.out.println("传过来的值是kind="+kind);
	
	return "success";
}
}
