package org.hch.yhw.auction.dao.impl;

import java.util.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.dao.*;
import org.hch.yhw.auction.model.*;

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
public class KindDaoHibernate 
	extends HibernateDaoSupport implements KindDao  
{
	/**
	 * ����id��������
	 * @param id ��Ҫ���ҵ������id
	 */
	public Kind get(Integer id)
	{
		return (Kind)getHibernateTemplate().get(Kind.class , id);
	}

	/**
	 * ��������
	 * @param kind ��Ҫ���ӵ�����
	 */
	public void save(Kind kind)
	{
		getHibernateTemplate().save(kind);  
	}

	/**
	 * �޸�����
	 * @param kind ��Ҫ�޸ĵ�����
	 */ 
	public void update(Kind kind)
	{
		getHibernateTemplate().saveOrUpdate(kind);  
	}

	/**
	 * ɾ������
	 * @param id ��Ҫɾ��������id
	 */ 
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));  
	}

	/**
	 * ɾ������
	 * @param kind ��Ҫɾ��������
	 */
	public void delete(Kind kind)
	{
		getHibernateTemplate().delete(kind);  
	}

	/**
	 * ��ѯȫ������
	 * @return ���ȫ������
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
