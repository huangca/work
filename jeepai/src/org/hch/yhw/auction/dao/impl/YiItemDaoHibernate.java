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
 * ��ַ: <a href="http://www.sise.com.cn">�����Ч</a> <br/>
 * Copyright (C), 2010-201?, �Ʋӻ� ���ΰ <br/>
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
	 * ɾ����Ʒ
	 * @param id ��Ҫɾ������Ʒid
	 */
	public void delete(Integer id) {
	
		getHibernateTemplate().delete(get(id));
	}

	@Override
	/**
	 * ɾ����Ʒ
	 * @param item ��Ҫɾ������Ʒ
	 */
	public void delete(YiItem item) {
		
		getHibernateTemplate().delete(item);
	}

	@Override
	/**
	 * ���ݲ�Ʒ���࣬��ȡ��ǰһ�ڼ۵�ȫ����Ʒ
	 * @param kindId ����id;
	 * @return �����ȫ����Ʒ
	 */
	public List<YiItem> findYiItemByKind(Integer kindId) {
		
		return (List<YiItem>)getHibernateTemplate()
		.find("from YiItem as i where i.kind.id = ? and i.itemState.id = 4"
		, kindId);
	}

	@Override
	/**
	 * ���������߲��Ҵ���һ�ڼ��е���Ʒ ���ҷ�����
	 * @param useId ������Id;
	 * @return ָ���û������ϼ��е�ȫ����Ʒ
	 */
	public List<YiItem> findYiItemByOwner(Integer userId) {
		
		return (List<YiItem>)getHibernateTemplate()
		.find("from YiItem as y where y.owner.userId = ? and y.itemState.id = 4"
		, userId);
	}

	@Override
	/**
	 * ������Ʒ״̬������Ʒ
	 * @param stateId ״̬Id;
	 * @return ��״̬�µ�ȫ����Ʒ
	 */
	public List<YiItem> findYiItemByState(Integer stateId) {
		
		return (List<YiItem>)getHibernateTemplate()
		.find("from YiItem as y where y.itemState.id = ?" , stateId);
	}



	@Override
	/**
	 * ��������������Ʒ
	 * @param itemId ����ҵ���Ʒ��id;
	 * @return id��Ӧ����Ʒ
	 */
	public YiItem get(Integer itemId) {
				
		return (YiItem)getHibernateTemplate().get(YiItem.class, itemId);
	}

	@Override
	/**
	 * ������Ʒ
	 * @param item ��Ҫ�������Ʒ
	 */
	public void save(YiItem item) {
		getHibernateTemplate().save(item);
		
	}

	@Override
	/**
	 * �޸���Ʒ
	 * @param item ��Ҫ�޸ĵ���Ʒ
	 */
	public void update(YiItem item) {
		getHibernateTemplate().saveOrUpdate(item);
		
	}
	/**
	 * ������Ʒ
	 * @return ȫ����Ʒ
	 */
	@Override
	public List<YiItem> findYiItem(){
		//getHibernateTemplate().setMaxResults(6);
		getHibernateTemplate();
		return (List<YiItem>)getHibernateTemplate().find("from YiItem as y");
	}
	
	/**
	 * �������·�����������Ʒ��Ʒ
	 * @return ȫ����Ʒ
	 */
	public	List<YiItem> findNewYiItemTop(){
		
		//getHibernateTemplate().setMaxResults(9);
		//���д���ֻ��9��������
		return getHibernateTemplate().executeFind(new HibernateCallback() {

			public List<YiItem> doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO �Զ����ɷ������
				Query query = session
						.createQuery("from YiItem as y order by y.addtime desc");
				query.setFirstResult(0);
				query.setMaxResults(9);
				return (List<YiItem>)query.list();
			}
		});

		
		
	}
	
	//��ҳ����
	public List getYiItemPage(int pageSize, int startRow) throws HibernateException {
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO �Զ����ɷ������
				Query query = session
						.createQuery("from YiItem as y");
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
	
	//ǰ��̨���ã���ҳ����
	public List getYiItemStatePage(int pageSize, int startRow,int stateId)
	{
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		final int stateId1=stateId;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO �Զ����ɷ������
				Query query = session
						.createQuery("from YiItem as y where y.itemState.id = ?").setInteger(0, stateId1);
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
	//ǰ̨��ҳ����
	public List getYiItemStateKindPage(int pageSize, int startRow,int kindId)
	{
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		final int kindId1=kindId;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO �Զ����ɷ������
				Query query = session
						.createQuery("from YiItem as y where y.itemState.id = 4 and y.kind.id = ? ").setInteger(0, kindId1);
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
	
}
