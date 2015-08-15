package org.hch.yhw.auction.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.dao.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.Bigkind;
import org.hch.yhw.auction.model.Item;
import org.hch.yhw.auction.model.Kind;

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
public interface AuctionManager  
{
	/**
	 * 根据赢取者查询物品
	 * @param winerId 赢取者的ID
	 * @return 赢取者获得的全部物品
	 */
	List getItemByWiner(Integer winerId) 
		throws AuctionException;

	/**
	 * 查询流拍的全部物品
	 * @return 全部流拍物品
	 */
	List getFailItems()throws AuctionException;

	/**
	 * 根据用户名，密码验证登录是否成功
	 * @param username 登录的用户名
 	 * @param pass 登录的密码
	 * @return 登录成功返回用户ID，否则返回-1
	 */
	int validLogin(String username , String pass)
		throws AuctionException;

	/**
	 * 查询用户的全部出价
	 * @param userId 竞价用户的ID
	 * @return 用户的全部出价
	 */
	List getBidByUser(Integer userId)
		throws AuctionException;

	/**
	 * 根据用户查找目前仍在拍卖中的全部物品
	 * @param userId 所属者的ID
	 * @return 属于当前用户的、处于拍卖中的全部物品。
	 */
	List getItemsByOwner(Integer userId)
		throws AuctionException;

	/**
	 * 查询全部种类
	 * @return 系统中全部全部种类
	 */
	List getAllKind() throws AuctionException; 

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
	int addItem(String name , String desc , String remark , String picname,
		double initPrice , int avail , int kind , Integer userId,int bigkindid,int zengfu) 
		throws AuctionException;

	/**
	 * 添加种类
	 * @param name 种类名称
	 * @param desc 种类描述
	 * @return 新增种类的主键
	 */ 
	int addKind(String name , String desc,int bigkindid) throws AuctionException;

	/**
	 * 根据产品分类，获取处于拍卖中的全部物品
	 * @param kindId 种类id;
	 * @return 该类的全部产品
	 */
	List getItemsByKind(int kindId) throws AuctionException;

	/**
	 * 根据种类id获取种类名
	 * @param kindId 种类id;
	 * @return 该种类的名称
	 */
	String getKind(int kindId) throws AuctionException;

	/**
	 * 根据物品id，获取物品
	 * @param itemId 物品id;
	 * @return 指定id对应的物品
	 */
	ItemBean getItem(int itemId) throws AuctionException;

	/**
	 * 增加新的竞价，并对竞价用户发邮件通知
	 * @param itemId 物品id;
	 * @param bidPrice 竞价价格
	 * @param userId 竞价用户的ID
	 * @return 返回新增竞价记录的ID
	 */
	int addBid(int itemId , double bidPrice ,Integer userId)
		throws AuctionException;

	/**
	 * 根据时间来修改物品的赢取者
	 */
	void updateWiner()throws AuctionException;
	List getAllJingpaiItem()throws AuctionException;
	/**
	 * 收索最新的热拍商品
	 */
	List  findItemByStateOrderByDate()throws AuctionException;
	//注册新用户
	int addUser(String username,String password,String email,String realname,String postcode,String address
	,String telphone,int questionid,String answer)throws AuctionException;
	//修改密码
	boolean checkPw(String username,String opassword,String npassword) throws AuctionException;
	//搜出指定用户的一口价订单
	List getOrder(Integer userId)throws AuctionException;
	
	
	/**找出所有大类**/
	List getAllBigKind() throws AuctionException;

	
	/**找出所有大类**/
	Bigkind getBigKindById(Integer id) throws AuctionException;

	/**找出所有子类根据大类**/

	List getAllkindByBigKind(Bigkind bigkind) throws AuctionException;


    List filldoubleselect()throws AuctionException;
	/**
	 * 添加种类
	 * @param name 种类名称
	 * @param desc 种类描述
	 * @return 新增种类的主键
	 */ 
	int addBigKind(String name , String desc) throws AuctionException;

	//后台新增,管理员登陆
	int adminLogin(String username , String password)throws AuctionException;
	//后台新增，根据种类ID返回种类
	Kind findKindByIKind(int id)throws AuctionException;
//后台新增，更新种类信息
	void updateKind(Kind kind)throws AuctionException;
	//后台新增，根据ID搜拍卖品MODEL
	Item getItemById(int itemId)throws AuctionException;
	//后台新增,更新拍卖品
	void updateItem(Item item)throws AuctionException;
	 //添加大类后，后台更新2，根据bigkind ID返回bigkind类
	Bigkind findBigKindByBigId(int id) throws AuctionException;
	//添加大类后，后台更新2，返回所有bigkind类
	List findAllBigKind();
	//添加大类后，后台更新2，更新bigkind类
	void updateBigKind(Bigkind bigkind);
	
	//前台竞拍商品分页测试
	int getRowsStatePage();
    //前台竞拍商品分页测试
	int getRowsStateKindPage(int kindId);
	//前台竞拍商品分页测试
	List getAllItemStatePage(int pageSize,int startRow);
	//前台竞拍商品分页测试
	List getAllItemStateKindPage(int pageSize,int startRow,int kindId);
	
	Map getBigKindsForMap();
	List getAllBigKindNotOther() throws AuctionException;
	//查看竞得商品
	List<OrderiBean> getOrderiByMember(Integer winer)throws AuctionException;
	//删除赢取品单  
	void deleteOrderi(String orderid);
	//更新赢取者订单状态
	void updateOrderiSign(String orderid);
	void updateOrderiCinSign(OrderiBean orderiBean);
	void updateOrderiFukuanSign(String orderid);
	//查找所有的赢取者订单
	List<OrderiBean> findAllOrderis();
	OrderiBean getOrderiByOrderId(String orderid);

}