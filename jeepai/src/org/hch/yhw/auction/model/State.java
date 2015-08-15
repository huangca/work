package org.hch.yhw.auction.model;

import java.util.*;
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
public class State
{
	//标识属性
	private Integer id;
	//物品的状态名
	private String stateName;
	//该状态下的所有物品
	private Set<Item> items = new HashSet<Item>();

	private Set<YiItem> yiitems = new HashSet<YiItem>();

	//无参数的构造器
	public State()
	{
	}
	//初始化全部基本属性的构造器
	public State(Integer id , String stateName)
	{
		this.id = id;
		this.stateName = stateName;
	}

	//id属性的setter和getter方法
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	//stateName属性的setter和getter方法
	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}
	public String getStateName()
	{
		return this.stateName;
	}

	//items属性的setter和getter方法
	public void setItems(Set<Item> items)
	{
		this.items = items;
	}
	public Set<Item> getItems()
	{
		return this.items;
	}
	public Set<YiItem> getYiitems() {
		return yiitems;
	}
	public void setYiitems(Set<YiItem> yiitems) {
		this.yiitems = yiitems;
	}
	
	
}