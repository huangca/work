package org.hch.yhw.auction.dao;

import java.util.List;

import org.hch.yhw.auction.business.*;
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
public interface StateDao  
{
	/**
	 * 根据id查找状态
	 * @param id 需要查找的状态id
	 */ 
	State get(Integer id);

	/**
	 * 增加状态
	 * @param state 需要增加的状态
	 */      
	void save(State state);

	/**
	 * 修改状态
	 * @param state 需要修改的状态
	 */
	void update(State state);

	/**
	 * 删除状态
	 * @param id 需要删除的状态id
	 */ 
	void delete(Integer id);

	/**
	 * 删除状态
	 * @param state 需要删除的状态
	 */
	void delete(State state);

	/**
	 * 查询全部状态
	 * @return 获得全部状态
	 */ 
	List<State> findAll();
}
