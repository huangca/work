package org.hch.yhw.auction.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String username;
	private String password;
	private Set<Item> itemsByOwner = new HashSet(0);
	private Set yiitems = new HashSet(0);

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public Set<Item> getItemsByOwner() {
		return itemsByOwner;
	}

	public void setItemsByOwner(Set<Item> itemsByOwner) {
		this.itemsByOwner = itemsByOwner;
	}

	public Set getYiitems() {
		return this.yiitems;
	}

	public void setYiitems(Set yiitems) {
		this.yiitems = yiitems;
	}

}