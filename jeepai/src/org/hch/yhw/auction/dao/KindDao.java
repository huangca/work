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
public interface KindDao  
{
	/**
	 * 根据id查找子类
	 * @param id 需要查找的子类的id
	 */
	Kind get(Integer id);

	/**
	 * 增加子类
	 * @param kind 需要增加的子类
	 */
	void save(Kind kind);

	/**
	 * 修改子类
	 * @param kind 需要修改的子类
	 */
	void update(Kind kind);

	/**
	 * 删除子类
	 * @param id 需要删除的子类id
	 */
	void delete(Integer id);

	/**
	 * 删除子类
	 * @param kind 需要删除的子类
	 */
	void delete(Kind kind);

	/**
	 * 查询全部子类
	 * @return 获得全部子类
	 */
	List<Kind> findAll();
	
	/**
	 * 查询全部子类大类别标识
	 * @return 获得全部子类
	 */
	
	List<Kind> findAllByBigKindId(Integer bigkindId);
	/**
	 * 查询全部子类根据大类对象
	 * @return 获得全部子类
	 */
	List<Kind> findAllByBigKind(Bigkind bigKind);
	
}
