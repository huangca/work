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
 * Description: <br/>
 * 地址: <a href="http://www.sise.com.cn">华软高效</a> <br/>
 * Copyright (C), 2010-201?, 黄灿华 余宏伟 <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:20100301-20100401
 * 
 * @author hch0612@scse.com.cn
 * @version 1.0
 */
public class YiItemDaoHibernate extends HibernateDaoSupport implements
		YiItemDao {

	@Override
	/**
	 * 删除物品
	 * @param id 需要删除的物品id
	 */
	public void delete(Integer id) {
	
		getHibernateTemplate().delete(get(id));
	}

	@Override
	/**
	 * 删除物品
	 * @param item 需要删除的物品
	 */
	public void delete(YiItem item) {
		
		getHibernateTemplate().delete(item);
	}

	@Override
	/**
	 * 根据产品分类，获取当前一口价的全部商品
	 * @param kindId 种类id;
	 * @return 该类的全部产品
	 */
	public List<YiItem> findYiItemByKind(Integer kindId) {
		
		return (List<YiItem>)getHibernateTemplate()
		.find("from YiItem as i where i.kind.id = ? and i.itemState.id = 4"
		, kindId);
	}

	@Override
	/**
	 * 根据所有者查找处于一口价中的物品 查找发布者
	 * @param useId 所有者Id;
	 * @return 指定用户处于上架中的全部物品
	 */
	public List<YiItem> findYiItemByOwner(Integer userId) {
		
		return (List<YiItem>)getHibernateTemplate()
		.find("from YiItem as y where y.owner.userId = ? and y.itemState.id = 4"
		, userId);
	}

	@Override
	/**
	 * 根据物品状态查找物品
	 * @param stateId 状态Id;
	 * @return 该状态下的全部物品
	 */
	public List<YiItem> findYiItemByState(Integer stateId) {
		
		return (List<YiItem>)getHibernateTemplate()
		.find("from YiItem as y where y.itemState.id = ?" , stateId);
	}



	@Override
	/**
	 * 根据主键查找物品
	 * @param itemId 想查找到物品的id;
	 * @return id对应的物品
	 */
	public YiItem get(Integer itemId) {
				
		return (YiItem)getHibernateTemplate().get(YiItem.class, itemId);
	}

	@Override
	/**
	 * 保存物品
	 * @param item 需要保存的物品
	 */
	public void save(YiItem item) {
		getHibernateTemplate().save(item);
		
	}

	@Override
	/**
	 * 修改物品
	 * @param item 需要修改的物品
	 */
	public void update(YiItem item) {
		getHibernateTemplate().saveOrUpdate(item);
		
	}
	/**
	 * 查找物品
	 * @return 全部物品
	 */
	@Override
	public List<YiItem> findYiItem(){
		//getHibernateTemplate().setMaxResults(6);
		getHibernateTemplate();
		return (List<YiItem>)getHibernateTemplate().find("from YiItem as y");
	}
	
	/**
	 * 查找最新发布的热销商品物品
	 * @return 全部物品
	 */
	public	List<YiItem> findNewYiItemTop(){
		
		//getHibernateTemplate().setMaxResults(9);
		//自行处理只拿9个热销的
		return getHibernateTemplate().executeFind(new HibernateCallback() {

			public List<YiItem> doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO 自动生成方法存根
				Query query = session
						.createQuery("from YiItem as y order by y.addtime desc");
				query.setFirstResult(0);
				query.setMaxResults(9);
				return (List<YiItem>)query.list();
			}
		});

		
		
	}
	
	//分页测试
	public List getYiItemPage(int pageSize, int startRow) throws HibernateException {
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO 自动生成方法存根
				Query query = session
						.createQuery("from YiItem as y");
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
	
	//前后台共用，分页测试
	public List getYiItemStatePage(int pageSize, int startRow,int stateId)
	{
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		final int stateId1=stateId;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO 自动生成方法存根
				Query query = session
						.createQuery("from YiItem as y where y.itemState.id = ?").setInteger(0, stateId1);
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
	//前台分页测试
	public List getYiItemStateKindPage(int pageSize, int startRow,int kindId)
	{
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		final int kindId1=kindId;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO 自动生成方法存根
				Query query = session
						.createQuery("from YiItem as y where y.itemState.id = 4 and y.kind.id = ? ").setInteger(0, kindId1);
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
	
}
