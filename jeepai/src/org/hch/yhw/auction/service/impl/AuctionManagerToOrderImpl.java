package org.hch.yhw.auction.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.apache.log4j.Logger;
import org.hch.yhw.auction.dao.AdminDao;
import org.hch.yhw.auction.dao.AuctionUserDao;
import org.hch.yhw.auction.dao.KindDao;
import org.hch.yhw.auction.dao.OrderdetailDao;
import org.hch.yhw.auction.dao.OrderyiDao;
import org.hch.yhw.auction.dao.StateDao;
import org.hch.yhw.auction.dao.YiItemDao;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.AuctionUser;
import org.hch.yhw.auction.model.Orderdetail;
import org.hch.yhw.auction.model.Orderyi;
import org.hch.yhw.auction.model.State;
import org.hch.yhw.auction.model.YiItem;
import org.hch.yhw.auction.tool.CountTime;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.hch.yhw.auction.business.*;
public class AuctionManagerToOrderImpl implements
		org.hch.yhw.auction.service.AuctionManagerToOrder {
	static Logger log = Logger.getLogger(AuctionManagerToOrderImpl.class.getName());
	//�����Ǹ�ҵ���߼������������DAO���
	private AuctionUserDao userDao;
	private AdminDao adminDao;
	private YiItemDao yiItemDao;
 	private KindDao kindDao;
	private StateDao stateDao;
	//ҵ���߼���������ʼ�������������Bean
	private MailSender mailSender;
	private SimpleMailMessage message;
	//��������������DAO���
	private OrderyiDao orderyiDao;
	private OrderdetailDao orderdetailDao;
	//Ϊҵ���߼��������ע��DAO��������setter����
	
	
	

	public void setUserDao(AuctionUserDao userDao) {
		this.userDao = userDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public void setYiItemDao(YiItemDao yiItemDao) {
		this.yiItemDao = yiItemDao;
	}

	public void setKindDao(KindDao kindDao) {
		this.kindDao = kindDao;
	}

	public void setStateDao(StateDao stateDao) {
		this.stateDao = stateDao;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setMessage(SimpleMailMessage message) {
		this.message = message;
	}

	public void setOrderyiDao(OrderyiDao orderyiDao) {
		this.orderyiDao = orderyiDao;
	}

	public void setOrderdetailDao(OrderdetailDao orderdetailDao) {
		this.orderdetailDao = orderdetailDao;
	}

	
	//ҵ���߼�����
	
	@Override
	public int addOrderdetail(Integer orderid, Integer yiitemid, double xiaoji,
			int number) throws AuctionException {
		try {
			Orderdetail orderdetail=new Orderdetail();
			Orderyi orderyi=orderyiDao.get(orderid);
			orderdetail.setNumber(number);
			orderdetail.setOrderyi(orderyi);
			orderdetail.setPrice(xiaoji);
			YiItem yiitem=yiItemDao.get(yiitemid);
			orderdetail.setYiitem(yiitem);
			orderdetailDao.save(orderdetail);
			return orderdetail.getId();
		} catch (Exception e) {

			 log.debug(e.getMessage());
			 throw new AuctionException("���������쳣,������");
		}
		
	}

	@Override
	public void addOrderdetailOnOrderBean(OrderBean orderBean) throws AuctionException {
		// TODO Auto-generated method stub
		 //�Ȼ�ȡ����Bean��Ĺ��ﳵ�е���Ϣ
	    List<CartBean> cartlist=orderBean.getCartBeanList();
	    Integer orderId=orderBean.getOrderid();
	    for(Iterator it= cartlist.iterator();it.hasNext();){
	    	CartBean cartBean=(CartBean)it.next();
	    	addOrderdetail(
	    			orderId,cartBean.getYiitemId(),
	    			cartBean.getTotalmoney(),cartBean.getNumber()
	    	);
	    }
	    
	}

	private Set cartListToOrderdetailSet(OrderBean orderBean) throws AuctionException{
		 //�Ȼ�ȡ����Bean��Ĺ��ﳵ�е���Ϣ
	    List<CartBean> cartlist=orderBean.getCartBeanList();
	    Set set=new HashSet();
	    
	    try {
	    	  for(Iterator it= cartlist.iterator();it.hasNext();){
	    		  CartBean cartBean=(CartBean)it.next();
	    		  Orderdetail orderdetail=new Orderdetail();
	    		  orderdetail.setNumber(cartBean.getNumber());
	    		  orderdetail.setPrice(cartBean.getTotalmoney());
	    		
			YiItem yiitem=yiItemDao.get(cartBean.getYiitemId());
			//���¿������Ʒ��״̬20100409
			updateKucun(yiitem,cartBean.getNumber());
			
			//���ô��ݣ�ȷ��yiitem��һ��
			orderdetail.setYiitem(yiitem);
			
			set.add(orderdetail);
		} 
	    	  return set;
	    	  } catch (Exception e) {

			 log.debug(e.getMessage());
			 throw new AuctionException("����20100409�����³����쳣,������");
		}
	}
	@Override
	public int addOrderyiOnOrderBean(OrderBean orderBean)
			throws AuctionException {
		//�Ȼ�ȡ����Bean��Ĺ��ﳵ�е���Ϣ
	     List cartlist=orderBean.getCartBeanList();
		//�Ȼ�ȡ����Bean��Ļ�Ա�е���Ϣ
	     AuctionUserBean member=	orderBean.getMemberbean();
		//�Ȼ�ȡ����Bean��������е���Ϣ
	    String model=	orderBean.getModel();
	    String message =orderBean.getMessage();
		//�Ȼ�ȡ����Bean����ܼ�
	    double summoney=orderBean.getSummoney();
	    int orderId= addOrderyiOnOrderyi(
	    		member.getId(),summoney,
	    		member.getRealName(),
	    		member.getAddress(),
	    		member.getTelphone(),
	    		member.getPostcode(),
	    		model,
	    		message,
	    		cartlist.size()
	    );
	    
	   // AuctionUser user=userDao.get(member.getId());
	   // sendEmail(user.getRealName(),user.getEmail(),orderId,cartlist.size());
		
		return orderId;
	}
	@Override
	public int addOrderyiAtOneTime(OrderBean orderBean)throws AuctionException{
		//�Ȼ�ȡ����Bean��Ĺ��ﳵ�е���Ϣ
	     List<CartBean> cartlist=orderBean.getCartBeanList();
		//�Ȼ�ȡ����Bean��Ļ�Ա�е���Ϣ
	     AuctionUserBean member=	orderBean.getMemberbean();
		//�Ȼ�ȡ����Bean��������е���Ϣ
	    String model=	orderBean.getModel();
	    String message =orderBean.getMessage();
		//�Ȼ�ȡ����Bean����ܼ�
	    double summoney=orderBean.getSummoney();
	   
	    Set set=cartListToOrderdetailSet(orderBean);
	   CountTime countTime=new CountTime();
	    Date date=new Date();
	    try {
			Orderyi orderyi=new Orderyi();
		
			AuctionUser user=userDao.get(member.getId());
			
			
			orderyi.setAddress(member.getAddress());
			
			orderyi.setAuctionUser(user);
			
			orderyi.setCreatetime(date);
			orderyi.setMessage(message);
			orderyi.setOrderyiid(countTime.createLiushuihao(date));
			orderyi.setModel(model);
			orderyi.setPost(member.getPostcode());
			orderyi.setRealname(member.getRealName());
			orderyi.setSign(false);//δ����
			orderyi.setCinfimsign(false);//δȷ��
			orderyi.setFukuansign(false);//δ����
			orderyi.setSummoney(summoney);
			orderyi.setTelphone(member.getTelphone());
			System.out.println("����begin8");
			orderyi.setOrderdetails(set);//��������
			
			System.out.println("����begin");
			
			orderyiDao.save(orderyi);
			System.out.println("����over");
			//�����ʼ�!
			sendEmail(user.getRealName(),user.getEmail(),orderyi.getOrderId(),cartlist.size());
			return orderyi.getOrderId();
			
			
		} catch (Exception e) {
			 log.debug(e.getMessage());
			 throw new AuctionException("���������쳣,������");
		}
		
	    
		
	}
	
	@Override
	public int addOrderyiOnOrderyi(Integer userid, double summoney,
			String realname, String address, String telphone, String postcode,
			String model, String message,int cartSize) throws AuctionException {
		
		try {
			Orderyi orderyi=new Orderyi();
			AuctionUser member=userDao.get(userid);
			orderyi.setAddress(address);
			orderyi.setAuctionUser(member);
			orderyi.setCreatetime(new Date());
			orderyi.setMessage(message);
			orderyi.setModel(model);
			orderyi.setPost(postcode);
			orderyi.setRealname(realname);
			orderyi.setSign(false);
			orderyi.setCinfimsign(false);
			orderyi.setFukuansign(false);
			orderyi.setSummoney(summoney);
			orderyi.setTelphone(telphone);
			
			orderyiDao.save(orderyi);
			//�����ʼ�!
			sendEmail(member.getRealName(),member.getEmail(),orderyi.getOrderId(),cartSize);
			return orderyi.getOrderId();
			
			
		} catch (Exception e) {
			 log.debug(e.getMessage());
			 throw new AuctionException("���������쳣,������");
		}
		
		
	}

	@Override
	public void deleteOrderdetailByid(Integer id) throws AuctionException {
		// TODO Auto-generated method stub
		orderdetailDao.delete(id);
	
	}

	@Override
	public void deleteOrderyiByOid(Integer orderId) throws AuctionException {
		// TODO Auto-generated method stub
	
		orderyiDao.delete(orderId);
		
	
	}

	@Override
	public List<Orderyi> getOrderyiByAuctionUserId(Integer userid)
			throws AuctionException {
		// TODO Auto-generated method stub
		return orderyiDao.findByMember(userid);

	}

	@Override
	public void updateOrderyi(Orderyi orderyi) throws AuctionException {
		// TODO Auto-generated method stub
		
		orderyiDao.update(orderyi);
		
	}
	@Override
	public void updateOrderdetail(Orderdetail orderdetail)throws AuctionException{
		orderdetailDao.update(orderdetail);
		
	}
	/**
	 * Ϊ�˷��������ͬ�����弸����ʼ��������
	 * 
	 * */
	/**��ʼ����ͷ*/
	private void initOrderyiBean(OrderyiBean orderyiBean,Orderyi orderyi){
		orderyiBean.setOrderId(orderyi.getOrderId());
		orderyiBean.setAuctionUser(orderyi.getAuctionUser().getRealName());
		orderyiBean.setCreatetime(orderyi.getCreatetime());
		if(orderyi.getMessage()!=null)
		orderyiBean.setMessage(orderyi.getMessage());
		orderyiBean.setModel(orderyi.getModel());
		orderyiBean.setPost(orderyi.getPost());
		orderyiBean.setRealname(orderyi.getRealname());
		orderyiBean.setSign(orderyi.getSign());
		orderyiBean.setSummoney(orderyi.getSummoney());
		orderyiBean.setTelphone(orderyi.getTelphone());
		orderyiBean.setAddress(orderyi.getAddress());
		//����ȷ�϶�����ȷ�ϸ����
		orderyiBean.setFukuansign(orderyi.getFukuansign());
		orderyiBean.setCinfimsign(orderyi.getCinfimsign());
		orderyiBean.setOrderyiid(orderyi.getOrderyiid());
	}
	/**��ʼ����ϸ��*/
	private void initOrderdetailBean(OrderdetailBean odb,Orderdetail od){
		odb.setOrderyi(od.getId());//����
		odb.setId(od.getYiitem().getId());//��ʵ���Ǳ��Ŷ�����Ʒ����ṩ����
		odb.setNumber(od.getNumber());
		odb.setPrice(od.getPrice());
		odb.setYiitem(od.getYiitem().getItemName());
		
	}
	
	@Override
	public  Orderyi getOrderyiByOrderyiId(Integer orderid)throws AuctionException
	{
		return orderyiDao.get(orderid);
	}
	@Override
	public MemberOrderBean findWholeOrderByOrderyiId(Integer id)throws AuctionException{
		OrderyiBean orderyiBean=new OrderyiBean();
		
		MemberOrderBean memberOrderBean=new MemberOrderBean();
		List<OrderdetailBean> odtList=new ArrayList<OrderdetailBean>();
		Orderyi orderyi=orderyiDao.get(id);
		//�������ô�����ֵ���ݵĲ�ͬ
		initOrderyiBean(orderyiBean,orderyi);
		Set orderdetails=orderyi.getOrderdetails();
		
		for(Iterator it=orderdetails.iterator();it.hasNext();){
			OrderdetailBean odb=new OrderdetailBean();
			Orderdetail orderdetail=(Orderdetail)it.next();
			initOrderdetailBean(odb, orderdetail);
			odtList.add(odb);
		}
		
		memberOrderBean.setOrderyiBean(orderyiBean);
		memberOrderBean.setOdtList(odtList);
		
		
		return memberOrderBean;
	}
	
	private void sendEmail(String name,String email,Integer oid, int cat){
		
		//׼�������ʼ�
		SimpleMailMessage msg = new SimpleMailMessage(this.message);
		String tmpString="<h4>�װ��ģ�</h4><br>"+name+"<p>"+"��л�㹺����վ����Ʒ����Ķ����ţ�"+oid+"&nbsp;&nbsp;����"
		+cat+"����Ʒ</p>";
		
		
		msg.setTo(email);//Ŀ�ĵ�
		msg.setText(tmpString);//����
		msg.setSubject("��������");
		mailSender.send(msg);
	}
	
	//��̨�������������ж���
	public List<Orderyi>  getAllOrderyi()throws AuctionException
	{
		return orderyiDao.findAll();
	}
	
	//��̨����������SIGN���ض���
	public List<Orderyi>  getOrderyiBySign(boolean flag)throws AuctionException
	{
		return orderyiDao.findBySign(flag);
	}
	
	//������ķ���20100408
	public void updateKucun(YiItem yiItem,int num){
		//��������и���Ʒ�������>=���еģ�������״̬�¼�
		//��������и���Ʒ�������<���е�,����-=�������
    	//������Ա����,�ȼ��״̬�Ƿ��¼ܣ��ǣ����治�㣬����=0��
		//������Ա���Աȡ���ö���������״̬�ϼܣ�
		//�õ�����Ʒ���еĿ����
		int originaly=yiItem.getInitnumber();
		if(num>=originaly){
			
			//�õ� �¼� ��״̬
			State state=stateDao.get(new Integer(5));
			//����Ʒ�¼ܲ����Ϊ0
			yiItem.setItemState(state);
			yiItem.setInitnumber(0);
			yiItemDao.update(yiItem);			
		}
		else{
			yiItem.setInitnumber(num-originaly);
			yiItemDao.update(yiItem);
		}
	}
	
	public void updateO(Integer orderid,int number){
		
	Orderdetail orderdetail=orderdetailDao.get(orderid);
	Orderyi orderyi=orderdetail.getOrderyi();
	//�Ȼ�ȡС��
	double xiaoji=orderdetail.getPrice();
	double danjia=xiaoji/orderdetail.getNumber();
	orderdetail.setNumber(number);
	orderdetail.setPrice(danjia*number);
	orderdetailDao.update(orderdetail);
	orderyi.setSummoney(orderyi.getSummoney()-xiaoji+danjia*number);
	orderyiDao.update(orderyi);
	System.out.println("���");
	}
	
	public void deleteO(Integer orderid){
		
		//�ö����Ƿ�ֻ��һ����¼
		Orderdetail orderdetail=orderdetailDao.get(orderid);
		Orderyi orderyi=orderdetail.getOrderyi();
		int size=orderyi.getOrderdetails().size();
		if(size==1){orderyiDao.delete(orderyi);}
		else if(size>1){
			double xiaoji=orderdetail.getPrice();
			orderyi.setSummoney(orderyi.getSummoney()-xiaoji);
	/*	Set set=orderyi.getOrderdetails();
		Set set2=new HashSet();
		for(Iterator it=set.iterator();it.hasNext();){
			Orderdetail orderdetail2=(Orderdetail)it.next();
			if(orderdetail.equals(orderdetail2)){				
			}else {set2.add(orderdetail2);}
		}						
			orderyi.setOrderdetails(set2);*/
			orderyiDao.update(orderyi);
			orderdetailDao.delete(orderdetail);
		}
		
	}
	
	//�����������ֶλ�ȡ����
	public MemberOrderBean findOrderByOrderyiid(String orderyiid)
	{
		OrderyiBean orderyiBean=new OrderyiBean();
		System.out.println("manager��111111111111111111111111111111");
		System.out.println("manager��"+orderyiid);
		Orderyi orderyi=orderyiDao.findByOrderyiid(orderyiid);
		System.out.println("�ɹ�ִ��hql 2222222222222222222222222222222");
		MemberOrderBean memberOrderBean=new MemberOrderBean();
		List<OrderdetailBean> odtList=new ArrayList<OrderdetailBean>();
		initOrderyiBean(orderyiBean,orderyi);
		Set orderdetails=orderyi.getOrderdetails();
		
		for(Iterator it=orderdetails.iterator();it.hasNext();){
			OrderdetailBean odb=new OrderdetailBean();
			Orderdetail orderdetail=(Orderdetail)it.next();
			initOrderdetailBean(odb, orderdetail);
			odtList.add(odb);
		}
		
		memberOrderBean.setOrderyiBean(orderyiBean);
		memberOrderBean.setOdtList(odtList);
		
		
		return memberOrderBean;
	}
	
	//�����������ֶλ�ȡ����model
	public Orderyi getOrderByOrderyiid(String orderyiid)
	{
		return orderyiDao.findByOrderyiid(orderyiid);
	}
	
	public void deleteOrderyiByModel(String orderyiid)
	{
		Orderyi orderyi=orderyiDao.findByOrderyiid(orderyiid);
		orderyiDao.delete(orderyi);
	}
	
	
	
}
