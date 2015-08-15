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
public class Kind
{
	//��ʶ����
	private Integer id;
	//������
	private String kindName;
	//��������
	private String kindDesc;
	//�������µ�������Ʒ
	private Bigkind bigkind;
	private Set<Item> items = new HashSet<Item>();
	private Set<YiItem> yiitems = new HashSet<YiItem>();

	//�޲����Ĺ�����
	public Kind()
	{
	}
	//��ʼ��ȫ���������ԵĹ�����
	public Kind(Integer id , String kindName , String kindDesc)
	{
		this.id = id;
		this.kindName = kindName;
		this.kindDesc = kindDesc;
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

	public Bigkind getBigkind() {
		return bigkind;
	}
	public void setBigkind(Bigkind bigkind) {
		this.bigkind = bigkind;
	}
	//kindName���Ե�setter��getter����
	public void setKindName(String kindName)
	{
		this.kindName = kindName;
	}
	public String getKindName()
	{
		return this.kindName;
	}

	//kindDesc���Ե�setter��getter����
	public void setKindDesc(String kindDesc)
	{
		this.kindDesc = kindDesc;
	}
	public String getKindDesc()
	{
		return this.kindDesc;
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