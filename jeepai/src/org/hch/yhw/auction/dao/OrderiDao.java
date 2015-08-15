package org.hch.yhw.auction.dao;

import java.util.List;

import org.hch.yhw.auction.model.Orderi;

public interface OrderiDao {
	//根据ID查找订单头详细内容
	 //该表保存了订单ID，个人信息；但不关联商品
		/**
		 * 根据id查找订单
		 * @param id 需要查找的竞拍品订单id
		 */
		Orderi get(Integer id);
		
		/**
		 * 增加订单
		 * @param Orderi 需要增加的竞拍品订单
		 */
		void save(Orderi orderi);

		/**
		 * 修改订单
		 * @param Orderi 需要修改竞拍品的订单
		 */
		void update(Orderi orderi);

		/**
		 * 删除订单
		 * @param id 需要删除的竞拍品订单id
		 */  
		void delete(Integer id);

		/**
		 * 删除用户
		 * @param Orderi 需要删除竞拍品的订单
		 */
		void delete(Orderi orderi);

		/**
		 * 查询全部订单
	 	 * @return 获得全部竞拍品订单
		 */
		List<Orderi> findAll();
		/**
		 * 根据会员查询全部订单
	 	 * @return 获得全部竞拍品订单
		 */
		List<Orderi> findByMember(Integer userId);
		/**
		 * 根据状态查询全部订单
	 	 * @return 获得全部订单--处理的？没处理的
		 */
		List<Orderi> findBySign(boolean flag);
		/**
		 * 根据状态查询订单号
	 	 * @return 获得订单
		 */
		Orderi findByOrderi(String orderId);
}
