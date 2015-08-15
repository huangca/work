package org.hch.yhw.auction.service.impl;

import org.apache.log4j.Logger;

import java.util.*;

import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.dao.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.*;
import org.hch.yhw.auction.service.AuctionManager;
import org.hch.yhw.auction.tool.CountTime;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

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
public class AuctionManagerImpl implements AuctionManager
{

	static Logger log = Logger.getLogger(
		AuctionManagerImpl.class.getName());
	//�����Ǹ�ҵ���߼������������DAO���
	private AuctionUserDao userDao;
	private BidDao bidDao;
	private ItemDao itemDao;
	private KindDao kindDao;
	private BigKindDao bigKindDao;
	private StateDao stateDao;
	private AdminDao adminDao;
	private OrderyiDao orderyiDao; //����orderyiDao
	private OrderiDao orderiDao; //����orderyiDao
	//ҵ���߼���������ʼ�������������Bean
	private MailSender mailSender;
	private SimpleMailMessage message;
	//Ϊҵ���߼��������ע��DAO��������setter����
	public void setUserDao(AuctionUserDao userDao) 
	{
		this.userDao = userDao; 
	}
	
	public void setOrderiDao(OrderiDao orderiDao) {
		this.orderiDao = orderiDao;
	}

	public void setBidDao(BidDao bidDao) 
	{
		this.bidDao = bidDao; 
	}
	public void setItemDao(ItemDao itemDao) 
	{
		this.itemDao = itemDao; 
	}
	public void setKindDao(KindDao kindDao) 
	{
		this.kindDao = kindDao; 
	}
	public void setStateDao(StateDao stateDao) 
	{
		this.stateDao = stateDao; 
	}
	//Ϊҵ���߼����ע�������ʼ�����Bean��setter����
	public void setMailSender(MailSender mailSender)
	{
		this.mailSender = mailSender;
	}
	public void setMessage(SimpleMailMessage message)
	{
		this.message = message;
	}

	public void setBigKindDao(BigKindDao bigKindDao) {
		this.bigKindDao = bigKindDao;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	/**
	 * ����Ӯȡ�߲�ѯ��Ʒ
	 * @param winerId Ӯȡ�ߵ�ID
	 * @return Ӯȡ�߻�õ�ȫ����Ʒ
	 */
	public List getItemByWiner(Integer winerId) throws AuctionException
	{
		try
		{
			List items = itemDao.findItemByWiner(winerId);
			List result = new ArrayList();
			for (Iterator it = items.iterator() ; it.hasNext() ; )
			{
				Item item = (Item)it.next();
				ItemBean ib = new ItemBean();
				initItem(ib,item);
				result.add(ib);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("��ѯ�û���Ӯȡ����Ʒ�����쳣,������");
		}
	}

	/**
	 * ��ѯ���ĵ�ȫ����Ʒ
	 * @return ȫ��������Ʒ
	 */
	public List getFailItems() throws AuctionException
	{
		try
		{
			List items = itemDao.findItemByState(3);
			List result = new ArrayList();
			for (Iterator it = items.iterator() ; it.hasNext() ; )
			{
				Item item = (Item)it.next();
				ItemBean ib = new ItemBean();
				initItem(ib,item);
				result.add(ib);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("��ѯ������Ʒ�����쳣,������");
		}
	}

	/**
	 * �����û�����������֤��¼�Ƿ�ɹ�
	 * @param username ��¼���û���
 	 * @param pass ��¼������
	 * @return ��¼�ɹ������û�ID�����򷵻�-1
	 */
	public int validLogin(String username , String pass) throws AuctionException
	{
		try
		{
			AuctionUser u = userDao.findUserByNameAndPass(username , pass);
			if (u != null)
			{
				return u.getId();
			}
			return -1;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("�����û���¼�����쳣,������");
		}
	}

	/**
	 * ��ѯ�û���ȫ������
	 * @param userId �����û���ID
	 * @return �û���ȫ������
	 */
	public List getBidByUser(Integer userId) throws AuctionException
	{
		try
		{
			List l = bidDao.findByUser(userId);
			List result = new ArrayList();
			for ( int i = 0 ; i < l.size() ; i++ )
			{
				Bid bid = (Bid)l.get(i);
				BidBean bb = new BidBean();
				initBid(bb, bid);
				result.add(bb);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("����û���ȫ�����۳����쳣,������");
		}
	}

	/**
	 * �����û�����Ŀǰ���������е�ȫ����Ʒ
	 * @param userId �����ߵ�ID
	 * @return ���ڵ�ǰ�û��ġ����������е�ȫ����Ʒ��
	 */
	public List getItemsByOwner(Integer userId) throws AuctionException
	{
		try
		{
			List result = new ArrayList();
			List items = itemDao.findItemByOwner(userId);
			for (Iterator it = items.iterator() ; it.hasNext() ; )
			{
				Item item = (Item)it.next();
				ItemBean ib = new ItemBean();
				initItem(ib,item);
				result.add(ib);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("��ѯ�û����е���Ʒ�����쳣,������");
		}
	}

	/**
	 * ��ѯȫ������
	 * @return ϵͳ��ȫ��ȫ������
	 */   
	public List getAllKind() throws AuctionException
	{
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

	/**
	* �����Ʒ
	* @param name ��Ʒ����
	* @param desc ��Ʒ����
	* @param remark ��Ʒ��ע
	* @param avail ��Ч����
	* @param kind ��Ʒ����
	* @param userId ����ߵ�ID
	* @return ������Ʒ������
	*/
	public int addItem(String name , String desc , String remark ,String picname,
		double initPrice , int avail , int kind ,Integer userId,int bigkindid,int zengfu)
		throws AuctionException
	{
		
		try
		{
		    Kind k = kindDao.get(new Integer(kind));
		    Bigkind bigkind=bigKindDao.get(new Integer(bigkindid));
			Admin owner = adminDao.get(new Integer(userId));
			//����Item����
			Item item = new Item();
			item.setItemName(name);
			item.setItemDesc(desc);
			item.setItemRemark(remark);
			item.setAddtime(new Date());
			
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE , avail);
			item.setEndtime(c.getTime());
			item.setInitPrice(new Double(initPrice));
			item.setMaxPrice(new Double(initPrice));
			item.setItemState(stateDao.get(new Integer(1)));
			item.setPicname(picname);
			item.setKind(k);
			item.setBigkind(bigkind);
			item.setOwner(owner);
			item.setZengfu(new Float(zengfu)/100);
			//�־û�Item����
			itemDao.save(item);
			System.out.println("//�־û�Item����");
		return item.getId();
			
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
	public int addKind(String name , String desc,int bigkindid)
		throws AuctionException
	{
		try
		{
			Kind k = new Kind();
			Bigkind bigkind=bigKindDao.get(new Integer(bigkindid));
			k.setKindName(name);
			k.setKindDesc(desc);
			k.setBigkind(bigkind);
			kindDao.save(k);
			return k.getId();
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("�����������쳣,������");
		}
	}

	/**
	 * ���ݲ�Ʒ���࣬��ȡ���������е�ȫ����Ʒ
	 * @param kindId ����id;
	 * @return �����ȫ����Ʒ
	 */
	public List getItemsByKind(int kindId) throws AuctionException
	{
		List result = new ArrayList();
		try
		{
			List items = itemDao.findItemByKind(new Integer(kindId));
			for (Iterator it = items.iterator() ; it.hasNext() ; )
			{
				Item item = (Item)it.next();
				ItemBean ib = new ItemBean();
				initItem(ib , item);
				result.add(ib);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("���������ȡ��Ʒ�����쳣,������");
		}
	}

	/**
	 * ��������id��ȡ������
	 * @param kindId ����id;
	 * @return �����������
	 */
	public String getKind(int kindId) throws AuctionException
	{
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

	/**
	 * ������Ʒid����ȡ��Ʒ
	 * @param itemId ��Ʒid;
	 * @return ָ��id��Ӧ����Ʒ
	 */
	public ItemBean getItem(int itemId)
		throws AuctionException
	{
		try
		{
			Item item = itemDao.get(itemId);
			ItemBean ib = new ItemBean();
			initItem(ib, item);
			return ib;
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("������Ʒid��ȡ��Ʒ��ϸ��Ϣ�����쳣,������");
		}
	}

	/**
	 * �����µľ��ۣ����Ծ����û����ʼ�֪ͨ
	 * @param itemId ��Ʒid;
	 * @param bidPrice ���ۼ۸�
	 * @param userId �����û���ID
	 * @return �����������ۼ�¼��ID
	 */
	public int addBid(int itemId , double bidPrice , Integer userId)
		throws AuctionException
	{
		try
		{
			AuctionUser au = userDao.get(userId);
			Item item = itemDao.get(itemId);
			if (bidPrice > item.getMaxPrice())
			{
				item.setMaxPrice(new Double(bidPrice));
				itemDao.save(item);
			}
			//��ʼ��Bid����
			Bid bid = new Bid();
			bid.setBidItem(item);
			bid.setBidUser(au);
			bid.setBidDate(new Date());
			bid.setBidPrice(bidPrice);
			//�־û�Bid����
			bidDao.save(bid);
			//׼�������ʼ�
			SimpleMailMessage msg = new SimpleMailMessage(this.message);
			msg.setTo(au.getEmail());
			msg.setText("Dear "
				+ au.getUsername()
				+ ", лл����뾺�ۣ���ľ��۵���Ʒ����: "
				+ item.getItemName());
			mailSender.send(msg);
			return bid.getId();
		}
		catch(Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("�����û����۳����쳣,������");
		}
	}

	/**
	 * ����ʱ�����޸���Ʒ��״̬��Ӯȡ��
	 */
	public void updateWiner()throws AuctionException
	{
		try
		{
			List itemList = itemDao.findItemByState(1);
			for (int i = 0 ; i < itemList.size() ; i++ )
			{
				Item item = (Item)itemList.get(i);
				if (!item.getEndtime().after(new Date()))
				{
					//����ָ����Ʒ����߾�������ѯ�û�
					AuctionUser au = bidDao.findUserByItemAndPrice(
						item.getId() , item.getMaxPrice());
					//�������Ʒ����߾����߲�Ϊnull
					if (au != null)
					{
						//���þ�������ΪӮȡ��
						item.setWiner(au);
						//�޸���Ʒ��״̬��Ϊ����Ӯȡ��
						item.setItemState(stateDao.get(2));
						itemDao.save(item);
						//�Զ����ɾ�����ƷӮȡ�Ķ���
						autoCreateOrderi(au,item);
					}
					else
					{
						//���ø���Ʒ��״̬Ϊ�����ġ�
						item.setItemState(stateDao.get(3));
						itemDao.save(item);
						
					}
				}
			}
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("����ʱ�����޸���Ʒ��״̬��Ӯȡ�߳����쳣,������");
		}
	}
    //����
	/**
	 * �Զ����ɾ�����ƷӮȡ�Ķ����ķ���
	 * */
	private void autoCreateOrderi(AuctionUser au,Item item){
		Orderi orderi=new Orderi();
		initOrderi(orderi,au,item);
		orderiDao.save(orderi);
	}
	private void initOrderi(Orderi orderi,AuctionUser au,Item item){
		orderi.setAddress(au.getAddress());
		orderi.setAuctionUser(au);
		orderi.setCinfimsign(false);
		Date date=new Date();
		CountTime countTime=new CountTime();
		orderi.setCreatetime(date);
		orderi.setFukuansign(false);
		orderi.setItem(item);
		//orderi.setMessage(null);
		orderi.setModel("EMS");
		orderi.setNumber(1);
		orderi.setPrice(item.getMaxPrice());
		orderi.setRealname(au.getRealName());
		orderi.setSign(false);
		orderi.setSummoney(item.getMaxPrice()+25);
		orderi.setTelphone(au.getTelphone());
		orderi.setPost(au.getPostcode());
		orderi.setOrderiid(countTime.createLiushuihao(date));//������ˮ��
	}
	/**
	 * ��һ��Bid����ת����BidBean����
	 * @param bb BidBean����
	 * @param bid Bid����
	 */
	private void initBid(BidBean bb , Bid bid)
	{
		bb.setId(bid.getId().intValue());
		if (bid.getBidUser() != null )
			bb.setUser(bid.getBidUser().getUsername());
		if (bid.getBidItem() != null )
			bb.setItem(bid.getBidItem().getItemName());
		bb.setPrice(bid.getBidPrice());
		bb.setBidDate(bid.getBidDate());
	}

	/**
	 * ��һ��Item POת����ItemBean��VO
	 * @param ib ItemBean��VO
	 * @param item Item��PO
	 */
	private void initItem(ItemBean ib , Item item)
	{
		ib.setId(item.getId());
		ib.setName(item.getItemName());
		ib.setDesc(item.getItemDesc());
		ib.setRemark(item.getItemRemark());
		if (item.getKind() != null){
			ib.setKind(item.getKind().getKindName());
			ib.setKid(item.getKind().getId());
		}
		if (item.getOwner() != null)
			ib.setOwner(item.getOwner().getUsername());
		if (item.getWiner() != null)
			ib.setWiner(item.getWiner().getUsername());
		if(item.getBigkind()!=null){
			ib.setBigkind(item.getBigkind().getBigkindname());
			ib.setBigkid(item.getBigkind().getBigkindId());
			}
		ib.setAddTime(item.getAddtime());
		ib.setEndTime(item.getEndtime());
		if (item.getItemState() != null)
			ib.setState(item.getItemState().getStateName());
		ib.setInitPrice(item.getInitPrice());
		ib.setMaxPrice(item.getMaxPrice());
		if(item.getPicname()!=null)
		ib.setPicname(item.getPicname());
		ib.setZengfu(item.getZengfu());
	}
	
	public List getAllJingpaiItem()throws AuctionException{
		
		List result = new ArrayList();
		try
		{
			List items = itemDao.findItemByState(new Integer(1));
			for (Iterator it = items.iterator() ; it.hasNext() ; )
			{
				Item item = (Item)it.next();
				ItemBean ib = new ItemBean();
				initItem(ib , item);
				result.add(ib);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("���������ȡ��Ʒ�����쳣,������");
		}

	}
	
	private List  getNewPaiItemsToList()throws AuctionException{
		 return   (List<Item>)itemDao.findItemByStateOrderByDate();
		  
	}
	@Override
	public List  findItemByStateOrderByDate() throws AuctionException {
		// TODO Auto-generated method stub
		  List result=new ArrayList();
		  List list1=new ArrayList();
		  List list2=new ArrayList();
		  List list3=new ArrayList();
		  List list=getNewPaiItemsToList();//�õ�һ�����¾��ĵ��б�
		  int i=0;
		  for(Iterator it=list.iterator();it.hasNext()&&i<list.size();i++){
			  Item item=(Item)it.next();
			  if(i<3){list1.add(item);
			  System.out.println("������Ʒ����"+item.getItemName());}
				else if(3<=i&&i<6){list2.add(item);System.out.println("������Ʒ����"+item.getItemName());}
				else {list3.add(item);System.out.println("������Ʒ����"+item.getItemName());}
			     }
		  result.add(list1);result.add(list2);result.add(list3);
		return result;
	
	}
	//ע�����û�
	public int addUser(String username,String password,String email,String realname,String postcode,String address
			,String telphone,int questionid,String answer)throws AuctionException
			{
		try
		{
	
		AuctionUser user1=new AuctionUser();
		user1.setUsername(username);
		user1.setUserpass(password);
		user1.setEmail(email);
		user1.setRealName(realname);
		user1.setPostcode(postcode);
		user1.setAddress(address);
		user1.setTelphone(telphone);
		user1.setQuestionid(new Integer(1));
		user1.setAnswer(answer);
	
		userDao.save(user1);
	
		return user1.getId();
	
		}catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("ע�����û��쳣");
		}
	}
	
	//�޸�����
	public boolean checkPw(String username,String opassword,String npassword) throws AuctionException
	{
		try
		{
			AuctionUser user1=new AuctionUser();
			user1=userDao.findUserByNameAndPass(username, opassword);
		if(user1==null){return false;}
		else
		{
			user1.setUserpass(npassword);
			userDao.save(user1);
			return true;
		}
		
		}catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("�޸������쳣");
		}
	}
	
	//�ѳ�ָ���û���һ�ڼ۶���
	public List getOrder(Integer userId)throws AuctionException
	{
		try
	{
		List result = new ArrayList();
		System.out.println("ǰ");
		System.out.println(userId);
		result= orderyiDao.findByMember(userId);
		System.out.println("��");
		return result;
	}catch (Exception e)
	{
		log.debug(e.getMessage());
		throw new AuctionException("�쳣");
	}
		
	}
	
	
	
	
	
	/**�ҳ����д���**/
public 	List getAllBigKind() throws AuctionException{
	
	List result = new ArrayList();
	try
	{
		List kl = bigKindDao.findAll();
		for (Object o : kl )
		{
			Bigkind k = (Bigkind)o;
			result.add(new BigKindBean(k.getBigkindId(),k.getBigkindname(),k.getKinddesc()));
		}
		return result;
	}
	catch (Exception e)
	{
		log.debug(e.getMessage());
		throw new AuctionException("��ѯȫ����������쳣,������");
	}
	
}

	
	/**�ҳ����д���**/
public 	Bigkind getBigKindById(Integer id) throws AuctionException{
	
	return (Bigkind)bigKindDao.get(id);
}

	/**�ҳ�����������ݴ���**/

public 	List getAllkindByBigKind(Bigkind bigkind) throws AuctionException{
	Bigkind bigkind2=getBigKindById(bigkind.getBigkindId());
	Set set=bigkind2.getKinds();
	List result=new ArrayList();
	for(Iterator it=set.iterator();it.hasNext();){
		Kind kind=(Kind)it.next();
		KindBean kindBean=new KindBean();
		initKindBean(kindBean,kind);
		result.add(kindBean);
	}
	return result;
}


private void initKindBean(KindBean kindBean,Kind kind){
	
	kindBean.setId(kind.getId());
	kindBean.setKindName(kind.getKindName());
	kindBean.setKindDesc(kind.getKindDesc());
}



	@Override
	public int addBigKind(String name, String desc) throws AuctionException {
		// TODO Auto-generated method stub
		try
		{
			Bigkind bigkind=new Bigkind();
	        bigkind.setBigkindname(name);
	        bigkind.setKinddesc(desc);
	        bigKindDao.save(bigkind);
            return bigkind.getBigkindId();
		
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("��Ӵ��������쳣,������");
		}
		
		
		

	}
	
	//����Ա��½
	public int adminLogin(String username , String password)throws AuctionException
	{
		try{
			Admin admin=adminDao.findAdminByNameAndPass(username, password);
			if(admin!=null) return admin.getUserId();
			else return -1;
		}catch(Exception e){log.debug(e.getMessage());
		throw new AuctionException("�����û���¼�����쳣,������");}
	}
	
	//��̨��������������ID��������
	public Kind findKindByIKind(int id)throws AuctionException
	{
		return kindDao.get(id);
	}
	//��̨����������������Ϣ
	public void updateKind(Kind kind)throws AuctionException
	{
		kindDao.update(kind);
	}
	public Item getItemById(int itemId)throws AuctionException
	{
		return itemDao.get(itemId);
	}
	
	//��̨����,��������Ʒ
	public void updateItem(Item item)throws AuctionException
	{
		itemDao.update(item);
	}


/**Ϊ�����double select��ǩ*/
	public Map getBigKindsForMap(){
		Map map=new HashMap();
 //�������..
	List<Bigkind>bigkinds=	bigKindDao.findAll();
	
	for(Iterator it=bigkinds.iterator();it.hasNext();){
		Bigkind bigkind=(Bigkind)it.next();
		map.put(bigkind.getBigkindname(),bigkind.getKinds());
		
	}
		return map;
	}
	
	 //��̨����2������bigkind ID����bigkind��
	public Bigkind findBigKindByBigId(int id) throws AuctionException
	{
		return bigKindDao.get(id);
	}
	@Override
	public List findAllBigKind() {
		// TODO Auto-generated method stub
		return bigKindDao.findAll();
	}
	
	//��Ӵ���󣬺�̨����2������bigkind��
	public void updateBigKind(Bigkind bigkind)
	{
		bigKindDao.update(bigkind);
	}
	
	//ǰ̨������Ʒ��ҳ����
	public List getAllItemStatePage(int pageSize,int startRow)
	{
		List result = new ArrayList();
		List items = itemDao.getAllItemStatePage(pageSize, startRow);
		for (Iterator it = items.iterator() ; it.hasNext() ; )
		{
			Item item = (Item)it.next();
			ItemBean ib = new ItemBean();
			initItem(ib , item);
			result.add(ib);
		}
		return result;
	}
	//ǰ̨������Ʒ��ҳ����
	public List getAllItemStateKindPage(int pageSize,int startRow,int kindId)
	{
		
		List result = new ArrayList();
		List items = itemDao.getItemStateKindPage(pageSize, startRow, kindId);
		for (Iterator it = items.iterator() ; it.hasNext() ; )
		{
			Item item = (Item)it.next();
			ItemBean ib = new ItemBean();
			initItem(ib , item);
			result.add(ib);
		}
		return result;
	}
	
    //ǰ̨������Ʒ��ҳ����
	public int getRowsStatePage()
	{
		return itemDao.findItemByState(new Integer(1)).size();
	}
    //ǰ̨������Ʒ��ҳ����
	public int getRowsStateKindPage(int kindId)
	{
		return itemDao.findItemByKind(kindId).size();
	}
	
	
	
	public List filldoubleselect()throws AuctionException{
	return	bigKindDao.findAll();
		
	}
	public 	List getAllBigKindNotOther() throws AuctionException{
		
	return (List<Bigkind>)	bigKindDao.findAll();
	}

    
	////ǰ̨����04-11 14:51:00
	/**
	 * ���ݻ�Ա��ȡ��Ӯȡ����Ʒ
	 * */
    public List<OrderiBean> getOrderiByMember(Integer winer)throws AuctionException{
    List<Orderi> list=	orderiDao.findByMember(winer);
    List<OrderiBean> orderiBeans=new ArrayList<OrderiBean>();
     for(Iterator it=list.iterator();it.hasNext();){
	   Orderi orderi=(Orderi)it.next();
	   OrderiBean orderiBean=new OrderiBean();
	   initOrderbean(orderiBean,orderi);
	   orderiBeans.add(orderiBean);
	   
   }
    System.out.println("���ݻ�Ա��ȡ��Ӯȡ����Ʒ�ɹ�");
    return orderiBeans;
    }
    private void initOrderbean( OrderiBean ob,Orderi od){
    	ob.setAddress(od.getAddress());
    	ob.setCinfimsign(od.getCinfimsign());
    	ob.setId(od.getId());
    	ob.setCreatetime(od.getCreatetime());
    	ob.setFukuansign(od.getFukuansign());
    	ob.setItem(od.getItem().getItemName());
    	ob.setMessage(od.getMessage());
    	ob.setModel(od.getModel());
    	ob.setNumber(od.getNumber());
    	ob.setOrderId(od.getOrderiid());
    	ob.setPost(od.getPost());
    	ob.setPrice(od.getPrice());
    	ob.setRealname(od.getRealname());
    	ob.setSign(od.getSign());
    	ob.setSummoney(od.getSummoney());
    	ob.setTelphone(od.getTelphone());
    	ob.setItemId(od.getItem().getId());
    }
    public void deleteOrderi(String orderid){
    	System.out.println("orderid ======"+orderid);
    	Orderi orderi=orderiDao.findByOrderi(orderid);
    	orderiDao.delete(orderi);
    }
    public void updateOrderiSign(String orderid){
    	Orderi orderi=orderiDao.findByOrderi(orderid);
    	orderi.setSign(true);
    	orderiDao.update(orderi);
    }
    public void updateOrderiCinSign( OrderiBean orderiBean){
    	Orderi orderi=orderiDao.findByOrderi(orderiBean.getOrderId());
    	orderi.setTelphone(orderiBean.getTelphone());
    	orderi.setRealname(orderiBean.getRealname());
    	orderi.setMessage(orderiBean.getMessage());
    	orderi.setModel(orderiBean.getModel());
    	orderi.setPost(orderiBean.getPost());
    	orderi.setAddress(orderiBean.getAddress());
    	orderi.setCinfimsign(true);  	
       	orderiDao.update(orderi);
    }
    public void updateOrderiFukuanSign(String orderid){
    	 Orderi orderi=orderiDao.findByOrderi(orderid);
    	orderi.setFukuansign(true);
    	orderiDao.update(orderi);
    }
    
	public List<OrderiBean> findAllOrderis(){
		List<Orderi> list=orderiDao.findAll();
		List<OrderiBean> result=new ArrayList<OrderiBean>();
		for(Iterator it=list.iterator();it.hasNext();){
			Orderi orderi=(Orderi)it.next();
			OrderiBean orderiBean=new OrderiBean();
			initOrderbean(orderiBean, orderi);
			result.add(orderiBean);
		}
		
		return result;
	}
	public OrderiBean getOrderiByOrderId(String orderid){
		Orderi orderi=orderiDao.findByOrderi(orderid);
		OrderiBean orderiBean=new OrderiBean();
		initOrderbean(orderiBean, orderi);
		return orderiBean;
	}
}