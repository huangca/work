package org.hch.yhw.auction.action;
import java.util.*;

import com.opensymphony.xwork2.*;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.action.base.BaseActionInterface;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.*;
import org.hch.yhw.auction.service.AuctionManager;
import org.hch.yhw.auction.business.ItemBean;
public class AlterYiItemDetailAction  extends BaseAction {
private int itemId;
private YiItemBean yiItemBean;
private List kindList;
private Kind kind;
private List stateList;
private State state;
private int kid;
private int bigkid;


public int getKid() {
	return kid;
}

public void setKid(int kid) {
	this.kid = kid;
}

public int getBigkid() {
	return bigkid;
}

public void setBigkid(int bigkid) {
	this.bigkid = bigkid;
}

public List getStateList() {
	return stateList;
}

public void setStateList(List stateList) {
	this.stateList = stateList;
}

public State getState() {
	return state;
}

public void setState(State state) {
	this.state = state;
}

public Kind getKind() {
	return kind;
}

public void setKind(Kind kind) {
	this.kind = kind;
}

public List getKindList() {
	return kindList;
}

public void setKindList(List kindList) {
	this.kindList = kindList;
}

public YiItemBean getYiItemBean() {
	return yiItemBean;
}

public void setYiItemBean(YiItemBean yiItemBean) {
	this.yiItemBean = yiItemBean;
}

public int getItemId() {
	return itemId;
}

public void setItemId(int itemId) {
	this.itemId = itemId;
}
public String execute()throws Exception
{
	Map session = ActionContext.getContext().getSession();
	setYiItemBean(mgryiItem.getYiItem(itemId));
	setKindList(mgr.getAllKind());
	setKind(mgryiItem.getYiItemById(itemId).getKind());
	setStateList(mgryiItem.getAllState());
	setState(mgryiItem.getYiItemById(itemId).getItemState());
	session.put("YiItemId" , itemId);
	return SUCCESS;
	
}

}
