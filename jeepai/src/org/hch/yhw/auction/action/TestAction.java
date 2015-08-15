package org.hch.yhw.auction.action;

import java.util.List;
import java.util.Map;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.exception.AuctionException;

import com.opensymphony.xwork2.ActionContext;

public class TestAction extends BaseAction{


public String execute(){
	//查找所有的大类
//填充大类，通过与抓取策略，
	System.out.println("TestAction begin");
		Map session=ActionContext.getContext().getSession();
	try{session.put("bigkinds", mgr.getAllBigKindNotOther());
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}return SUCCESS;
}
}
