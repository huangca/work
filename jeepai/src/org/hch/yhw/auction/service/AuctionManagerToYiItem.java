package org.hch.yhw.auction.service;

import java.util.List;

import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.dao.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.State;
import org.hch.yhw.auction.model.YiItem;
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
/**
 * 对一口价商品进行处理的接口
 * */
public interface AuctionManagerToYiItem {

	  /**
	  * 以下的方法是对一口价商品进行处理的
	  * */
	
	/**
	 * 根据购买者查询物品
	 * @param winerId 购买者的ID
	 * @return 购买者购买的全部物品
	 */
	/*List getYiItemByWiner(Integer winerId) 
		throws AuctionException;
*/
	/**
	 * 查询一口价的全部物品
	 * @return 全部一口价物品
	 */
	List getFullItems()throws AuctionException;
	/**
	 * 查询一口价的上架架物品
	 * @return 全部一口价物品
	 */
	List getOnlineItems()throws AuctionException;
	/**
	 * 查询一口价的全部下架物品
	 * @return 全部一口价物品
	 */
	List getDownlineItems()throws AuctionException;

	/**
	 * 根据用户名，密码验证登录是否成功
	 * @param username 登录的用户名
 	 * @param pass 登录的密码
	 * @return 登录成功返回用户ID，否则返回-1
	 */
	/*int validLogin(String username , String pass)
		throws AuctionException;*/

	/**
	 * 根据用户查找目前仍在上架中的全部物品
	 * @param userId 所属者的ID
	 * @return 、处于上架中的全部物品。
	 */
	List getYiItemsByOwner(Integer userId)
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
		double initPrice , int avail , int kind , Integer userId,int bigkindid,int number) 
		throws AuctionException;

	/**
	 * 添加种类
	 * @param name 种类名称
	 * @param desc 种类描述
	 * @return 新增种类的主键
	 */ 
	//int addKind(String name , String desc) throws AuctionException;

	/**
	 * 根据产品分类，获取处于上架中的全部物品
	 * @param kindId 种类id;
	 * @return 该类的全部产品
	 */
	List getYiItemsByKind(int kindId) throws AuctionException;

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
	YiItemBean getYiItem(int itemId) throws AuctionException;

	/**
	 * 增加新的竞价，并对竞价用户发邮件通知
	 * @param itemId 物品id;
	 * @param bidPrice 竞价价格
	 * @param userId 竞价用户的ID
	 * @return 返回新增竞价记录的ID
	 */
	

	/**
	 * 根据时间来修改物品的赢取者
	 */
	void updateWiner(Integer yitemid,Integer wid)throws AuctionException;
	
	/**
	 * 根据时间来获取热销商品
	 */
      
	 List<YiItem> getNewSaleYiItems()throws AuctionException;
	
	 List getNewSaleYiItemsToList()throws AuctionException;
     /**
      * 对购物车进行操作
      * */
      
      /**方法一
       * 向购物车添加某商品，并返回一个列表
       * */ 
      List<CartBean> putCartBeans(int number,Integer yitemid,List<CartBean> fromList)throws Exception;
      /**方法二
       * 计算购物车想在的总价钱
       * */   
      double summomey(List<CartBean> fromList)throws Exception;
      /**方法三
       * 清空购物车中的某件商品
       * */  
      List<CartBean> removeCartBeanById(Integer id,List<CartBean> fromList)throws Exception;

      //后台新增，根据ID返回一口价商品的model
      YiItem getYiItemById(Integer id)throws Exception;
    //后台新增,返回所有state
      List getAllState()throws Exception;
    //后台新增，根据state ID返回state model
      State findStateByStateId(int id) throws Exception;
      //后台新增，更新一口价商品
      void updateYiItem(YiItem yiItem)throws Exception;

      //前台分页测试
  	int getRows();
  	 //前台分页测试
  	int getKindRows(int kindId);
  	
    
  //分页测试
      List getAllItemPage(int pageSize,int startRow);
    
    //前台分页测试
      List getAllItemStatePage(int pageSize,int startRow,int stateId);
      //前台分页测试
      List getAllItemStateKindPage(int pageSize,int startRow,int kindId);
      
      //后台分页测试
      int getAllRows();
      //后台分页测试
      int getStateRoes(int stateid);

}
