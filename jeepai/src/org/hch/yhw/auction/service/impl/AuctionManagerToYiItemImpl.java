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
 * <br/>��ַ: <a href="http://www.sise.com.cn">�����Ч</a> 
 * <br/>Copyright (C), 2010-201?, �Ʋӻ�   ���ΰ
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:20100301-20100401
 * @author  hch0612@scse.com.cn
 * @version  1.0
 */
public class AuctionManagerToYiItemImpl implements AuctionManagerToYiItem {

	static Logger log = Logger.getLogger(
			AuctionManagerToYiItemImpl.class.getName());
		//�����Ǹ�ҵ���߼������������DAO���
		private AuctionUserDao userDao;
		private AdminDao adminDao;
		private YiItemDao yiItemDao;
		private KindDao kindDao;
		private BigKindDao bigKindDao;
		private StateDao stateDao;
		//ҵ���߼���������ʼ�������������Bean
		private MailSender mailSender;
		private SimpleMailMessage message;
		//��������������DAO���

		//Ϊҵ���߼��������ע��DAO��������setter����
	
	
	

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
//ע���getter ��setter����
	public int addItem(String name, String desc, String remark, String picname,
			double initPrice, int avail, int kind, Integer userId,int bigkindid,int number)
			throws AuctionException {
		// TODO Auto-generated method stub
		System.out.println("����name="+AuctionManagerToYiItemImpl.class);
		System.out.println("name="+name);
		
		try
		{
		Kind k = kindDao.get(new Integer(kind));
			System.out.println("Kindname="+k.getKindName());
			Admin owner = adminDao.get(userId);
			//����Item����
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
			System.out.println("//׼���־û�Item����");
			//�־û�Item����
			yiItemDao.save(yiitem);
			System.out.println("//�־û�Item����");
			return yiitem.getId();
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("�����Ʒ�����쳣,������");
		}
	
	}

	
	/**
	 * �������
	 * @param name ��������
	 * @param desc ��������
	 * @return �������������
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
			throw new AuctionException("�����������쳣,������");
		}
	}
*/
	
	/**
	 * ��ѯȫ������
	 * @return ϵͳ��ȫ��ȫ������
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
			throw new AuctionException("��ѯȫ����������쳣,������");
		}
	}


	@Override
	public List getFullItems() throws AuctionException {
		// TODO Auto-generated method stub
	
		//�޸�ʱ��4��1��
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
	 * ��ѯһ�ڼ۵��ϼܼ���Ʒ
	 * @return ȫ��һ�ڼ���Ʒ
	 */
	@Override
	public List getOnlineItems()throws AuctionException{
		return yiItemDao.findYiItemByState(4);
		 
	}
	/**
	 * ��ѯһ�ڼ۵�ȫ���¼���Ʒ
	 * @return ȫ��һ�ڼ���Ʒ
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
			throw new AuctionException("��������id��ȡ�������Ƴ����쳣,������");
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
			throw new AuctionException("������Ʒid��ȡ��Ʒ��ϸ��Ϣ�����쳣,������");
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
			throw new AuctionException("���������ѯ����Ʒ�����쳣,������");
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
			throw new AuctionException("��ѯ�û����е���Ʒ�����쳣,������");
		}
	}

	@Override
	
	/**
	 * 
	 */
	public void updateWiner(Integer yitemid,Integer wid) throws AuctionException {
		try
		{
		YiItem yiItem=yiItemDao.get(yitemid);//�õ�ĳ��һ�ڼ���Ʒ�Ķ�����Ϣ
		AuctionUser winer=userDao.get(wid);
		yiItem.setWiner(winer);
		
		//������Ʒ��״̬����Ϊ�¼�
	   State state=stateDao.get(5);
	   yiItem.setItemState(state);
       yiItemDao.update(yiItem);
       sendMail(winer,yiItem);
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("���¹����߳����쳣,������");
		}

	}



	/**
	 * ��һ��YiItem POת����YIItemBean��VO
	 * @param ib YiItemBean��VO
	 * @param YiItem YiItem��PO
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
		msg.setText("�װ���:"
			+ au.getUsername()
			+ ", лл�㹺����վ����Ʒ�������������Ʒ��: "
			+ yiitem.getItemName());
		
		msg.setSubject("��������");
		mailSender.send(msg);
	}
	
   public 	void sendMail2(){
	   //���﷢�͸�ʽ ���ﳵ�Ķ���
	   
   }
   
   /**
    * �Թ��ﳵ���в���
    * */
    
    /**����һ
     * ���ﳵ���ĳ��Ʒ��������һ���б�
     * */ 
   public List<CartBean> putCartBeans(int number,Integer yitemid,List<CartBean> fromList)throws Exception{
	 if(fromList==null){
		
		 fromList=new ArrayList<CartBean>();
		 }
	
	   YiItemBean  yiItemBean=getYiItem(yitemid);//�õ�һ��һ�ڼ���Ʒ�Ķ���
   
	   CartBean cartBean=new CartBean();
	   cartBean.setYiitemId(yiItemBean.getId());
		if( fromList.contains(cartBean)){
			int index=fromList.indexOf(cartBean);
			cartBean=fromList.get(index);
			fromList.remove(cartBean);
			cartBean.setNumber(cartBean.getNumber()+number);
			cartBean.setTotalmoney(cartBean.getInitpiece()*cartBean.getNumber());//С��
			fromList.add(cartBean);
		}
		else{   
	  
	   cartBean.setPicname(yiItemBean.getPicname());
	   cartBean.setInitpiece(yiItemBean.getInitPrice());
	   cartBean.setItemmode("һ�ڼ�");
	   cartBean.setNumber(number);
	   double totalmoney=number*yiItemBean.getInitPrice();
	   cartBean.setTotalmoney(totalmoney);//С��
	
	   cartBean.setYiitemName(yiItemBean.getName());
	
	
	   fromList.add(cartBean);

		}
	   return fromList;
   }
   
   /**������
    * ���㹺�ﳵ���ڵ��ܼ�Ǯ
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
   /**������
    * ��չ��ﳵ�е�ĳ����Ʒ
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
	 //�õ���������9����Ʒ	     
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
		  if(i<3){list1.add(yiItem);System.out.println("һ�ڼ���Ʒ����"+yiItem.getItemName());}
		else if(3<=i&&i<6){list2.add(yiItem);System.out.println("һ�ڼ���Ʒ����"+yiItem.getItemName());}
		else {list3.add(yiItem);System.out.println("һ�ڼ���Ʒ����"+yiItem.getItemName());}
	  }
	  result.add(list1);
	  result.add(list2);
	  result.add(list3);
	  return result;
  }
  
//��̨����������ID����һ�ڼ���Ʒ��model
  public YiItem getYiItemById(Integer id)throws Exception
  {
	  return yiItemDao.get(id);
  }
  
//��̨����,��������state
  public List getAllState()throws Exception
  {
	  return stateDao.findAll();
  }
  
//��̨����������state ID����state model
  public State findStateByStateId(int id) throws Exception
  {
	return stateDao.get(id);  
  }
  
  //��̨����������һ�ڼ���Ʒ
  public void updateYiItem(YiItem yiItem)throws Exception
  {
	  yiItemDao.update(yiItem);
  }

  //ǰ̨��ҳ����
	public int getRows()
	{
		return yiItemDao.findYiItemByState(new Integer(4)).size();
	}
	 //ǰ̨��ҳ����
	public int getKindRows(int kindId)
	{
		return yiItemDao.findYiItemByKind(kindId).size();
	}
	
	
	  //��ҳ����
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
//ǰ̨��ҳ����
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
//ǰ̨��ҳ����
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
//��̨��ҳ����
public int getAllRows()
{
	 return yiItemDao.findYiItem().size();
}

//��̨��ҳ����
public int getStateRoes(int stateid)
{
	 return yiItemDao.findYiItemByState(stateid).size();
}
  
}
