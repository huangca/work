package org.hch.yhw.auction.action;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;

import org.hch.yhw.auction.action.base.BaseActionInterface;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.Bigkind;
import org.hch.yhw.auction.service.AuctionManager;
public class AlterBigKindDetailAction extends BaseActionInterface {
private int bigkindId;
private Bigkind bigkind;
public Bigkind getBigkind() {
	return bigkind;
}

public void setBigkind(Bigkind bigkind) {
	this.bigkind = bigkind;
}

public int getBigkindId() {
	return bigkindId;
}

public void setBigkindId(int bigkindId) {
	this.bigkindId = bigkindId;
}

public String execute() throws Exception
{
	Map session = ActionContext.getContext().getSession();
	bigkind=mgr.findBigKindByBigId(bigkindId);
	session.put("bigkindId" , bigkindId);
	return SUCCESS;

}

}
