package org.hch.yhw.auction.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Bigkind entity. @author MyEclipse Persistence Tools
 */

public class Bigkind implements java.io.Serializable {

	// Fields

	private Integer bigkindId;
	private String bigkindname;
	private String kinddesc;
	private Set kinds = new HashSet();
	private Set items = new HashSet();
	private Set yiitems = new HashSet();

	// Constructors

	/** default constructor */
	public Bigkind() {
	}

	/** minimal constructor */
	public Bigkind(String bigkindname) {
		this.bigkindname = bigkindname;
	}

	/** full constructor */
	public Bigkind(String bigkindname, String kinddesc, Set kinds, Set items,
			Set yiitems) {
		this.bigkindname = bigkindname;
		this.kinddesc = kinddesc;
		this.kinds = kinds;
		this.items = items;
		this.yiitems = yiitems;
	}

	// Property accessors

	public Integer getBigkindId() {
		return this.bigkindId;
	}

	public void setBigkindId(Integer bigkindId) {
		this.bigkindId = bigkindId;
	}

	public String getBigkindname() {
		return this.bigkindname;
	}

	public void setBigkindname(String bigkindname) {
		this.bigkindname = bigkindname;
	}

	public String getKinddesc() {
		return this.kinddesc;
	}

	public void setKinddesc(String kinddesc) {
		this.kinddesc = kinddesc;
	}

	public Set getKinds() {
		return this.kinds;
	}

	public void setKinds(Set kinds) {
		this.kinds = kinds;
	}

	public Set getItems() {
		return this.items;
	}

	public void setItems(Set items) {
		this.items = items;
	}

	public Set getYiitems() {
		return this.yiitems;
	}

	public void setYiitems(Set yiitems) {
		this.yiitems = yiitems;
	}

}