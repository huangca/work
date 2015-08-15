package org.hch.yhw.auction.action;

import java.util.List;
import java.util.Map;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.business.CartBean;

import com.opensymphony.xwork2.ActionContext;

public class ClearCartAction extends BaseAction {
//	private int number;
	private List<CartBean> fromList;
	public List<CartBean> getFromList() {
		return fromList;
	}

	public void setFromList(List<CartBean> fromList) {
		this.fromList = fromList;
	}

		@Override
	public String execute()  throws Exception{
		//System.out.println("Î»ÖÃClearCartAction");
		Map session = ActionContext.getContext().getSession();
	    fromList=( List<CartBean>)session.get("fromList");
	  //  if(fromList==null){System.out.println("Î»ÖÃ1fromListÎªNULL");}
	    if(fromList!=null){
			fromList.clear();
			session.put("fromList", fromList);
			setFromList(fromList);
			session.put("summomey", "0.0");
		}
		
	
	    return SUCCESS;
	}

}
