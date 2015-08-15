package org.hch.yhw.auction.action;

import java.util.Collection;
import java.util.List;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.model.*;
import org.hch.yhw.auction.common.*;
public class viewJingJiaAction extends BaseAction{
	private int id;
	private String kindName;
	
	private PagerService pagerService;
	private Pager pager;
	protected String currentPage;
	protected String pagerMethod;
	protected String totalRows;
	protected List availableItems;
	private String actionnameString;

	
	
	
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
	public String getActionnameString() {
		return actionnameString;
	}
	public void setActionnameString(String actionnameString) {
		this.actionnameString = actionnameString;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	private List kinds;
	private List items; 

	public String execute()throws Exception
	{//setActionnameString("viewJingpaiItem.action.action")//setActionnameString("viewJingpaiItem.action.action?id=4")
		
		if (id <= 0)
  {
	/*  System.out.println("Id 的值Id 的值Id 的值Id 的值"+getId());
	  getAllKind();
	   getAllItem();
		*/
			 getAllKind();
		setActionnameString("userviewJingpaiItem.action");
		System.out.println("开始执行");
		int totalRow=mgr.getRowsStatePage();
		System.out.println("asd"+totalRow);
		pager=pagerService.getPager(this.getCurrentPage(), this.getPagerMethod(), totalRow);
		this.setCurrentPage(String.valueOf(pager.getCurrentPage()));
		this.setTotalRows(String.valueOf(totalRow));
		availableItems=mgr.getAllItemStatePage(pager.getPageSize(), pager.getStartRow());
	   return SUCCESS;
		
	}
	else
	{System.out.println("Id 的值Id 的值Id 的值Id 的值"+getId());
	    /* getAllKind();
		setItems(mgr.getItemsByKind(id));*/
	getAllKind();
	setActionnameString("userviewJingpaiItem.action?id="+id);
	System.out.println("开始执行");
	int totalRow=mgr.getRowsStateKindPage(id);
	System.out.println("asd"+totalRow);
	pager=pagerService.getPager(this.getCurrentPage(), this.getPagerMethod(), totalRow);
	this.setCurrentPage(String.valueOf(pager.getCurrentPage()));
	this.setTotalRows(String.valueOf(totalRow));
	availableItems=mgr.getAllItemStateKindPage(pager.getPageSize(), pager.getStartRow(), id);
		return SUCCESS;
	}
		    
	
	}
	
	public String execute2()throws Exception
	{
		if (id <= 0)
		  {
			/*  System.out.println("Id 的值Id 的值Id 的值Id 的值"+getId());
			  getAllKind();
			   getAllItem();
				*/
					 getAllKind();
				setActionnameString("adminalterItem.action");
				System.out.println("开始执行");
				int totalRow=mgr.getRowsStatePage();
				System.out.println("asd"+totalRow);
				pager=pagerService.getPager(this.getCurrentPage(), this.getPagerMethod(), totalRow);
				this.setCurrentPage(String.valueOf(pager.getCurrentPage()));
				this.setTotalRows(String.valueOf(totalRow));
				availableItems=mgr.getAllItemStatePage(pager.getPageSize(), pager.getStartRow());
			   return SUCCESS;
				
			}
			else
			{System.out.println("Id 的值Id 的值Id 的值Id 的值"+getId());
			    /* getAllKind();
				setItems(mgr.getItemsByKind(id));*/
			getAllKind();
			setActionnameString("adminalterItem.action?id="+id);
			System.out.println("开始执行");
			int totalRow=mgr.getRowsStateKindPage(id);
			System.out.println("asd"+totalRow);
			pager=pagerService.getPager(this.getCurrentPage(), this.getPagerMethod(), totalRow);
			this.setCurrentPage(String.valueOf(pager.getCurrentPage()));
			this.setTotalRows(String.valueOf(totalRow));
			availableItems=mgr.getAllItemStateKindPage(pager.getPageSize(), pager.getStartRow(), id);
				return SUCCESS;
			}
		   
	}
	
	
	
	public void getAllItem()throws Exception{setItems(mgr.getAllJingpaiItem());}
	public void getAllKind()throws Exception{setKinds(mgr.getAllKind());}


	public List getKinds() {
		return kinds;
	}
	public void setKinds(List kinds) {
		this.kinds = kinds;
	}
	public void setItems(List items)
	{
		this.items = items;
	}
	public List getItems()
	{
		 return this.items;
	}
}
