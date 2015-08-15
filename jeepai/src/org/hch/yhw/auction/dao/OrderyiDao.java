package org.hch.yhw.auction.dao;

import java.util.List;

import org.hch.yhw.auction.model.AuctionUser;
import org.hch.yhw.auction.model.Orderyi;



public interface OrderyiDao {
 //根据ID查找订单头详细内容
 //该表保存了订单ID，个人信息；但不关联商品
	/**
	 * 根据id查找订单
	 * @param id 需要查找的订单id
	 */
	Orderyi get(Integer id);
	
	/**
	 * 增加订单
	 * @param Orderyi 需要增加的订单
	 */
	void save(Orderyi orderyi);

	/**
	 * 修改订单
	 * @param Orderyi 需要修改的订单
	 */
	void update(Orderyi orderyi);

	/**
	 * 删除订单
	 * @param id 需要删除的订单id
	 */  
	void delete(Integer id);

	/**
	 * 删除用户
	 * @param Orderyi 需要删除的订单
	 */
	void delete(Orderyi orderyi);

	/**
	 * 查询全部订单
 	 * @return 获得全部订单
	 */
	List<Orderyi> findAll();
	/**
	 * 根据会员查询全部订单
 	 * @return 获得全部订单
	 */
	List<Orderyi> findByMember(Integer userId);
	/**
	 * 根据状态查询全部订单
 	 * @return 获得全部订单--处理的？没处理的
	 */
	List<Orderyi> findBySign(boolean flag);
	
	//根据orderyiid搜订单
	Orderyi findByOrderyiid(String Orderyiid);
}
