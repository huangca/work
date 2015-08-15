package org.hch.yhw.auction.service;
import java.util.List;

import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.Orderdetail;
import org.hch.yhw.auction.model.Orderyi;
public interface AuctionManagerToOrder {
	/**
	 * ���ݻ�ԱID��ѯ�䶩��
	 * @param userid 
	 * @return ��Ա����LIST
	 */
	List<Orderyi>  getOrderyiByAuctionUserId(Integer userid)throws AuctionException;
	/**
	 * ����Bean
	 * @param orderBean 
	 * @return ��Ա������
	 */
	int addOrderyiOnOrderBean(OrderBean orderBean)throws AuctionException;
	/** 
	 * ��Աɾ������
	 * */
	void deleteOrderyiByOid(Integer orderId)throws AuctionException;
	/** 
	 * �޸Ķ���
	 * ��������޸��ܼ�Ǯ���Ƿ����˵�ҵ��
	 * */
	void updateOrderyi(Orderyi orderyi)throws AuctionException;
	
	
	void updateOrderdetail(Orderdetail orderdetail)throws AuctionException;
	/** 
	 * ��Ӷ���ͷ
	 * */
	int addOrderyiOnOrderyi(Integer userid,double summoney,String realname,String address,String telphone
			,String postcode,String model,String message,int cartSize)throws AuctionException;
	//int addOrderyiOnOrderyi(OrderBean orderBean);
	/**
	 * Ϊ��������ϸ����
	 * */
	/**
	 * ��Ӷ�������ϸ
	 */
	int addOrderdetail(Integer orderid,Integer yiitemid,double xiaoji,int number)throws AuctionException;
    /**
    * ɾ��ĳһ��ϸ��¼����ĳ��Ʒ��Դ���㣬ɾ��ĳ��ȣ������Ǯ
    * ����ʱ���ϵ����������
    * */
	void deleteOrderdetailByid(Integer id)throws AuctionException;
	
	void addOrderdetailOnOrderBean(OrderBean orderBean)throws AuctionException;
	Orderyi getOrderyiByOrderyiId(Integer orderid)throws AuctionException;
	/**
	 * ����ĳһ����ID��ѯ����һ��������
	 * */
	MemberOrderBean findWholeOrderByOrderyiId(Integer id)throws AuctionException;
	/**�����ύ�Ķ������־õ����ݿ�*/
	int addOrderyiAtOneTime(OrderBean orderBean)throws AuctionException;

	//��̨�������������ж���
	List<Orderyi>  getAllOrderyi()throws AuctionException;
	//��̨����������SIGN���ض���
	List<Orderyi>  getOrderyiBySign(boolean flag)throws AuctionException;
	//��̨����,����Ա�޸Ķ���
	void updateO(Integer orderid,int number);
	void deleteO(Integer orderid);
	//�����������ֶλ�ȡ����BEAN
	MemberOrderBean findOrderByOrderyiid(String orderyiid);
	//�����������ֶλ�ȡ����model
	Orderyi getOrderByOrderyiid(String orderyiid);
	//
	void deleteOrderyiByModel(String orderyiid);
}
