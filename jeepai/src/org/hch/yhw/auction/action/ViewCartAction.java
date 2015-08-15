package org.hch.yhw.auction.action;

import java.util.List;
import java.util.Map;

import org.hch.yhw.auction.business.CartBean;
import org.hch.yhw.auction.service.AuctionManagerToYiItem;

import com.opensymphony.xwork2.ActionContext;
import org.hch.yhw.auction.action.base.BaseAction;

public class ViewCartAction extends BaseAction{
	//���ﳵ�����ʾ��Ϣ
	private String cartMessage;
	private List<CartBean> fromList;
//	private AuctionManagerToYiItem mgryiItem;
	public String getCartMessage() {
		return cartMessage;
	}
	public void setCartMessage(String cartMessage) {
		this.cartMessage = cartMessage;
	}
	public List<CartBean> getFromList() {
		return fromList;
	}
	public void setFromList(List<CartBean> fromList) {
		this.fromList = fromList;
	}/*
	public AuctionManagerToYiItem getMgryiItem() {
		return mgryiItem;
	}
	public void setMgryiItem(AuctionManagerToYiItem mgryiItem) {
		this.mgryiItem = mgryiItem;
	}*/
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map session =	ActionContext.getContext().getSession();
		fromList=(List<CartBean>)session.get("fromList");
		if(fromList==null){setCartMessage("��Ĺ��ﳵ�л�û����Ʒ");
	    return NONE;
		}
		else{
			setFromList(fromList);
			return SUCCESS;
	}
	}
	
	
	
}
