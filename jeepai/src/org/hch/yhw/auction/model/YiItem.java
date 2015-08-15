package org.hch.yhw.auction.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
public class YiItem {

	//��ʶ����
	private Integer id;
	//��ƷRemark
	private String itemRemark;
	//��Ʒ����
	private String itemName;
	//��Ʒ����
	private String itemDesc;
	//��Ʒ���ʱ��
	private Date addtime;
	//����
	private Bigkind bigkind;
	//��Ʒ����ʱ��
	private Date endtime;
	//��Ʒ��һ�ڼ�
	private double initPrice;
	//����Ʒ��������

	//����Ʒ����������
	private Kind kind;
	//ͼƬ����
	private String picname;
	
	//����Ʒ�Ĺ�����
	private AuctionUser winer;
	//����Ʒ������״̬---�ϼܡ������¼ܡ���һ�ڼ�
	private State itemState;

	
	private Admin owner;

	private Integer initnumber;



	private Set orderdetails = new HashSet(0);
	
	
	// Constructors

	/** default constructor */
	public YiItem() {
	}

	/** full constructor */
	public YiItem( String itemName,
			String itemDesc, String itemRemark, Integer initnumber,
			String picname, double initPrice, Date addtime, Date endtime
			) {

	
	
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemRemark = itemRemark;
		this.initnumber = initnumber;
		this.picname = picname;
		this.initPrice = initPrice;
		this.addtime = addtime;
		this.endtime = endtime;
	
	}
	public Admin getOwner() {
		return owner;
	}

	public void setOwner(Admin owner) {
		this.owner = owner;
	}

	public Integer getInitnumber() {
		return initnumber;
	}

	public Bigkind getBigkind() {
		return bigkind;
	}

	public void setBigkind(Bigkind bigkind) {
		this.bigkind = bigkind;
	}

	public void setInitnumber(Integer initnumber) {
		this.initnumber = initnumber;
	}

	public Set getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(Set orderdetails) {
		this.orderdetails = orderdetails;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemRemark() {
		return itemRemark;
	}
	public void setItemRemark(String itemRemark) {
		this.itemRemark = itemRemark;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public double getInitPrice() {
		return initPrice;
	}
	public void setInitPrice(double initPrice) {
		this.initPrice = initPrice;
	}

	public Kind getKind() {
		return kind;
	}
	public void setKind(Kind kind) {
		this.kind = kind;
	}
	public String getPicname() {
		return picname;
	}
	public void setPicname(String picname) {
		this.picname = picname;
	}
	public AuctionUser getWiner() {
		return winer;
	}
	public void setWiner(AuctionUser winer) {
		this.winer = winer;
	}
	public State getItemState() {
		return itemState;
	}
	public void setItemState(State itemState) {
		this.itemState = itemState;
	}

	
}
