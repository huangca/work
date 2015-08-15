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
public class Kind
{
	//标识属性
	private Integer id;
	//种类名
	private String kindName;
	//种类描述
	private String kindDesc;
	//该种类下的所有物品
	private Bigkind bigkind;
	private Set<Item> items = new HashSet<Item>();
	private Set<YiItem> yiitems = new HashSet<YiItem>();

	//无参数的构造器
	public Kind()
	{
	}
	//初始化全部基本属性的构造器
	public Kind(Integer id , String kindName , String kindDesc)
	{
		this.id = id;
		this.kindName = kindName;
		this.kindDesc = kindDesc;
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

	public Bigkind getBigkind() {
		return bigkind;
	}
	public void setBigkind(Bigkind bigkind) {
		this.bigkind = bigkind;
	}
	//kindName属性的setter和getter方法
	public void setKindName(String kindName)
	{
		this.kindName = kindName;
	}
	public String getKindName()
	{
		return this.kindName;
	}

	//kindDesc属性的setter和getter方法
	public void setKindDesc(String kindDesc)
	{
		this.kindDesc = kindDesc;
	}
	public String getKindDesc()
	{
		return this.kindDesc;
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