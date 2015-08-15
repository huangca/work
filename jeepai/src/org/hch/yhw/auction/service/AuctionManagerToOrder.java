package org.hch.yhw.auction.service;
import java.util.List;

import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.Orderdetail;
import org.hch.yhw.auction.model.Orderyi;
public interface AuctionManagerToOrder {
	/**
	 * 根据会员ID查询其订单
	 * @param userid 
	 * @return 会员订单LIST
	 */
	List<Orderyi>  getOrderyiByAuctionUserId(Integer userid)throws AuctionException;
	/**
	 * 订单Bean
	 * @param orderBean 
	 * @return 会员订单号
	 */
	int addOrderyiOnOrderBean(OrderBean orderBean)throws AuctionException;
	/** 
	 * 会员删除订单
	 * */
	void deleteOrderyiByOid(Integer orderId)throws AuctionException;
	/** 
	 * 修改订单
	 * 可以完成修改总价钱，是否处理了等业务
	 * */
	void updateOrderyi(Orderyi orderyi)throws AuctionException;
	
	
	void updateOrderdetail(Orderdetail orderdetail)throws AuctionException;
	/** 
	 * 添加订单头
	 * */
	int addOrderyiOnOrderyi(Integer userid,double summoney,String realname,String address,String telphone
			,String postcode,String model,String message,int cartSize)throws AuctionException;
	//int addOrderyiOnOrderyi(OrderBean orderBean);
	/**
	 * 为订单的明细服务
	 * */
	/**
	 * 添加订单的明细
	 */
	int addOrderdetail(Integer orderid,Integer yiitemid,double xiaoji,int number)throws AuctionException;
    /**
    * 删除某一明细记录，如某商品货源不足，删除某项等，重算价钱
    * 由于时间关系不打算做；
    * */
	void deleteOrderdetailByid(Integer id)throws AuctionException;
	
	void addOrderdetailOnOrderBean(OrderBean orderBean)throws AuctionException;
	Orderyi getOrderyiByOrderyiId(Integer orderid)throws AuctionException;
	/**
	 * 根据某一订单ID查询返回一张完整的
	 * */
	MemberOrderBean findWholeOrderByOrderyiId(Integer id)throws AuctionException;
	/**根据提交的订单，持久到数据库*/
	int addOrderyiAtOneTime(OrderBean orderBean)throws AuctionException;

	//后台新增，返回所有订单
	List<Orderyi>  getAllOrderyi()throws AuctionException;
	//后台新增，根据SIGN返回订单
	List<Orderyi>  getOrderyiBySign(boolean flag)throws AuctionException;
	//后台新增,管理员修改订单
	void updateO(Integer orderid,int number);
	void deleteO(Integer orderid);
	//根据新增的字段获取订单BEAN
	MemberOrderBean findOrderByOrderyiid(String orderyiid);
	//根据新增的字段获取订单model
	Orderyi getOrderByOrderyiid(String orderyiid);
	//
	void deleteOrderyiByModel(String orderyiid);
}
