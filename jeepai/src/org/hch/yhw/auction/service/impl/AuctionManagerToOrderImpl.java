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
	//以下是该业务逻辑组件所依赖的DAO组件
	private AuctionUserDao userDao;
	private AdminDao adminDao;
	private YiItemDao yiItemDao;
 	private KindDao kindDao;
	private StateDao stateDao;
	//业务逻辑组件发送邮件所依赖的两个Bean
	private MailSender mailSender;
	private SimpleMailMessage message;
	//订单处理依赖的DAO组件
	private OrderyiDao orderyiDao;
	private OrderdetailDao orderdetailDao;
	//为业务逻辑组件依赖注入DAO组件所需的setter方法
	
	
	

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

	
	//业务逻辑方法
	
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
			 throw new AuctionException("订单出现异常,请重试");
		}
		
	}

	@Override
	public void addOrderdetailOnOrderBean(OrderBean orderBean) throws AuctionException {
		// TODO Auto-generated method stub
		 //先获取订单Bean里的购物车中的信息
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
		 //先获取订单Bean里的购物车中的信息
	    List<CartBean> cartlist=orderBean.getCartBeanList();
	    Set set=new HashSet();
	    
	    try {
	    	  for(Iterator it= cartlist.iterator();it.hasNext();){
	    		  CartBean cartBean=(CartBean)it.next();
	    		  Orderdetail orderdetail=new Orderdetail();
	    		  orderdetail.setNumber(cartBean.getNumber());
	    		  orderdetail.setPrice(cartBean.getTotalmoney());
	    		
			YiItem yiitem=yiItemDao.get(cartBean.getYiitemId());
			//更新库存与商品的状态20100409
			updateKucun(yiitem,cartBean.getNumber());
			
			//引用传递，确保yiitem的一致
			orderdetail.setYiitem(yiitem);
			
			set.add(orderdetail);
		} 
	    	  return set;
	    	  } catch (Exception e) {

			 log.debug(e.getMessage());
			 throw new AuctionException("订单20100409库存更新出现异常,请重试");
		}
	}
	@Override
	public int addOrderyiOnOrderBean(OrderBean orderBean)
			throws AuctionException {
		//先获取订单Bean里的购物车中的信息
	     List cartlist=orderBean.getCartBeanList();
		//先获取订单Bean里的会员中的信息
	     AuctionUserBean member=	orderBean.getMemberbean();
		//先获取订单Bean里的配送中的信息
	    String model=	orderBean.getModel();
	    String message =orderBean.getMessage();
		//先获取订单Bean里的总价
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
		//先获取订单Bean里的购物车中的信息
	     List<CartBean> cartlist=orderBean.getCartBeanList();
		//先获取订单Bean里的会员中的信息
	     AuctionUserBean member=	orderBean.getMemberbean();
		//先获取订单Bean里的配送中的信息
	    String model=	orderBean.getModel();
	    String message =orderBean.getMessage();
		//先获取订单Bean里的总价
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
			orderyi.setSign(false);//未发货
			orderyi.setCinfimsign(false);//未确认
			orderyi.setFukuansign(false);//未付款
			orderyi.setSummoney(summoney);
			orderyi.setTelphone(member.getTelphone());
			System.out.println("级联begin8");
			orderyi.setOrderdetails(set);//级联更新
			
			System.out.println("级联begin");
			
			orderyiDao.save(orderyi);
			System.out.println("级联over");
			//发送邮件!
			sendEmail(user.getRealName(),user.getEmail(),orderyi.getOrderId(),cartlist.size());
			return orderyi.getOrderId();
			
			
		} catch (Exception e) {
			 log.debug(e.getMessage());
			 throw new AuctionException("订单出现异常,请重试");
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
			//发送邮件!
			sendEmail(member.getRealName(),member.getEmail(),orderyi.getOrderId(),cartSize);
			return orderyi.getOrderId();
			
			
		} catch (Exception e) {
			 log.debug(e.getMessage());
			 throw new AuctionException("订单出现异常,请重试");
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
	 * 为了方便操作，同样定义几个初始工作方法
	 * 
	 * */
	/**初始化表头*/
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
		//新增确认订单和确认付款功能
		orderyiBean.setFukuansign(orderyi.getFukuansign());
		orderyiBean.setCinfimsign(orderyi.getCinfimsign());
		orderyiBean.setOrderyiid(orderyi.getOrderyiid());
	}
	/**初始化详细表*/
	private void initOrderdetailBean(OrderdetailBean odb,Orderdetail od){
		odb.setOrderyi(od.getId());//表单号
		odb.setId(od.getYiitem().getId());//其实不是表单号而是商品编号提供连接
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
		//回忆引用传递与值传递的不同
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
		
		//准备发送邮件
		SimpleMailMessage msg = new SimpleMailMessage(this.message);
		String tmpString="<h4>亲爱的：</h4><br>"+name+"<p>"+"感谢你购买本网站的商品，你的订单号："+oid+"&nbsp;&nbsp;共有"
		+cat+"种商品</p>";
		
		
		msg.setTo(email);//目的地
		msg.setText(tmpString);//正文
		msg.setSubject("华软网店");
		mailSender.send(msg);
	}
	
	//后台新增，返回所有订单
	public List<Orderyi>  getAllOrderyi()throws AuctionException
	{
		return orderyiDao.findAll();
	}
	
	//后台新增，根据SIGN返回订单
	public List<Orderyi>  getOrderyiBySign(boolean flag)throws AuctionException
	{
		return orderyiDao.findBySign(flag);
	}
	
	//处理库存的方法20100408
	public void updateKucun(YiItem yiItem,int num){
		//如果订单中该商品购买件数>=现有的，则设置状态下架
		//如果订单中该商品购买件数<现有的,令库存-=购买件数
    	//当管理员发货,先检查状态是否下架，是，则库存不足，令库存=0；
		//当管理员或会员取消该订单，设置状态上架；
		//得到该商品现有的库存量
		int originaly=yiItem.getInitnumber();
		if(num>=originaly){
			
			//得到 下架 的状态
			State state=stateDao.get(new Integer(5));
			//该商品下架并库存为0
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
	//先获取小计
	double xiaoji=orderdetail.getPrice();
	double danjia=xiaoji/orderdetail.getNumber();
	orderdetail.setNumber(number);
	orderdetail.setPrice(danjia*number);
	orderdetailDao.update(orderdetail);
	orderyi.setSummoney(orderyi.getSummoney()-xiaoji+danjia*number);
	orderyiDao.update(orderyi);
	System.out.println("完成");
	}
	
	public void deleteO(Integer orderid){
		
		//该订单是否只有一条记录
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
	
	//根据新增的字段获取订单
	public MemberOrderBean findOrderByOrderyiid(String orderyiid)
	{
		OrderyiBean orderyiBean=new OrderyiBean();
		System.out.println("manager中111111111111111111111111111111");
		System.out.println("manager中"+orderyiid);
		Orderyi orderyi=orderyiDao.findByOrderyiid(orderyiid);
		System.out.println("成功执行hql 2222222222222222222222222222222");
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
	
	//根据新增的字段获取订单model
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
