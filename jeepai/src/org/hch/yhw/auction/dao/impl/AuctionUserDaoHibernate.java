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
public class AuctionUserDaoHibernate
	extends HibernateDaoSupport implements AuctionUserDao  
{
	/**
	 * ����id�����û�
	 * @param id ��Ҫ���ҵ��û�id
	 */
	public AuctionUser get(Integer id)
	{
		return (AuctionUser)getHibernateTemplate()
			.get(AuctionUser.class , id);
	}

	/**
	 * �����û�
	 * @param user ��Ҫ���ӵ��û�
	 */
	public void save(AuctionUser user)
	{
		getHibernateTemplate().save(user);
	}

	/**
	 * �޸��û�
	 * @param user ��Ҫ�޸ĵ��û�
	 */
	public void update(AuctionUser user)
	{
		getHibernateTemplate().saveOrUpdate(user);
	}

	/**
	 * ɾ���û�
	 * @param id ��Ҫɾ�����û�id
	 */ 
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * ɾ���û�
	 * @param user ��Ҫɾ�����û�
	 */
	public void delete(AuctionUser user)
	{
		getHibernateTemplate().delete(user);
	}

	/**
	 * ��ѯȫ���û�
 	 * @return ���ȫ���û�
	 */ 
	public List<AuctionUser> findAll()
	{
		return (List<AuctionUser>)getHibernateTemplate()
			.find("from AuctionUser");
	}

	/**
	 * �����û�������������û�
	 * @param username ��ѯ������û���
	 * @param pass ��ѯ���������
	 * @return ָ���û����������Ӧ���û�
	 */
	public AuctionUser findUserByNameAndPass(String username , String pass)
	{
		//ִ��HQL��ѯ
		List<AuctionUser> ul = (List<AuctionUser>)getHibernateTemplate()
			.find("from AuctionUser au where au.username = ? and au.userpass = ?" ,
			new String[]{username , pass});
		//���ز�ѯ�õ��ĵ�һ��AuctionUser����
		if (ul.size() == 1)
		{
			return (AuctionUser)ul.get(0);
		}
		return null;
	}

	@Override
	public boolean isExctUser(String username) {
		List<AuctionUser> ul = (List<AuctionUser>)getHibernateTemplate()
		.find("from AuctionUser au where au.username = ?" ,
				username);
		if (ul.size() == 1)
		{
			//������и��û����򷵻�1,
			return true;}
		return false;
	}

	@Override
	public AuctionUser getUserByName(String username) {
		// TODO Auto-generated method stub
		return (AuctionUser)getHibernateTemplate()
		.find("from AuctionUser au where au.username = ?" ,
				username).get(0);
	}
	
	
}