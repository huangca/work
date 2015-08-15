package org.hch.yhw.auction.action;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.business.AuctionUserBean;
import org.hch.yhw.auction.exception.AuctionException;

public class FindPasswordAction extends BaseAction{
private String username;
private int questionid;
private String answer;
public String getUsername() {
	return username;
}
public int getQuestionid() {
	return questionid;
}
public String getAnswer() {
	return answer;
}
public void setUsername(String username) {
	this.username = username;
}
public void setQuestionid(int questionid) {
	this.questionid = questionid;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public String findpsw() throws AuctionException{
	//首先判断是否有该会员昵称
	System.out.println("会员昵称"+username);
	System.out.println("问题编号"+questionid);
	System.out.println("回答"+answer);
	boolean isValidateUser=auserMgr.findAuctionUserByUserName(username);
	if(isValidateUser==false){
		this.addFieldError("username", "不存在此会员");
		return INPUT;}
	//如果存在此会员，则判断问题ID和回答
	AuctionUserBean auctionUserBean=auserMgr.getAuctionUserByUserName(username);
	if((auctionUserBean.getQuestionid()!=questionid)||(auctionUserBean.getAnswer().equals(answer)==false)){
		this.addFieldError("answer", "回答不正确");
		return INPUT;
	}
	//信息校验成功，则发送邮件通知
	auserMgr.sendEmail(auctionUserBean);
	return SUCCESS;
}

}
