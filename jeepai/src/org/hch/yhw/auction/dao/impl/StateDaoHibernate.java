package org.hch.yhw.auction.dao.impl;

import java.util.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.dao.*;
import org.hch.yhw.auction.model.*;
import org.hibernate.Hibernate;


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
public class StateDaoHibernate
	extends HibernateDaoSupport implements StateDao  
{
	/**
	 * 根据id查找状态
	 * @param id 需要查找的状态id
	 */
	public State get(Integer id)
	{
	return (State)getHibernateTemplate().get(State.class , id);
	}
	/**
	 * 增加状态
	 * @param state 需要增加的状态
	 */  
	public void save(State state)
	{
		getHibernateTemplate().save(state);
	}

	/**
	 * 修改状态
	 * @param state 需要修改的状态
	 */
	public void update(State state)
	{
		getHibernateTemplate().saveOrUpdate(state);
	}

	/**
	 * 删除状态
	 * @param id 需要删除的状态id
	 */
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * 删除状态
	 * @param state 需要删除的状态
	 */
	public void delete(State state)
	{
		getHibernateTemplate().delete(state);
	}

	/**
	 * 查询全部种类
	 * @return 获得全部种类
	 */
	public List<State> findAll()
	{
		return (List<State>)getHibernateTemplate().find("from State");
	}
}