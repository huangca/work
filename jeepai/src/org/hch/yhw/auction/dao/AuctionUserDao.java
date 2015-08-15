package org.hch.yhw.auction.dao;

import java.util.List;

import org.hch.yhw.auction.business.*;
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
public interface AuctionUserDao  
{
	/**
	 * ����id�����û�
	 * @param id ��Ҫ���ҵ��û�id
	 */
	AuctionUser get(Integer id);
	
	/**
	 * �����û�
	 * @param user ��Ҫ���ӵ��û�
	 */
	void save(AuctionUser user);

	/**
	 * �޸��û�
	 * @param user ��Ҫ�޸ĵ��û�
	 */
	void update(AuctionUser user);

	/**
	 * ɾ���û�
	 * @param id ��Ҫɾ�����û�id
	 */  
	void delete(Integer id);

	/**
	 * ɾ���û�
	 * @param user ��Ҫɾ�����û�
	 */
	void delete(AuctionUser user);

	/**
	 * ��ѯȫ���û�
 	 * @return ���ȫ���û�
	 */
	List<AuctionUser> findAll();

	/**
	 * �����û�������������û�
	 * @param username ��ѯ������û���
	 * @param pass ��ѯ���������
	 * @return ָ���û����������Ӧ���û�
	 */
	AuctionUser findUserByNameAndPass(String username , String pass);

	boolean isExctUser(String username);
	
	AuctionUser getUserByName(String username);
}