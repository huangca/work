package org.hch.yhw.auction.dao.impl;

import java.util.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.dao.*;
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
public class KindDaoHibernate 
	extends HibernateDaoSupport implements KindDao  
{
	/**
	 * 根据id查找种类
	 * @param id 需要查找的种类的id
	 */
	public Kind get(Integer id)
	{
		return (Kind)getHibernateTemplate().get(Kind.class , id);
	}

	/**
	 * 增加种类
	 * @param kind 需要增加的种类
	 */
	public void save(Kind kind)
	{
		getHibernateTemplate().save(kind);  
	}

	/**
	 * 修改种类
	 * @param kind 需要修改的种类
	 */ 
	public void update(Kind kind)
	{
		getHibernateTemplate().saveOrUpdate(kind);  
	}

	/**
	 * 删除种类
	 * @param id 需要删除的种类id
	 */ 
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));  
	}

	/**
	 * 删除种类
	 * @param kind 需要删除的种类
	 */
	public void delete(Kind kind)
	{
		getHibernateTemplate().delete(kind);  
	}

	/**
	 * 查询全部种类
	 * @return 获得全部种类
	 */
	public List<Kind> findAll()
	{
		return (List<Kind>)getHibernateTemplate().find("from Kind");
	}

	@Override
	public List<Kind> findAllByBigKind(Bigkind bigKind) {
		// TODO Auto-generated method stub
		 return findAllByBigKindId(bigKind.getBigkindId());
	}

	@Override
	public List<Kind> findAllByBigKindId(Integer bigkindId) {
		// TODO Auto-generated method stub
		 return (List<Kind>)getHibernateTemplate().find("from Kind as k where k.bigkind.bigkindId=?",bigkindId);
	}
	
	
	
}
