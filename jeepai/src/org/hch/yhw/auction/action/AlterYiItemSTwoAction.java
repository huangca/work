package org.hch.yhw.auction.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

import com.opensymphony.xwork2.ActionContext;

import org.apache.struts2.ServletActionContext;
import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.Bigkind;
import org.hch.yhw.auction.model.Item;
import org.hch.yhw.auction.model.Kind;
import org.hch.yhw.auction.model.State;
import org.hch.yhw.auction.model.YiItem;
import org.hch.yhw.auction.service.AuctionManager;
public class AlterYiItemSTwoAction extends BaseAction {
	private String name;//"��Ʒ��"
	private String desc;//��Ʒ����
	private String remark;//��Ʒ��ע
	private int initnumber;
	private double initPrice;
	private int kind;//��Ʒ����
	private int bigkind;
   


	private int state;
	/*�ϴ�ͼƬ�����￪ʼ*/
	
	// ��װ�ϴ��ļ��������
	private File upload;
	// ��װ�ϴ��ļ�����
	private String uploadContentType;
	// ��װ�ϴ��ļ���
	private String uploadFileName;
	private String savePath;
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
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	
	


	public int getInitnumber() {
		return initnumber;
	}
	public void setInitnumber(int initnumber) {
		this.initnumber = initnumber;
	}
	public double getInitPrice() {
		return initPrice;
	}
	public void setInitPrice(double initPrice) {
		this.initPrice = initPrice;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	 public int getBigkind() {
			return bigkind;
		}
		public void setBigkind(int bigkind) {
			this.bigkind = bigkind;
		}
	
	

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
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
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

	
	public String execute() throws Exception
	{
	
		
		try{
			System.out.println("ACTION��ʼ");
			//System.out.println(getUploadFileName().trim().length());
			System.out.println("���"+upload);
		Map session = ActionContext.getContext().getSession();
	
		if(//getUploadFileName().trim().length()>0
			upload!=null	)
		{
			System.out.println("�ϴ�ͼƬ��ʼ");
			shangchuaungtupian();
			System.out.println("�ϴ�ͼƬ����");
			Integer itemId=(Integer)session.get("YiItemId");
			//Item item=mgr.getItemById(itemId);
			YiItem yiItem=mgryiItem.getYiItemById(itemId);
			yiItem.setItemName(name);
			yiItem.setItemDesc(desc);
			yiItem.setItemRemark(remark);
			yiItem.setInitnumber(initnumber);
			yiItem.setInitPrice(initPrice);
			
			Bigkind bigkind2=mgr.findBigKindByBigId(bigkind);
			yiItem.setBigkind(bigkind2);
			Kind kind2=mgr.findKindByIKind(kind);
			yiItem.setKind(kind2);
			State state2=mgryiItem.findStateByStateId(state);
			yiItem.setItemState(state2);
			yiItem.setPicname(getUploadFileName());
			mgryiItem.updateYiItem(yiItem);
			return SUCCESS;
		}
		else {
			System.out.println("��ͼ");
			Integer itemId=(Integer)session.get("YiItemId");
			//Item item=mgr.getItemById(itemId);
			YiItem yiItem=mgryiItem.getYiItemById(itemId);
			yiItem.setItemName(name);
			yiItem.setItemDesc(desc);
			yiItem.setItemRemark(remark);
			yiItem.setInitnumber(initnumber);
			yiItem.setInitPrice(initPrice);
			Bigkind bigkind2=mgr.findBigKindByBigId(bigkind);
			yiItem.setBigkind(bigkind2);
			Kind kind2=mgr.findKindByIKind(kind);
			yiItem.setKind(kind2);
			State state2=mgryiItem.findStateByStateId(state);
			yiItem.setItemState(state2);
		
			mgryiItem.updateYiItem(yiItem);
			return SUCCESS;
		}
		}catch(Exception e){e.printStackTrace();return ERROR;}
	}
	

}