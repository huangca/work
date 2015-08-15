package org.hch.yhw.auction.action;
import java.util.*;

import com.opensymphony.xwork2.ActionContext;

import org.hch.yhw.auction.action.base.BaseActionInterface;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.Bigkind;
import org.hch.yhw.auction.model.Kind;
import org.hch.yhw.auction.service.AuctionManager;
public class AlterKindDetailAction extends BaseActionInterface{
private int id;
private Kind kind;
private int bigkid;
private List bigkind;


public List getBigkind() {
	return bigkind;
}
public void setBigkind(List bigkind) {
	this.bigkind = bigkind;
}
public int getBigkid() {
	return bigkid;
}
public void setBigkid(int bigkid) {
	this.bigkid = bigkid;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Kind getKind() {
	return kind;
}
public void setKind(Kind kind) {
	this.kind = kind;
}

public String execute() throws Exception
{
	Map session = ActionContext.getContext().getSession();
	setKind(mgr.findKindByIKind(id));
	setBigkind(mgr.findAllBigKind());
	session.put("kindId" , id);
	return SUCCESS;

}

}
