package org.hch.yhw.auction.business;



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
public class KindBean
{
	private int id;
	private String kindName;
	private String kindDesc;
    private String bigKind;
	//�޲����Ĺ�����
	public KindBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public KindBean(int id , String kindName , String kindDesc,String bigkind)
	{
		this.id = id;
		this.kindName = kindName;
		this.kindDesc = kindDesc;
		this.bigKind=bigkind;
	}

	//id���Ե�setter��getter����
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return this.id;
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

	public String getBigKind() {
		return bigKind;
	}
	public void setBigKind(String bigKind) {
		this.bigKind = bigKind;
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
}