package org.hch.yhw.auction.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import com.opensymphony.xwork2.ActionContext;

import org.apache.struts2.ServletActionContext;
import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.service.AuctionManager;

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
public class AddItemAction extends BaseAction
{
	private String name;//"物品名"
	private String desc;//物品描述
	private String remark;//物品备注
	private double initPrice;//起拍价格
	private int avail;//有效时间
	private int kind;//物品种类
	private String vercode;
	private int bigkind;
	private int zengfu;
	
	
	/*上传图片从这里开始*/
	
	// 封装上传文件域的属性
	private File upload;
	// 封装上传文件类型
	private String uploadContentType;
	// 封装上传文件名
	private String uploadFileName;
	private String savePath;
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() throws Exception {
		return ServletActionContext.getRequest().getRealPath(savePath);
		//return ServletActionContext.getRequest().getPathInfo()

	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	
	public void shangchuaungtupian() throws Exception{
		String fileName = getSavePath() + "\\" + getUploadFileName();
		FileOutputStream fos = new FileOutputStream(fileName);
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] b = new byte[1024];
		int len = 0;
		while ((len = fis.read(b)) > 0) {
			fos.write(b, 0, len);
		}
	}
	
	
	
	
	
	
	
	
	public int getBigkind() {
		return bigkind;
	}

	public void setBigkind(int bigkind) {
		this.bigkind = bigkind;
	}

	//处理用户请求的execute方法
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		String ver2 = (String)session.get("rand");
		//强制系统刚生成的随机验证码失效
		session.put("rand" , null);
		Integer userId = (Integer)session.get("adminId");
		//如果用户输入的验证码与系统随机产生的验证码相同
		if (vercode.equalsIgnoreCase(ver2))
		{
			avail=	doAvail(avail);
			//添加物品
			/*
			 * public int addItem(String name , String desc , String remark ,
		double initPrice , int avail , int kind , Integer userId)
			 * */
			//System.out.println("上传图片开始");
			shangchuaungtupian();
			
			//if(mgr==null)System.out.println("mgr is null not Object");
	//缺少一个参数大类别ID	
			//float zengfu1=zengfu/100;
			mgr.addItem(name , desc , remark ,getUploadFileName(), initPrice ,avail , kind, userId,bigkind,zengfu);
			//将收集用户输入信息的表单域清空
			//mgr.addItem("abds" , "asdfa" , "asdfasdf" , 500 ,7 , 1, new Integer(1));
		 System.out.println("插入拍卖信息！\n");
			return SUCCESS;
		}
		else
		{
			addActionError("验证码不匹配,请重新输入");
			return INPUT;
		}
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		 return this.name;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getDesc()
	{
		 return this.desc;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		 return this.remark;
	}

	public void setInitPrice(double initPrice)
	{
		this.initPrice = initPrice;
	}
	public double getInitPrice()
	{
		 return this.initPrice;
	}

	public void setAvail(int avail)
	{
		this.avail = avail;
	}
	public int getAvail()
	{
		 return this.avail;
	}

	public void setKind(int kind)
	{
		this.kind = kind;
	}
	public int getKind()
	{
		 return this.kind;
	}

	public int getZengfu() {
		return zengfu;
	}

	public void setZengfu(int zengfu) {
		this.zengfu = zengfu;
	}

	public void setVercode(String vercode)
	{
		this.vercode = vercode;
	}
	public String getVercode()
	{
		 return this.vercode;
	}
	public int doAvail(int avail){
		//根据用户选择有效时间选项，指定实际的有效时间
		switch(avail)
		{
		case 1 :
			avail = 1;
			break;
		case 2 :
			avail = 2;
			break;
		case 3 :
			avail = 3;
			break;
		case 4 :
			avail = 4;
			break;
		case 5 :
			avail = 5;
			break;

		case 6 :
				avail = 7;
				break;
			case 7 :
				avail = 30;
				break;
			case 8 :
				avail = 365;
				break;
		default:avail = 0 ;break;
		}
		return avail;
	}
}