package org.hch.yhw.auction.service;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.*;
public interface AuctionManagerToAuctionUser {

	AuctionUserBean findAuctionBeanByUserId(Integer id)throws AuctionException;
	
	AuctionUser findAuctionUserByUserId(Integer id)throws AuctionException;
	//
	void userUpdate(AuctionUser auctionUser) throws AuctionException;
	
	boolean findAuctionUserByUserName(String username)throws AuctionException;
    
	//
	AuctionUserBean getAuctionUserByUserName(String username)throws AuctionException;

	void sendEmail(AuctionUserBean auctionUserBean);
}
