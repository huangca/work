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
public class AuctionUserDaoHibernate
	extends HibernateDaoSupport implements AuctionUserDao  
{
	/**
	 * 根据id查找用户
	 * @param id 需要查找的用户id
	 */
	public AuctionUser get(Integer id)
	{
		return (AuctionUser)getHibernateTemplate()
			.get(AuctionUser.class , id);
	}

	/**
	 * 增加用户
	 * @param user 需要增加的用户
	 */
	public void save(AuctionUser user)
	{
		getHibernateTemplate().save(user);
	}

	/**
	 * 修改用户
	 * @param user 需要修改的用户
	 */
	public void update(AuctionUser user)
	{
		getHibernateTemplate().saveOrUpdate(user);
	}

	/**
	 * 删除用户
	 * @param id 需要删除的用户id
	 */ 
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * 删除用户
	 * @param user 需要删除的用户
	 */
	public void delete(AuctionUser user)
	{
		getHibernateTemplate().delete(user);
	}

	/**
	 * 查询全部用户
 	 * @return 获得全部用户
	 */ 
	public List<AuctionUser> findAll()
	{
		return (List<AuctionUser>)getHibernateTemplate()
			.find("from AuctionUser");
	}

	/**
	 * 根据用户名，密码查找用户
	 * @param username 查询所需的用户名
	 * @param pass 查询所需的密码
	 * @return 指定用户名、密码对应的用户
	 */
	public AuctionUser findUserByNameAndPass(String username , String pass)
	{
		//执行HQL查询
		List<AuctionUser> ul = (List<AuctionUser>)getHibernateTemplate()
			.find("from AuctionUser au where au.username = ? and au.userpass = ?" ,
			new String[]{username , pass});
		//返回查询得到的第一个AuctionUser对象
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
			//如果已有该用户名则返回1,
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