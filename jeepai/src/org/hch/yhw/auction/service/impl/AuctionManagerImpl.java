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
 * <br/>地址: <a href="http://www.sise.com.cn">华软高效</a> 
 * <br/>Copyright (C), 2010-201?, 黄灿华   余宏伟
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
	//以下是该业务逻辑组件所依赖的DAO组件
	private AuctionUserDao userDao;
	private BidDao bidDao;
	private ItemDao itemDao;
	private KindDao kindDao;
	private BigKindDao bigKindDao;
	private StateDao stateDao;
	private AdminDao adminDao;
	private OrderyiDao orderyiDao; //新增orderyiDao
	private OrderiDao orderiDao; //新增orderyiDao
	//业务逻辑组件发送邮件所依赖的两个Bean
	private MailSender mailSender;
	private SimpleMailMessage message;
	//为业务逻辑组件依赖注入DAO组件所需的setter方法
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
	//为业务逻辑组件注入两个邮件发送Bean的setter方法
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
	 * 根据赢取者查询物品
	 * @param winerId 赢取者的ID
	 * @return 赢取者获得的全部物品
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
			throw new AuctionException("查询用户所赢取的物品出现异常,请重试");
		}
	}

	/**
	 * 查询流拍的全部物品
	 * @return 全部流拍物品
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
			throw new AuctionException("查询流拍物品出现异常,请重试");
		}
	}

	/**
	 * 根据用户名，密码验证登录是否成功
	 * @param username 登录的用户名
 	 * @param pass 登录的密码
	 * @return 登录成功返回用户ID，否则返回-1
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
			throw new AuctionException("处理用户登录出现异常,请重试");
		}
	}

	/**
	 * 查询用户的全部出价
	 * @param userId 竞价用户的ID
	 * @return 用户的全部出价
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
			throw new AuctionException("浏览用户的全部竞价出现异常,请重试");
		}
	}

	/**
	 * 根据用户查找目前仍在拍卖中的全部物品
	 * @param userId 所属者的ID
	 * @return 属于当前用户的、处于拍卖中的全部物品。
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
			throw new AuctionException("查询用户所有的物品出现异常,请重新");
		}
	}

	/**
	 * 查询全部种类
	 * @return 系统中全部全部种类
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
			throw new AuctionException("查询全部种类出现异常,请重试");
		}
	}

	/**
	* 添加物品
	* @param name 物品名称
	* @param desc 物品描述
	* @param remark 物品备注
	* @param avail 有效天数
	* @param kind 物品种类
	* @param userId 添加者的ID
	* @return 新增物品的主键
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
			//创建Item对象
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
			//持久化Item对象
			itemDao.save(item);
			System.out.println("//持久化Item对象");
		return item.getId();
			
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
			throw new AuctionException("添加种类出现异常,请重试");
		}
	}

	/**
	 * 根据产品分类，获取处于拍卖中的全部物品
	 * @param kindId 种类id;
	 * @return 该类的全部产品
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
			throw new AuctionException("根据种类获取物品出现异常,请重试");
		}
	}

	/**
	 * 根据种类id获取种类名
	 * @param kindId 种类id;
	 * @return 该种类的名称
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
			throw new AuctionException("根据种类id获取种类名称出现异常,请重试");
		}
	}

	/**
	 * 根据物品id，获取物品
	 * @param itemId 物品id;
	 * @return 指定id对应的物品
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
			throw new AuctionException("根据物品id获取物品详细信息出现异常,请重试");
		}
	}

	/**
	 * 增加新的竞价，并对竞价用户发邮件通知
	 * @param itemId 物品id;
	 * @param bidPrice 竞价价格
	 * @param userId 竞价用户的ID
	 * @return 返回新增竞价记录的ID
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
			//初始化Bid对象
			Bid bid = new Bid();
			bid.setBidItem(item);
			bid.setBidUser(au);
			bid.setBidDate(new Date());
			bid.setBidPrice(bidPrice);
			//持久化Bid对象
			bidDao.save(bid);
			//准备发送邮件
			SimpleMailMessage msg = new SimpleMailMessage(this.message);
			msg.setTo(au.getEmail());
			msg.setText("Dear "
				+ au.getUsername()
				+ ", 谢谢你参与竞价，你的竞价的物品的是: "
				+ item.getItemName());
			mailSender.send(msg);
			return bid.getId();
		}
		catch(Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("处理用户竞价出现异常,请重试");
		}
	}

	/**
	 * 根据时间来修改物品的状态、赢取者
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
					//根据指定物品和最高竞价来查询用户
					AuctionUser au = bidDao.findUserByItemAndPrice(
						item.getId() , item.getMaxPrice());
					//如果该物品的最高竞价者不为null
					if (au != null)
					{
						//将该竞价者设为赢取者
						item.setWiner(au);
						//修改物品的状态成为“被赢取”
						item.setItemState(stateDao.get(2));
						itemDao.save(item);
						//自动生成竞拍商品赢取的订单
						autoCreateOrderi(au,item);
					}
					else
					{
						//设置该物品的状态为“流拍”
						item.setItemState(stateDao.get(3));
						itemDao.save(item);
						
					}
				}
			}
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("根据时间来修改物品的状态、赢取者出现异常,请重试");
		}
	}
    //新增
	/**
	 * 自动生成竞拍商品赢取的订单的方法
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
		orderi.setOrderiid(countTime.createLiushuihao(date));//订单流水号
	}
	/**
	 * 将一个Bid对象转换成BidBean对象
	 * @param bb BidBean对象
	 * @param bid Bid对象
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
	 * 将一个Item PO转换成ItemBean的VO
	 * @param ib ItemBean的VO
	 * @param item Item的PO
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
			throw new AuctionException("根据种类获取物品出现异常,请重试");
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
		  List list=getNewPaiItemsToList();//得到一个最新竞拍的列表
		  int i=0;
		  for(Iterator it=list.iterator();it.hasNext()&&i<list.size();i++){
			  Item item=(Item)it.next();
			  if(i<3){list1.add(item);
			  System.out.println("竞拍商品名称"+item.getItemName());}
				else if(3<=i&&i<6){list2.add(item);System.out.println("竞拍商品名称"+item.getItemName());}
				else {list3.add(item);System.out.println("竞拍商品名称"+item.getItemName());}
			     }
		  result.add(list1);result.add(list2);result.add(list3);
		return result;
	
	}
	//注册新用户
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
			throw new AuctionException("注册新用户异常");
		}
	}
	
	//修改密码
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
			throw new AuctionException("修改密码异常");
		}
	}
	
	//搜出指定用户的一口价订单
	public List getOrder(Integer userId)throws AuctionException
	{
		try
	{
		List result = new ArrayList();
		System.out.println("前");
		System.out.println(userId);
		result= orderyiDao.findByMember(userId);
		System.out.println("后");
		return result;
	}catch (Exception e)
	{
		log.debug(e.getMessage());
		throw new AuctionException("异常");
	}
		
	}
	
	
	
	
	
	/**找出所有大类**/
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
		throw new AuctionException("查询全部种类出现异常,请重试");
	}
	
}

	
	/**找出所有大类**/
public 	Bigkind getBigKindById(Integer id) throws AuctionException{
	
	return (Bigkind)bigKindDao.get(id);
}

	/**找出所有子类根据大类**/

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
			throw new AuctionException("添加大类别出现异常,请重试");
		}
		
		
		

	}
	
	//管理员登陆
	public int adminLogin(String username , String password)throws AuctionException
	{
		try{
			Admin admin=adminDao.findAdminByNameAndPass(username, password);
			if(admin!=null) return admin.getUserId();
			else return -1;
		}catch(Exception e){log.debug(e.getMessage());
		throw new AuctionException("处理用户登录出现异常,请重试");}
	}
	
	//后台新增，根据种类ID返回种类
	public Kind findKindByIKind(int id)throws AuctionException
	{
		return kindDao.get(id);
	}
	//后台新增，更新种类信息
	public void updateKind(Kind kind)throws AuctionException
	{
		kindDao.update(kind);
	}
	public Item getItemById(int itemId)throws AuctionException
	{
		return itemDao.get(itemId);
	}
	
	//后台新增,更新拍卖品
	public void updateItem(Item item)throws AuctionException
	{
		itemDao.update(item);
	}


/**为了填充double select标签*/
	public Map getBigKindsForMap(){
		Map map=new HashMap();
 //处理后续..
	List<Bigkind>bigkinds=	bigKindDao.findAll();
	
	for(Iterator it=bigkinds.iterator();it.hasNext();){
		Bigkind bigkind=(Bigkind)it.next();
		map.put(bigkind.getBigkindname(),bigkind.getKinds());
		
	}
		return map;
	}
	
	 //后台更新2，根据bigkind ID返回bigkind类
	public Bigkind findBigKindByBigId(int id) throws AuctionException
	{
		return bigKindDao.get(id);
	}
	@Override
	public List findAllBigKind() {
		// TODO Auto-generated method stub
		return bigKindDao.findAll();
	}
	
	//添加大类后，后台更新2，更新bigkind类
	public void updateBigKind(Bigkind bigkind)
	{
		bigKindDao.update(bigkind);
	}
	
	//前台竞拍商品分页测试
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
	//前台竞拍商品分页测试
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
	
    //前台竞拍商品分页测试
	public int getRowsStatePage()
	{
		return itemDao.findItemByState(new Integer(1)).size();
	}
    //前台竞拍商品分页测试
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

    
	////前台新增04-11 14:51:00
	/**
	 * 更据会员获取其赢取的商品
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
    System.out.println("更据会员获取其赢取的商品成功");
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