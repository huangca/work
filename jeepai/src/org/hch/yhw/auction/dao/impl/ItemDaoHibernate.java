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
 * <br/>��ַ: <a href="http://www.sise.com.cn">�����Ч</a> 
 * <br/>Copyright (C), 2010-201?, �Ʋӻ�   ���ΰ
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
	 * ��������������Ʒ
	 * @param itemId ����ҵ���Ʒ��id;
	 * @return id��Ӧ����Ʒ
	 */
	public Item get(Integer itemId)
	{
		return (Item)getHibernateTemplate().get(Item.class , itemId);
	}

	/**
	 * ������Ʒ
	 * @param item ��Ҫ�������Ʒ
	 */
	public void save(Item item)
	{
		getHibernateTemplate().save(item);
	}

	/**
	 * �޸���Ʒ
	 * @param item ��Ҫ�޸ĵ���Ʒ
	 */
	public void update(Item item)
	{
		getHibernateTemplate().saveOrUpdate(item);
	}

	/**
	 * ɾ����Ʒ
	 * @param id ��Ҫɾ������Ʒid
	 */
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * ɾ����Ʒ
	 * @param item ��Ҫɾ������Ʒ
	 */
	public void delete(Item item)
	{
		getHibernateTemplate().delete(item);
	}

	/**
	 * ���ݲ�Ʒ���࣬��ȡ��ǰ������ȫ����Ʒ
	 * @param kindId ����id;
	 * @return �����ȫ����Ʒ
	 */
	public List<Item> findItemByKind(Integer kindId)
	{
		return (List<Item>)getHibernateTemplate()
			.find("from Item as i where i.kind.id = ? and i.itemState.id = 1"
			, kindId);
	}

	/**
	 * ���������߲��Ҵ��������е���Ʒ
	 * @param useId ������Id;
	 * @return ָ���û����������е�ȫ����Ʒ
	 */
	public List<Item> findItemByOwner(Integer userId)
	{
		return (List<Item>)getHibernateTemplate()
			.find("from Item as i where i.owner.userId = ? and i.itemState.id = 1"
			, userId);
	}

	/**
	 * ����Ӯȡ�߲�����Ʒ
	 * @param userId Ӯȡ��Id;
	 * @return ָ���û�Ӯȡ��ȫ����Ʒ
	 */
	public List<Item> findItemByWiner(Integer userId)
	{
		return (List<Item>)getHibernateTemplate()
			.find("from Item as i where i.winer.id = ? and i.itemState.id = 2"
			,userId);
	}

	/**
	 * ������Ʒ״̬������Ʒ
	 * @param stateId ״̬Id;
	 * @return ��״̬�µ�ȫ����Ʒ
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
				// TODO �Զ����ɷ������
				Query query = session
						.createQuery("from Item as i where i.itemState.id = 1 order by i.addtime desc");
				query.setFirstResult(0);
				query.setMaxResults(9);
				return (List<Item>)query.list();
			}
		});
	}
	
	//��ҳ����
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
	
	//��ҳ����
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