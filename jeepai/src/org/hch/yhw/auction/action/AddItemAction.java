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
 * <br/>��ַ: <a href="http://www.sise.com.cn">�����Ч</a> 
 * <br/>Copyright (C), 2010-201?, �Ʋӻ�   ���ΰ
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:20100301-20100401
 * @author  hch0612@scse.com.cn
 * @version  1.0
 */
public class AddItemAction extends BaseAction
{
	private String name;//"��Ʒ��"
	private String desc;//��Ʒ����
	private String remark;//��Ʒ��ע
	private double initPrice;//���ļ۸�
	private int avail;//��Чʱ��
	private int kind;//��Ʒ����
	private String vercode;
	private int bigkind;
	private int zengfu;
	
	
	/*�ϴ�ͼƬ�����￪ʼ*/
	
	// ��װ�ϴ��ļ��������
	private File upload;
	// ��װ�ϴ��ļ�����
	private String uploadContentType;
	// ��װ�ϴ��ļ���
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

	//�����û������execute����
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		String ver2 = (String)session.get("rand");
		//ǿ��ϵͳ�����ɵ������֤��ʧЧ
		session.put("rand" , null);
		Integer userId = (Integer)session.get("adminId");
		//����û��������֤����ϵͳ�����������֤����ͬ
		if (vercode.equalsIgnoreCase(ver2))
		{
			avail=	doAvail(avail);
			//�����Ʒ
			/*
			 * public int addItem(String name , String desc , String remark ,
		double initPrice , int avail , int kind , Integer userId)
			 * */
			//System.out.println("�ϴ�ͼƬ��ʼ");
			shangchuaungtupian();
			
			//if(mgr==null)System.out.println("mgr is null not Object");
	//ȱ��һ�����������ID	
			//float zengfu1=zengfu/100;
			mgr.addItem(name , desc , remark ,getUploadFileName(), initPrice ,avail , kind, userId,bigkind,zengfu);
			//���ռ��û�������Ϣ�ı������
			//mgr.addItem("abds" , "asdfa" , "asdfasdf" , 500 ,7 , 1, new Integer(1));
		 System.out.println("����������Ϣ��\n");
			return SUCCESS;
		}
		else
		{
			addActionError("��֤�벻ƥ��,����������");
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
		//�����û�ѡ����Чʱ��ѡ�ָ��ʵ�ʵ���Чʱ��
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