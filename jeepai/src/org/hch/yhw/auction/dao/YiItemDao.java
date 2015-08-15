package org.hch.yhw.auction.dao;

import java.util.List;

import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.model.*;
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
public interface YiItemDao {
	/**
	 * 根据主键查找物品
	 * @param itemId 想查找到物品的id;
	 * @return id对应的物品
	 */
	YiItem get(Integer itemId);

	/**
	 * 保存物品
	 * @param item 需要保存的物品
	 */
	void save(YiItem item);

	/**
	 * 修改物品
	 * @param item 需要修改的物品
	 */
	void update(YiItem item);

	/**
	 * 删除物品
	 * @param id 需要删除的物品id
	 */
	void delete(Integer id);

	/**
	 * 删除物品
	 * @param item 需要删除的物品
	 */
	void delete(YiItem item);

	/**
	 * 根据产品分类，获取当前拍卖的全部商品
	 * @param kindId 种类id;
	 * @return 该类的全部产品
	 */
	List<YiItem> findYiItemByKind(Integer kindId);

	/**
	 * 根据所有者查找处于拍卖中的物品
	 * @param useId 所有者Id;
	 * @return 指定用户处于拍卖中的全部物品
	 */
	List<YiItem> findYiItemByOwner(Integer userId);



	/**
	 * 根据物品状态查找物品
	 * @param stateId 状态Id;
	 * @return 该状态下的全部物品
	 */
	List<YiItem> findYiItemByState(Integer stateId);
	/**
	 * 查找物品
	 * @return 全部物品
	 */
	List<YiItem> findYiItem();
	/**
	 * 查找最新发布的热销商品物品
	 * @return 全部物品
	 */
	List<YiItem> findNewYiItemTop();
	
	//分页测试（变成后台）
	List getYiItemPage(int pageSize, int startRow);
	//前台分页测试
	List getYiItemStatePage(int pageSize, int startRow,int stateId);
	//前台分页测试
	List getYiItemStateKindPage(int pageSize, int startRow,int kindId);
}
