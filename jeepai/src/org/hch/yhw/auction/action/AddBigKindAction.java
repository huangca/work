package org.hch.yhw.auction.action;

import java.util.Map;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.exception.AuctionException;

import com.opensymphony.xwork2.ActionContext;

public class AddBigKindAction extends BaseAction{
    private String bigkindname;
	private String kinddesc;
	private String vercode;
	
	
	public String getBigkindname() {
		return bigkindname;
	}


	public void setBigkindname(String bigkindname) {
		this.bigkindname = bigkindname;
	}


	public String getKinddesc() {
		return kinddesc;
	}


	public void setKinddesc(String kinddesc) {
		this.kinddesc = kinddesc;
	}


	public String getVercode() {
		return vercode;
	}


	public void setVercode(String vercode) {
		this.vercode = vercode;
	}


	public String execute(){
		Map session = ActionContext.getContext().getSession();
		String ver2 = (String)session.get("rand");
		session.put("rand" , null);
		if (vercode.equalsIgnoreCase(ver2))
		{				
		////缺少一个参数大类别ID
			System.out.println(bigkindname);
			try {
				mgr.addBigKind(bigkindname , kinddesc);
			} catch (AuctionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SUCCESS;
		}
		else
		{
			addActionError("验证码不匹配,请重新输入");
			return INPUT;
		}
	
	}
	
}
