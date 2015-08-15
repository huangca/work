package org.hch.yhw.auction.dao.impl;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.dao.*;
import org.hch.yhw.auction.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

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
public class ItemDaoHibernate
	extends HibernateDaoSupport implements ItemDao  
{
	/**
	 * 根据主键查找物品
	 * @param itemId 想查找到物品的id;
	 * @return id对应的物品
	 */
	public Item get(Integer itemId)
	{
		return (Item)getHibernateTemplate().get(Item.class , itemId);
	}

	/**
	 * 保存物品
	 * @param item 需要保存的物品
	 */
	public void save(Item item)
	{
		getHibernateTemplate().save(item);
	}

	/**
	 * 修改物品
	 * @param item 需要修改的物品
	 */
	public void update(Item item)
	{
		getHibernateTemplate().saveOrUpdate(item);
	}

	/**
	 * 删除物品
	 * @param id 需要删除的物品id
	 */
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * 删除物品
	 * @param item 需要删除的物品
	 */
	public void delete(Item item)
	{
		getHibernateTemplate().delete(item);
	}

	/**
	 * 根据产品分类，获取当前拍卖的全部商品
	 * @param kindId 种类id;
	 * @return 该类的全部产品
	 */
	public List<Item> findItemByKind(Integer kindId)
	{
		return (List<Item>)getHibernateTemplate()
			.find("from Item as i where i.kind.id = ? and i.itemState.id = 1"
			, kindId);
	}

	/**
	 * 根据所有者查找处于拍卖中的物品
	 * @param useId 所有者Id;
	 * @return 指定用户处于拍卖中的全部物品
	 */
	public List<Item> findItemByOwner(Integer userId)
	{
		return (List<Item>)getHibernateTemplate()
			.find("from Item as i where i.owner.userId = ? and i.itemState.id = 1"
			, userId);
	}

	/**
	 * 根据赢取者查找物品
	 * @param userId 赢取者Id;
	 * @return 指定用户赢取的全部物品
	 */
	public List<Item> findItemByWiner(Integer userId)
	{
		return (List<Item>)getHibernateTemplate()
			.find("from Item as i where i.winer.id = ? and i.itemState.id = 2"
			,userId);
	}

	/**
	 * 根据物品状态查找物品
	 * @param stateId 状态Id;
	 * @return 该状态下的全部物品
	 */
	public List<Item> findItemByState(Integer stateId)
	{
		return (List<Item>)getHibernateTemplate()
			.find("from Item as i where i.itemState.id = ?" , stateId);
	}
	
	public 	List<Item> findAll(){
		return (List<Item>)getHibernateTemplate()
		.find("from Item as i");
		
	}
	public List<Item> findItemByStateOrderByDate(){
		//getHibernateTemplate().setMaxResults(9);
	//	return (List<Item>)getHibernateTemplate()
	//	.find("from Item as i where i.itemState.id = 1 order by i.addtime desc");
		
		return getHibernateTemplate().executeFind(new HibernateCallback() {

			public List<Item> doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO 自动生成方法存根
				Query query = session
						.createQuery("from Item as i where i.itemState.id = 1 order by i.addtime desc");
				query.setFirstResult(0);
				query.setMaxResults(9);
				return (List<Item>)query.list();
			}
		});
	}
	
	//分页测试
	public List getAllItemStatePage(int pageSize, int startRow)throws HibernateException {
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
			
				Query query = session
						.createQuery("from Item as i where i.itemState.id = 1");
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
	
	//分页测试
	public List getItemStateKindPage(int pageSize, int startRow,int kindId)throws HibernateException {
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		final int kindId1=kindId;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
			
				String hql="from Item as i where i.kind.id ="+kindId1+" and i.itemState.id = 1";
				Query query = session
						.createQuery(hql);
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
}