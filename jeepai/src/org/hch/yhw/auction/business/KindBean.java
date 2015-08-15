package org.hch.yhw.auction.business;



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
public class KindBean
{
	private int id;
	private String kindName;
	private String kindDesc;
    private String bigKind;
	//无参数的构造器
	public KindBean()
	{
	}
	//初始化全部属性的构造器
	public KindBean(int id , String kindName , String kindDesc,String bigkind)
	{
		this.id = id;
		this.kindName = kindName;
		this.kindDesc = kindDesc;
		this.bigKind=bigkind;
	}

	//id属性的setter和getter方法
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return this.id;
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

	public String getBigKind() {
		return bigKind;
	}
	public void setBigKind(String bigKind) {
		this.bigKind = bigKind;
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
}