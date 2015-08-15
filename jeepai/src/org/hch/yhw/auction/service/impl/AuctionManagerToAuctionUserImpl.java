package org.hch.yhw.auction.service.impl;

import org.hch.yhw.auction.business.AuctionUserBean;
import org.hch.yhw.auction.dao.AuctionUserDao;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.AuctionUser;
import org.hch.yhw.auction.service.AuctionManagerToAuctionUser;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;



public class AuctionManagerToAuctionUserImpl implements
		AuctionManagerToAuctionUser {
	private AuctionUserDao userDao;
	private MailSender mailSender;
	private SimpleMailMessage message;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setMessage(SimpleMailMessage message) {
		this.message = message;
	}

	public void setUserDao(AuctionUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public AuctionUserBean findAuctionBeanByUserId(Integer id)
			throws AuctionException {
		// TODO Auto-generated method stub
		AuctionUserBean auctionUserBean=new AuctionUserBean();
		AuctionUser auctionUser=findAuctionUserByUserId(id);
		initAuctionUserBean(auctionUserBean,auctionUser);
		return auctionUserBean;
	}

	@Override
	public AuctionUser findAuctionUserByUserId(Integer id)
			throws AuctionException {
		// TODO Auto-generated method stub
		return userDao.get(id);
		 
	}
private void initAuctionUserBean(AuctionUserBean auctionUserBean, AuctionUser auctionUser){
	auctionUserBean.setAddress(auctionUser.getAddress());
	auctionUserBean.setEmail(auctionUser.getEmail());
	auctionUserBean.setPostcode(auctionUser.getPostcode());
	auctionUserBean.setRealName(auctionUser.getRealName());
	auctionUserBean.setTelphone(auctionUser.getTelphone());
	auctionUserBean.setQuestionid(auctionUser.getQuestionid());
	auctionUserBean.setAnswer(auctionUser.getAnswer());
	auctionUserBean.setUsername(auctionUser.getUsername());
	auctionUserBean.setUserpass(auctionUser.getUserpass());
}
//
public void userUpdate(AuctionUser auctionUser) throws AuctionException
{
	try{
	userDao.update(auctionUser);
	}catch(Exception e){throw new AuctionException("�����쳣");
	
	}
	}

@Override
public boolean findAuctionUserByUserName(String username)
		throws AuctionException {
	boolean flag=false;
	try {
	 flag=userDao.isExctUser(username);
	 return	flag;
	} catch (Exception e) {
		System.out.println("�����Ƿ���ڸ��û������쳣");
		e.printStackTrace();
	}
	return	flag;
}

@Override
public AuctionUserBean getAuctionUserByUserName(String username)
		throws AuctionException {
	AuctionUserBean auctionUserBean=new AuctionUserBean();
	AuctionUser auctionUser= userDao.getUserByName(username);
	initAuctionUserBean(auctionUserBean, auctionUser);
	return auctionUserBean;
}

@Override
public void sendEmail(AuctionUserBean auctionUserBean) {
	// TODO Auto-generated method stub
	
	 //׼�������ʼ�
	try{	SimpleMailMessage msg = new SimpleMailMessage(this.message);
		String tmpString="<h4>�װ��ģ�</h4><br>"+auctionUserBean.getRealName()+"<p>"+"������룺"+auctionUserBean.getUserpass()+
		"</p><a href='http:\\\\172.16.126.51:8080\\jeepai' target='_blank'>������½</a>";
		
		 
		msg.setTo(auctionUserBean.getEmail());//Ŀ�ĵ�
		msg.setText(tmpString);//����
		msg.setSubject("��������----�һ�����");
		mailSender.send(msg);
	
	}catch(Exception e){
		System.out.println("�����ʼ�ʧ�ܣ��쳣ʱ��:");
	}
	
}	
	
}
