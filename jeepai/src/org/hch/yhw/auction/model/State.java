package org.hch.yhw.auction.model;

import java.util.*;
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
public class State
{
	//��ʶ����
	private Integer id;
	//��Ʒ��״̬��
	private String stateName;
	//��״̬�µ�������Ʒ
	private Set<Item> items = new HashSet<Item>();

	private Set<YiItem> yiitems = new HashSet<YiItem>();

	//�޲����Ĺ�����
	public State()
	{
	}
	//��ʼ��ȫ���������ԵĹ�����
	public State(Integer id , String stateName)
	{
		this.id = id;
		this.stateName = stateName;
	}

	//id���Ե�setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	//stateName���Ե�setter��getter����
	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}
	public String getStateName()
	{
		return this.stateName;
	}

	//items���Ե�setter��getter����
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