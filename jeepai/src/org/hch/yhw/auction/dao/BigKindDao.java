package org.hch.yhw.auction.dao;

import java.util.List;

import org.hch.yhw.auction.model.Bigkind;

public interface BigKindDao {

	

	/**
	 * 根据id查找大类
	 * @param id 需要查找的大类的id
	 */
	Bigkind get(Integer id);

	/**
	 * 增加大类
	 * @param kind 需要增加的大类
	 */
	void save(Bigkind bigkind);

	/**
	 * 修改大类
	 * @param kind 需要修改的大类
	 */
	void update(Bigkind bigkind);

	/**
	 * 删除大类
	 * @param id 需要删除的大类id
	 */
	void delete(Integer id);

	/**
	 * 删除大类
	 * @param kind 需要删除的大类
	 */
	void delete(Bigkind bigkind);

	/**
	 * 查询全部大类
	 * @return 获得全部大类
	 */
	List<Bigkind> findAll();
	
	
	
}
