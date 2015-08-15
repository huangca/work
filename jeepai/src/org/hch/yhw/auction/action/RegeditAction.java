package org.hch.yhw.auction.action;

import java.util.*;
import com.opensymphony.xwork2.ActionSupport;

import org.hch.yhw.auction.service.AuctionManager;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.action.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;

public class RegeditAction extends BaseAction {

	private String username;
	private String password;
	private String repassword;

	private String email;
	private String realname;
	private String postcode;
	private String address;
	private String telphone;
	private int questionid;
	private String answer;
	private String vercode;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getVercode() {
		return vercode;
	}
	public void setVercode(String vercode) {
		this.vercode = vercode;
	}
	@Override
	public String execute() throws AuctionException
	{
		
		System.out.println("coming1");
		Map session = ActionContext.getContext().getSession();
		//String ver2 = (String)session.get("rand");
		//强制系统刚生成的随机验证码失效
		//session.put("rand" , null);
		Integer userId = (Integer)session.get("userId");
		//如果用户输入的验证码与系统随机产生的验证码相同

		if(auserMgr.findAuctionUserByUserName(username)){
			this.addFieldError("username", "该用户名已存在");
			return INPUT;}
		//if (vercode.equals(ver2))
		//{
		//System.out.println("coming2");
		//System.out.println("-----------------------"+questionid+"------------------");
		mgr.addUser(username, password, email, realname, postcode, address, telphone, questionid, answer);
		//System.out.println("coming3");
		session.put("username", username);
			return SUCCESS;
		//}
		/*else
		{System.out.println("coming4");
			addActionError("验证码不匹配,请重新输入");
			return INPUT;
		}
	}*/
	}	
}
