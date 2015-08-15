package org.hch.yhw.auction.business;
import java.io.Serializable;
import java.util.Date;

import org.hch.yhw.auction.model.Admin;
import org.hch.yhw.auction.model.Kind;
import org.hch.yhw.auction.model.State;
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
public class YiItemBean {
	private Integer id;//
	private String name;//
	private String desc;//
	private String remark;//
	private String kind;//
	private String owner;//Admin owner;
	//private String winer;
	private String state;//State itemState
	private double initPrice;//double initPrice
	private int initnumber;
	private Date addTime;//Date addtime
	private Date endTime;// endtime
	private String picname;//String picname
	private String bigkind;//
	private int bigkid;//新增大类ID
	private int kid;//新增小类ID
	
	
	
	
	
	
	

	//无参数的构造器
	public YiItemBean() {
		
	}
	
	//初始化全部属性的构造器
	public YiItemBean(Integer id, String name, String desc, String remark,
			String kind, String owner,String state,int initnumber,
			double initPrice, Date addTime, Date endTime, String picname,int bigkid,int kid) {
		
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.remark = remark;
		this.kind = kind;
		this.owner = owner;
		this.initnumber = initnumber;
		this.state = state;
		this.initPrice = initPrice;
		this.addTime = addTime;
		this.endTime = endTime;
		this.picname = picname;
		this.bigkid=bigkid;
		this.kid=kid;
	}
	
	

	public int getBigkid() {
		return bigkid;
	}

	public int getKid() {
		return kid;
	}

	public void setBigkid(int bigkid) {
		this.bigkid = bigkid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}


	public String getState() {
		return state;
	}

	public int getInitnumber() {
		return initnumber;
	}

	public void setInitnumber(int initnumber) {
		this.initnumber = initnumber;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getInitPrice() {
		return initPrice;
	}

	public void setInitPrice(double initPrice) {
		this.initPrice = initPrice;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public String getBigkind() {
		return bigkind;
	}

	public void setBigkind(String bigkind) {
		this.bigkind = bigkind;
	}

	
	
}
