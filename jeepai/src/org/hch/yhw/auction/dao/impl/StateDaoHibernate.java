package org.hch.yhw.auction.dao.impl;

import java.util.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.dao.*;
import org.hch.yhw.auction.model.*;
import org.hibernate.Hibernate;


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
public class StateDaoHibernate
	extends HibernateDaoSupport implements StateDao  
{
	/**
	 * ����id����״̬
	 * @param id ��Ҫ���ҵ�״̬id
	 */
	public State get(Integer id)
	{
	return (State)getHibernateTemplate().get(State.class , id);
	}
	/**
	 * ����״̬
	 * @param state ��Ҫ���ӵ�״̬
	 */  
	public void save(State state)
	{
		getHibernateTemplate().save(state);
	}

	/**
	 * �޸�״̬
	 * @param state ��Ҫ�޸ĵ�״̬
	 */
	public void update(State state)
	{
		getHibernateTemplate().saveOrUpdate(state);
	}

	/**
	 * ɾ��״̬
	 * @param id ��Ҫɾ����״̬id
	 */
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * ɾ��״̬
	 * @param state ��Ҫɾ����״̬
	 */
	public void delete(State state)
	{
		getHibernateTemplate().delete(state);
	}

	/**
	 * ��ѯȫ������
	 * @return ���ȫ������
	 */
	public List<State> findAll()
	{
		return (List<State>)getHibernateTemplate().find("from State");
	}
}