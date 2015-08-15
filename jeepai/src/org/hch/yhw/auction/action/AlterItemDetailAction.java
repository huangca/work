package org.hch.yhw.auction.action;
import java.util.*;

import com.opensymphony.xwork2.*;

import org.hch.yhw.auction.action.base.BaseActionInterface;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.*;
import org.hch.yhw.auction.service.AuctionManager;
import org.hch.yhw.auction.business.ItemBean;

public class AlterItemDetailAction extends BaseActionInterface {
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public ItemBean getItem() {
		return item;
	}
	public void setItem(ItemBean item) {
		this.item = item;
	}
	public List getKindList() {
		return kindList;
	}
	public void setKindList(List kindList) {
		this.kindList = kindList;
	}
	private int itemId;
	private ItemBean item;
	private List kindList;
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
private Kind kind;

	public Kind getKind() {
	return kind;
}
public void setKind(Kind kind) {
	this.kind = kind;
}
	public String execute()throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		setItem(mgr.getItem(itemId));
		setKindList(mgr.getAllKind());
		setKind(mgr.getItemById(itemId).getKind());
		session.put("itemId" , itemId);
		return SUCCESS;
		
	}
	
}
