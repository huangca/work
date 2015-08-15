package org.hch.yhw.auction.business;

public class AuctionUserBean {
	private Integer id;
	private String username;
	private String realName;
	private String userpass;
	private String email;
	private String postcode;
	private String address;
	private String telphone;
	private int questionid;
	private String answer;
	public AuctionUserBean() {
		
	}
	public AuctionUserBean(Integer id, String username, String realName,
			String userpass, String email, String postcode, String address,
			String telphone, int questionid, String answer) {
		super();
		this.id = id;
		this.username = username;
		this.realName = realName;
		this.userpass = userpass;
		this.email = email;
		this.postcode = postcode;
		this.address = address;
		this.telphone = telphone;
		this.questionid = questionid;
		this.answer = answer;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	
}
