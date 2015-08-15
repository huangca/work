package org.hch.yhw.auction.action;
import java.util.*;

import com.opensymphony.xwork2.*;

import org.hch.yhw.auction.action.base.BaseActionInterface;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.*;
import org.hch.yhw.auction.service.AuctionManager;
public class ChangeDateAction extends BaseActionInterface {

	public AuctionUser getAuctionUser() {
		return auctionUser;
	}

	public void setAuctionUser(AuctionUser auctionUser) {
		this.auctionUser = auctionUser;
	}

	private AuctionUser auctionUser;
	
	public String execute()throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		Integer id=(Integer)session.get("userId");
		if(auserMgr==null){System.out.println("auserMgrÎª¿Õ");}
	   setAuctionUser(auserMgr.findAuctionUserByUserId(id));
		
		return SUCCESS;
	}
	
}
