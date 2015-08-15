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
	//�����ж��Ƿ��иû�Ա�ǳ�
	System.out.println("��Ա�ǳ�"+username);
	System.out.println("������"+questionid);
	System.out.println("�ش�"+answer);
	boolean isValidateUser=auserMgr.findAuctionUserByUserName(username);
	if(isValidateUser==false){
		this.addFieldError("username", "�����ڴ˻�Ա");
		return INPUT;}
	//������ڴ˻�Ա�����ж�����ID�ͻش�
	AuctionUserBean auctionUserBean=auserMgr.getAuctionUserByUserName(username);
	if((auctionUserBean.getQuestionid()!=questionid)||(auctionUserBean.getAnswer().equals(answer)==false)){
		this.addFieldError("answer", "�ش���ȷ");
		return INPUT;
	}
	//��ϢУ��ɹ��������ʼ�֪ͨ
	auserMgr.sendEmail(auctionUserBean);
	return SUCCESS;
}

}
