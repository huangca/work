package org.hch.yhw.auction.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hch.yhw.auction.business.BidBean;
import org.hch.yhw.auction.business.ItemBean;
import org.hch.yhw.auction.business.KindBean;
import org.hch.yhw.auction.business.YiItemBean;
import org.hch.yhw.auction.business.CartBean;
import org.hch.yhw.auction.dao.AdminDao;
import org.hch.yhw.auction.dao.AuctionUserDao;
import org.hch.yhw.auction.dao.BidDao;
import org.hch.yhw.auction.dao.BigKindDao;
import org.hch.yhw.auction.dao.KindDao;
import org.hch.yhw.auction.dao.StateDao;
import org.hch.yhw.auction.dao.YiItemDao;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.Admin;
import org.hch.yhw.auction.model.AuctionUser;
import org.hch.yhw.auction.model.Bid;
import org.hch.yhw.auction.model.Bigkind;
import org.hch.yhw.auction.model.Item;
import org.hch.yhw.auction.model.Kind;
import org.hch.yhw.auction.model.State;
import org.hch.yhw.auction.model.YiItem;
import org.hch.yhw.auction.service.AuctionManagerToYiItem;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.hch.yhw.auction.dao.OrderyiDao;
import org.hch.yhw.auction.dao.OrderdetailDao;
/**
 * Description:
 * <br/>地址: <a href="http://www.sise.com.cn">华软高效</a> 
 * <br/>Copyright (C), 2010-201?, 黄灿华   余宏伟
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:20100301-20100401
 * @author  hch0612@scse.com.cn
 * @version  1.0
 */
public class AuctionManagerToYiItemImpl implements AuctionManagerToYiItem {

	static Logger log = Logger.getLogger(
			AuctionManagerToYiItemImpl.class.getName());
		//以下是该业务逻辑组件所依赖的DAO组件
		private AuctionUserDao userDao;
		private AdminDao adminDao;
		private YiItemDao yiItemDao;
		private KindDao kindDao;
		private BigKindDao bigKindDao;
		private StateDao stateDao;
		//业务逻辑组件发送邮件所依赖的两个Bean
		private MailSender mailSender;
		private SimpleMailMessage message;
		//订单处理依赖的DAO组件

		//为业务逻辑组件依赖注入DAO组件所需的setter方法
	
	
	

	public static Logger getLog() {
		return log;
	}



	public void setBigKindDao(BigKindDao bigKindDao) {
		this.bigKindDao = bigKindDao;
	}



	public static void setLog(Logger log) {
		AuctionManagerToYiItemImpl.log = log;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public AuctionUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(AuctionUserDao userDao) {
		this.userDao = userDao;
	}



	public YiItemDao getYiItemDao() {
		return yiItemDao;
	}

	public void setYiItemDao(YiItemDao yiItemDao) {
		this.yiItemDao = yiItemDao;
	}

	public KindDao getKindDao() {
		return kindDao;
	}

	public void setKindDao(KindDao kindDao) {
		this.kindDao = kindDao;
	}

	public StateDao getStateDao() {
		return stateDao;
	}

	public void setStateDao(StateDao stateDao) {
		this.stateDao = stateDao;
	}

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public SimpleMailMessage getMessage() {
		return message;
	}

	public void setMessage(SimpleMailMessage message) {
		this.message = message;
	}
//注入的getter 与setter结束
	public int addItem(String name, String desc, String remark, String picname,
			double initPrice, int avail, int kind, Integer userId,int bigkindid,int number)
			throws AuctionException {
		// TODO Auto-generated method stub
		System.out.println("类明name="+AuctionManagerToYiItemImpl.class);
		System.out.println("name="+name);
		
		try
		{
		Kind k = kindDao.get(new Integer(kind));
			System.out.println("Kindname="+k.getKindName());
			Admin owner = adminDao.get(userId);
			//创建Item对象
			Bigkind bigkind=bigKindDao.get(new Integer(bigkindid));
			YiItem yiitem = new YiItem();
			yiitem.setItemName(name);
			yiitem.setItemDesc(desc);
			yiitem.setItemRemark(remark);
			yiitem.setAddtime(new Date());			
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE , avail);
			yiitem.setEndtime(c.getTime());
			yiitem.setInitPrice(new Double(initPrice));	
			yiitem.setInitnumber(new Integer(number));
			yiitem.setItemState(stateDao.get(new Integer(4)));
			yiitem.setPicname(picname);
			yiitem.setKind(k);
			yiitem.setBigkind(bigkind);
			yiitem.setOwner(owner);//set publisher
			System.out.println("//准备持久化Item对象");
			//持久化Item对象
			yiItemDao.save(yiitem);
			System.out.println("//持久化Item对象");
			return yiitem.getId();
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("添加物品出现异常,请重试");
		}
	
	}

	
	/**
	 * 添加种类
	 * @param name 种类名称
	 * @param desc 种类描述
	 * @return 新增种类的主键
	 */ 
	/*public int addKind(String name, String desc) throws AuctionException {
		try
		{
			Kind k = new Kind();
			k.setKindName(name);
			k.setKindDesc(desc);
			kindDao.save(k);
			return k.getId();
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("添加种类出现异常,请重试");
		}
	}
*/
	
	/**
	 * 查询全部种类
	 * @return 系统中全部全部种类
	 */
	public List getAllKind() throws AuctionException {
		List result = new ArrayList();
		try
		{
			List kl = kindDao.findAll();
			for (Object o : kl )
			{
				Kind k = (Kind)o;
				result.add(new KindBean(k.getId(),
					k.getKindName(), k.getKindDesc(),k.getBigkind().getBigkindname()));
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("查询全部种类出现异常,请重试");
		}
	}


	@Override
	public List getFullItems() throws AuctionException {
		// TODO Auto-generated method stub
	
		//修改时间4月1号
		//initYiItem(YiItemBean ib , YiItem item)
		List yiitems = yiItemDao.findYiItem();
		List result = new ArrayList();
		for (Iterator it = yiitems.iterator() ; it.hasNext() ; )
		{
			YiItem item = (YiItem)it.next();
			YiItemBean yib = new YiItemBean();
			initYiItem(yib,item);
			result.add(yib);
		}
		return result;
		
		 
	}
	/**
	 * 查询一口价的上架架物品
	 * @return 全部一口价物品
	 */
	@Override
	public List getOnlineItems()throws AuctionException{
		return yiItemDao.findYiItemByState(4);
		 
	}
	/**
	 * 查询一口价的全部下架物品
	 * @return 全部一口价物品
	 */
	@Override
	public List getDownlineItems()throws AuctionException{
		return yiItemDao.findYiItemByState(5);}


	public String getKind(int kindId) throws AuctionException {
		// TODO Auto-generated method stub
		try
		{
			Kind  k = kindDao.get(kindId);
			if (k != null)
			{
				return k.getKindName();
			}
			return null;
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("根据种类id获取种类名称出现异常,请重试");
		}
	}

	@Override
	public YiItemBean getYiItem(int itemId) throws AuctionException {
		// TODO Auto-generated method stub
		try
		{
			YiItem item = yiItemDao.get(new Integer(itemId));
			YiItemBean yib = new YiItemBean();
			initYiItem(yib, item);
			return yib;
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("根据物品id获取物品详细信息出现异常,请重试");
		}
	}




	@Override
	public List getYiItemsByKind(int kindId) throws AuctionException {
		// TODO Auto-generated method stub
		try
		{
			List result = new ArrayList();
			List items = yiItemDao.findYiItemByKind(kindId);
			for (Iterator it = items.iterator() ; it.hasNext() ; )
			{
				YiItem item = (YiItem)it.next();
				YiItemBean yib = new YiItemBean();
				initYiItem(yib,item);
				result.add(yib);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("根据种类查询的物品出现异常,请重新");
		}
	}

	@Override
	public List getYiItemsByOwner(Integer userId) throws AuctionException {
		// TODO Auto-generated method stub
		try
		{
			List result = new ArrayList();
			List items = yiItemDao.findYiItemByOwner(userId);
			for (Iterator it = items.iterator() ; it.hasNext() ; )
			{
				YiItem item = (YiItem)it.next();
				YiItemBean yib = new YiItemBean();
				initYiItem(yib,item);
				result.add(yib);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("查询用户所有的物品出现异常,请重新");
		}
	}

	@Override
	
	/**
	 * 
	 */
	public void updateWiner(Integer yitemid,Integer wid) throws AuctionException {
		try
		{
		YiItem yiItem=yiItemDao.get(yitemid);//得到某个一口价商品的对象信息
		AuctionUser winer=userDao.get(wid);
		yiItem.setWiner(winer);
		
		//将该商品的状态设置为下架
	   State state=stateDao.get(5);
	   yiItem.setItemState(state);
       yiItemDao.update(yiItem);
       sendMail(winer,yiItem);
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("更新购买者出现异常,请重试");
		}

	}



	/**
	 * 将一个YiItem PO转换成YIItemBean的VO
	 * @param ib YiItemBean的VO
	 * @param YiItem YiItem的PO
	 */
	private void initYiItem(YiItemBean ib , YiItem item)
	{
		ib.setId(item.getId());
		ib.setName(item.getItemName());
		ib.setDesc(item.getItemDesc());
		ib.setRemark(item.getItemRemark());
		if (item.getKind() != null)
		{	
			ib.setKind(item.getKind().getKindName());
			ib.setKid(item.getKind().getId());
		}
		if (item.getOwner() != null)
			ib.setOwner(item.getOwner().getUsername());
		if (item.getInitnumber() != null)
			ib.setInitnumber(item.getInitnumber());
		if(item.getBigkind()!=null){
			ib.setBigkind(item.getBigkind().getBigkindname());
		ib.setBigkid(item.getBigkind().getBigkindId());	
		}
		ib.setAddTime(item.getAddtime());
		ib.setEndTime(item.getEndtime());
		if (item.getItemState() != null)
			ib.setState(item.getItemState().getStateName());
		ib.setInitPrice(item.getInitPrice());

		if(item.getPicname()!=null)
		ib.setPicname(item.getPicname());
	}
	
	void sendMail(AuctionUser au,YiItem yiitem)throws Exception{
		SimpleMailMessage msg = new SimpleMailMessage(this.message);
		msg.setTo(au.getEmail());
		msg.setText("亲爱的:"
			+ au.getUsername()
			+ ", 谢谢你购买本网站的商品，你所购买的商品是: "
			+ yiitem.getItemName());
		
		msg.setSubject("华软网店");
		mailSender.send(msg);
	}
	
   public 	void sendMail2(){
	   //这里发送格式 购物车的东西
	   
   }
   
   /**
    * 对购物车进行操作
    * */
    
    /**方法一
     * 向购物车添加某商品，并返回一个列表
     * */ 
   public List<CartBean> putCartBeans(int number,Integer yitemid,List<CartBean> fromList)throws Exception{
	 if(fromList==null){
		
		 fromList=new ArrayList<CartBean>();
		 }
	
	   YiItemBean  yiItemBean=getYiItem(yitemid);//得到一个一口价商品的对象
   
	   CartBean cartBean=new CartBean();
	   cartBean.setYiitemId(yiItemBean.getId());
		if( fromList.contains(cartBean)){
			int index=fromList.indexOf(cartBean);
			cartBean=fromList.get(index);
			fromList.remove(cartBean);
			cartBean.setNumber(cartBean.getNumber()+number);
			cartBean.setTotalmoney(cartBean.getInitpiece()*cartBean.getNumber());//小计
			fromList.add(cartBean);
		}
		else{   
	  
	   cartBean.setPicname(yiItemBean.getPicname());
	   cartBean.setInitpiece(yiItemBean.getInitPrice());
	   cartBean.setItemmode("一口价");
	   cartBean.setNumber(number);
	   double totalmoney=number*yiItemBean.getInitPrice();
	   cartBean.setTotalmoney(totalmoney);//小计
	
	   cartBean.setYiitemName(yiItemBean.getName());
	
	
	   fromList.add(cartBean);

		}
	   return fromList;
   }
   
   /**方法二
    * 计算购物车想在的总价钱
    * */   
   public double summomey(List<CartBean> fromList)throws Exception
   {
	   double sum=0.00;
	   if(fromList!=null){
		   for (Iterator it = fromList.iterator() ; it.hasNext() ;) {
			   CartBean cartBean=(CartBean)it.next();
			   sum+=cartBean.getTotalmoney();
			 
		}

		   return sum;
	   }
	   else{return 0.00;}
	   
   }
   /**方法三
    * 清空购物车中的某件商品
    * */  
   public List<CartBean> removeCartBeanById(Integer id,List<CartBean> fromList){
	   CartBean cartBean=new CartBean();
	   List<CartBean> toList;
	   cartBean.setYiitemId(id);
		if( fromList.contains(cartBean)){
			int index=fromList.indexOf(cartBean);
			cartBean=fromList.get(index);
			fromList.remove(cartBean);
			}
		for(Iterator it = fromList.iterator() ; it.hasNext() ;){
			
			 CartBean cartBean2=(CartBean)it.next();
			 System.out.println("cartBean2 name===="+cartBean2.getYiitemName());
		}
		toList=fromList;
	   return toList;
   }
   
  public List<YiItem> getNewSaleYiItems()throws AuctionException{
	 //得到最热卖的9种商品	     
	  return   (List<YiItem>)yiItemDao.findNewYiItemTop();
  }
  
  
  public List getNewSaleYiItemsToList()throws AuctionException{
	  
	  List result=new ArrayList();
	  List list1=new ArrayList();
	  List list2=new ArrayList();
	  List list3=new ArrayList();
	
	  List<YiItem> ly=getNewSaleYiItems();
	  int i=0;
	  for(Iterator it=ly.iterator();it.hasNext()&&i<ly.size();i++){
		  
		  YiItem yiItem=(YiItem)it.next();
		  if(i<3){list1.add(yiItem);System.out.println("一口价商品名称"+yiItem.getItemName());}
		else if(3<=i&&i<6){list2.add(yiItem);System.out.println("一口价商品名称"+yiItem.getItemName());}
		else {list3.add(yiItem);System.out.println("一口价商品名称"+yiItem.getItemName());}
	  }
	  result.add(list1);
	  result.add(list2);
	  result.add(list3);
	  return result;
  }
  
//后台新增，根据ID返回一口价商品的model
  public YiItem getYiItemById(Integer id)throws Exception
  {
	  return yiItemDao.get(id);
  }
  
//后台新增,返回所有state
  public List getAllState()throws Exception
  {
	  return stateDao.findAll();
  }
  
//后台新增，根据state ID返回state model
  public State findStateByStateId(int id) throws Exception
  {
	return stateDao.get(id);  
  }
  
  //后台新增，更新一口价商品
  public void updateYiItem(YiItem yiItem)throws Exception
  {
	  yiItemDao.update(yiItem);
  }

  //前台分页测试
	public int getRows()
	{
		return yiItemDao.findYiItemByState(new Integer(4)).size();
	}
	 //前台分页测试
	public int getKindRows(int kindId)
	{
		return yiItemDao.findYiItemByKind(kindId).size();
	}
	
	
	  //分页测试
public  List getAllItemPage(int pageSize,int startRow)
{
	List yiitems = yiItemDao.getYiItemPage(pageSize, startRow);
	List result = new ArrayList();
	for (Iterator it = yiitems.iterator() ; it.hasNext() ; )
	{
		YiItem item = (YiItem)it.next();
		YiItemBean yib = new YiItemBean();
		initYiItem(yib,item);
		result.add(yib);
	}
	return result;
}
//前台分页测试
public List getAllItemStatePage(int pageSize,int startRow,int stateId)
{
	 
	 List yiitems = yiItemDao.getYiItemStatePage(pageSize, startRow, stateId);
		List result = new ArrayList();
		for (Iterator it = yiitems.iterator() ; it.hasNext() ; )
		{
			YiItem item = (YiItem)it.next();
			YiItemBean yib = new YiItemBean();
			initYiItem(yib,item);
			result.add(yib);
		}
		return result;
	 
}
//前台分页测试
public List getAllItemStateKindPage(int pageSize,int startRow,int kindId)
{
	  
	 List yiitems = yiItemDao.getYiItemStateKindPage(pageSize, startRow, kindId);
		List result = new ArrayList();
		for (Iterator it = yiitems.iterator() ; it.hasNext() ; )
		{
			YiItem item = (YiItem)it.next();
			YiItemBean yib = new YiItemBean();
			initYiItem(yib,item);
			result.add(yib);
		}
		return result;
}
//后台分页测试
public int getAllRows()
{
	 return yiItemDao.findYiItem().size();
}

//后台分页测试
public int getStateRoes(int stateid)
{
	 return yiItemDao.findYiItemByState(stateid).size();
}
  
}
