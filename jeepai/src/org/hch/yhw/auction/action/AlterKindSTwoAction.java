package org.hch.yhw.auction.action;
import java.util.*;

import com.opensymphony.xwork2.*;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.*;
import org.hch.yhw.auction.service.AuctionManager;
public class AlterKindSTwoAction extends BaseAction {
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public String getKindDesc() {
		return kindDesc;
	}
	public void setKindDesc(String kindDesc) {
		this.kindDesc = kindDesc;
	}
	private String kindName;
	private String kindDesc;
	private int bigkind;
	public int getBigkind() {
		return bigkind;
	}
	public void setBigkind(int bigkind) {
		this.bigkind = bigkind;
	}
	public String execute()throws AuctionException
	{
		Map session = ActionContext.getContext().getSession();
		Integer id=(Integer)session.get("kindId");
		Kind kind=mgr.findKindByIKind(id);
		System.out.println("---------------------------"+bigkind);
		//kind.setBigkind(mgr.findBigKindByBigId(bigkind));
		kind.setKindName(kindName);
		kind.setKindDesc(kindDesc);
		mgr.updateKind(kind);
		return SUCCESS;
	
	}
	

}
