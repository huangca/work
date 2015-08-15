package org.hch.yhw.auction.action;
import java.util.*;

import com.opensymphony.xwork2.*;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.*;
import org.hch.yhw.auction.service.AuctionManager;
public class AlterBigKindSTwoAction extends BaseAction {
private String bigkindname;
private String kinddesc;
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

public String execute()throws AuctionException
{
	Map session = ActionContext.getContext().getSession();
	Integer id=(Integer)session.get("bigkindId");
	Bigkind bigkind=mgr.findBigKindByBigId(id);
	bigkind.setBigkindname(bigkindname);
	bigkind.setKinddesc(kinddesc);
	mgr.updateBigKind(bigkind);
	return SUCCESS;
}

}
