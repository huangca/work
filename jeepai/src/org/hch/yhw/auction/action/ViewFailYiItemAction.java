package org.hch.yhw.auction.action;


import java.util.*;

import com.opensymphony.xwork2.ActionContext;


import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.service.AuctionManagerToYiItem;
import org.hch.yhw.auction.common.*;
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
public class ViewFailYiItemAction extends BaseAction
{
	private List yiitems;
	//private AuctionManagerToYiItem mgryiItem;
	private PagerService pagerService;
	private Pager pager;
	protected String currentPage;
	protected String pagerMethod;
	protected String totalRows;
	protected List availableItems;
	private String actionnameString;
	

	private int id;
	private List kinds;
	private int stateid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List getKinds() {
		return kinds;
	}
	public void setKinds(List kinds) {
		this.kinds = kinds;
	}
	
	
	
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	public String getActionnameString() {
		return actionnameString;
	}
	public void setActionnameString(String actionnameString) {
		this.actionnameString = actionnameString;
	}
	
	public String execute()throws Exception
	{   
		getAllKind();
		if (id <= 0)
		{
		setActionnameString("userviewFullYiItem.action");
		System.out.println("开始执行");
		int totalRow=mgryiItem.getRows();
		System.out.println("asd"+totalRow);
		pager=pagerService.getPager(this.getCurrentPage(), this.getPagerMethod(), totalRow);
		this.setCurrentPage(String.valueOf(pager.getCurrentPage()));
		this.setTotalRows(String.valueOf(totalRow));
		//availableItems=mgryiItem.getAllItemPage(pager.getPageSize(), pager.getStartRow());
		availableItems=mgryiItem.getAllItemStatePage(pager.getPageSize(), pager.getStartRow(), 4);
		System.out.println("结束执行");
		setYiitems(mgryiItem.getFullItems());
		return SUCCESS;
		}
		else {
			setActionnameString("userviewFullYiItem.action?id="+id);
			System.out.println("开始执行222222222"+id);
			int totalRow=mgryiItem.getKindRows(id);
			System.out.println("asd"+totalRow);
			pager=pagerService.getPager(this.getCurrentPage(), this.getPagerMethod(), totalRow);
			this.setCurrentPage(String.valueOf(pager.getCurrentPage()));
			this.setTotalRows(String.valueOf(totalRow));
			System.out.println("结束执行setTotalRows setCurrentPage");
			availableItems=mgryiItem.getAllItemStateKindPage(pager.getPageSize(), pager.getStartRow(), id);
			System.out.println("结束执行");
			setYiitems(mgryiItem.getFullItems());
			return SUCCESS;
		}
	}
	
	public String execute2()throws Exception
	{   
		
		if (stateid <= 0)
		{
		setActionnameString("adminalterYiItem.action");
		System.out.println("开始执行");
		int totalRow=mgryiItem.getAllRows();
		System.out.println("asd"+totalRow);
		pager=pagerService.getPager(this.getCurrentPage(), this.getPagerMethod(), totalRow);
		this.setCurrentPage(String.valueOf(pager.getCurrentPage()));
		this.setTotalRows(String.valueOf(totalRow));
	
		availableItems=mgryiItem.getAllItemPage(pager.getPageSize(), pager.getStartRow());
		System.out.println("结束执行");
		//setYiitems(mgryiItem.getFullItems());
		return SUCCESS;
		}
		else {
			setActionnameString("adminalterYiItem.action?stateid="+stateid);
			System.out.println("开始执行222222222"+stateid);
			int totalRow=mgryiItem.getStateRoes(stateid);
			System.out.println("asd"+totalRow);
			pager=pagerService.getPager(this.getCurrentPage(), this.getPagerMethod(), totalRow);
			this.setCurrentPage(String.valueOf(pager.getCurrentPage()));
			this.setTotalRows(String.valueOf(totalRow));
			System.out.println("结束执行setTotalRows setCurrentPage");
			availableItems=mgryiItem.getAllItemStatePage(pager.getPageSize(), pager.getStartRow(), stateid);
			System.out.println("结束执行");
			//setYiitems(mgryiItem.getFullItems());
			return SUCCESS;
		}
	}
	
	
	
	public void getAllKind()throws Exception{setKinds(mgr.getAllKind());}

	
	
	public PagerService getPagerService() {
		return pagerService;
	}
	public void setPagerService(PagerService pagerService) {
		this.pagerService = pagerService;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public String getPagerMethod() {
		return pagerMethod;
	}
	public void setPagerMethod(String pagerMethod) {
		this.pagerMethod = pagerMethod;
	}
	public String getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(String totalRows) {
		this.totalRows = totalRows;
	}

	public List getAvailableItems() {
		return availableItems;
	}
	public void setAvailableItems(List availableItems) {
		this.availableItems = availableItems;
	}
	public List getYiitems() {
		return yiitems;
	}
	public void setYiitems(List yiitems) {
		this.yiitems = yiitems;
	}
	/*public void setMgryiItem(AuctionManagerToYiItem mgryiItem) {
		this.mgryiItem = mgryiItem;
	}
*/

}
