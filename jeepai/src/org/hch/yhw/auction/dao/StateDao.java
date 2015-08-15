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
public interface StateDao  
{
	/**
	 * ����id����״̬
	 * @param id ��Ҫ���ҵ�״̬id
	 */ 
	State get(Integer id);

	/**
	 * ����״̬
	 * @param state ��Ҫ���ӵ�״̬
	 */      
	void save(State state);

	/**
	 * �޸�״̬
	 * @param state ��Ҫ�޸ĵ�״̬
	 */
	void update(State state);

	/**
	 * ɾ��״̬
	 * @param id ��Ҫɾ����״̬id
	 */ 
	void delete(Integer id);

	/**
	 * ɾ��״̬
	 * @param state ��Ҫɾ����״̬
	 */
	void delete(State state);

	/**
	 * ��ѯȫ��״̬
	 * @return ���ȫ��״̬
	 */ 
	List<State> findAll();
}
