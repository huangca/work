package org.hch.yhw.auction.action;
import java.util.*;

import com.opensymphony.xwork2.*;

import org.hch.yhw.auction.action.base.BaseActionInterface;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.*;
import org.hch.yhw.auction.service.AuctionManager;
public class ChangeDateSTwoAction extends BaseActionInterface {
	
	private String realName;
	private String email;
	private String address;
	private String postcode;
	private String telphone;
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}


	
	public String execute()throws AuctionException
	{
		Map session = ActionContext.getContext().getSession();
		Integer id=(Integer)session.get("userId");
		AuctionUser auctionUsert=auserMgr.findAuctionUserByUserId(id);
		auctionUsert.setRealName(realName);
		auctionUsert.setEmail(email);
		auctionUsert.setAddress(address);
		auctionUsert.setPostcode(postcode);
		auctionUsert.setTelphone(telphone);
		
	    auserMgr.userUpdate(auctionUsert);
	    
	    
	    
		return SUCCESS;
	}

	

}
