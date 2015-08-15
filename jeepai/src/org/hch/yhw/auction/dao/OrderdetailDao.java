package org.hch.yhw.auction.dao;

import java.util.List;

import org.hch.yhw.auction.model.AuctionUser;
import org.hch.yhw.auction.model.Orderdetail;
import org.hch.yhw.auction.model.Orderyi;

public interface OrderdetailDao {

	/**
	 * 根据id查找订单
	 * @param id 需要查找的订单id
	 */
	Orderdetail get(Integer id);
	
	/**
	 * 增加订单
	 * @param Orderdetail 需要增加的订单
	 */
	void save(Orderdetail orderyi);

	/**
	 * 修改订单
	 * @param Orderdetail 需要修改的订单
	 */
	void update(Orderdetail orderyi);

	/**
	 * 删除订单
	 * @param id 需要删除的订单id
	 */  
	void delete(Integer id);

	/**
	 * 删除用户
	 * @param user 需要删除的订单
	 */
	void delete(Orderdetail orderyi);

	/**
	 * 查询全部订单
 	 * @return 获得全部订单
	 */
	List<Orderdetail> findAll();
	/**
	 * 根据订单号查询全部订单
 	 * @return 获得全部订单明细
	 */
	List<Orderdetail> findByOrderyi(Integer orderyiid);

	
	
}
