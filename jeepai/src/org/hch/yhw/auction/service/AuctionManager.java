package org.hch.yhw.auction.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.dao.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.Bigkind;
import org.hch.yhw.auction.model.Item;
import org.hch.yhw.auction.model.Kind;

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
public interface AuctionManager  
{
	/**
	 * ����Ӯȡ�߲�ѯ��Ʒ
	 * @param winerId Ӯȡ�ߵ�ID
	 * @return Ӯȡ�߻�õ�ȫ����Ʒ
	 */
	List getItemByWiner(Integer winerId) 
		throws AuctionException;

	/**
	 * ��ѯ���ĵ�ȫ����Ʒ
	 * @return ȫ��������Ʒ
	 */
	List getFailItems()throws AuctionException;

	/**
	 * �����û�����������֤��¼�Ƿ�ɹ�
	 * @param username ��¼���û���
 	 * @param pass ��¼������
	 * @return ��¼�ɹ������û�ID�����򷵻�-1
	 */
	int validLogin(String username , String pass)
		throws AuctionException;

	/**
	 * ��ѯ�û���ȫ������
	 * @param userId �����û���ID
	 * @return �û���ȫ������
	 */
	List getBidByUser(Integer userId)
		throws AuctionException;

	/**
	 * �����û�����Ŀǰ���������е�ȫ����Ʒ
	 * @param userId �����ߵ�ID
	 * @return ���ڵ�ǰ�û��ġ����������е�ȫ����Ʒ��
	 */
	List getItemsByOwner(Integer userId)
		throws AuctionException;

	/**
	 * ��ѯȫ������
	 * @return ϵͳ��ȫ��ȫ������
	 */
	List getAllKind() throws AuctionException; 

	/**
	* �����Ʒ
	* @param name ��Ʒ����
	* @param desc ��Ʒ����
	* @param remark ��Ʒ��ע
	* @param avail ��Ч����
	* @param kind ��Ʒ����
	* @param userId ����ߵ�ID
	* @return ������Ʒ������
	*/ 
	int addItem(String name , String desc , String remark , String picname,
		double initPrice , int avail , int kind , Integer userId,int bigkindid,int zengfu) 
		throws AuctionException;

	/**
	 * �������
	 * @param name ��������
	 * @param desc ��������
	 * @return �������������
	 */ 
	int addKind(String name , String desc,int bigkindid) throws AuctionException;

	/**
	 * ���ݲ�Ʒ���࣬��ȡ���������е�ȫ����Ʒ
	 * @param kindId ����id;
	 * @return �����ȫ����Ʒ
	 */
	List getItemsByKind(int kindId) throws AuctionException;

	/**
	 * ��������id��ȡ������
	 * @param kindId ����id;
	 * @return �����������
	 */
	String getKind(int kindId) throws AuctionException;

	/**
	 * ������Ʒid����ȡ��Ʒ
	 * @param itemId ��Ʒid;
	 * @return ָ��id��Ӧ����Ʒ
	 */
	ItemBean getItem(int itemId) throws AuctionException;

	/**
	 * �����µľ��ۣ����Ծ����û����ʼ�֪ͨ
	 * @param itemId ��Ʒid;
	 * @param bidPrice ���ۼ۸�
	 * @param userId �����û���ID
	 * @return �����������ۼ�¼��ID
	 */
	int addBid(int itemId , double bidPrice ,Integer userId)
		throws AuctionException;

	/**
	 * ����ʱ�����޸���Ʒ��Ӯȡ��
	 */
	void updateWiner()throws AuctionException;
	List getAllJingpaiItem()throws AuctionException;
	/**
	 * �������µ�������Ʒ
	 */
	List  findItemByStateOrderByDate()throws AuctionException;
	//ע�����û�
	int addUser(String username,String password,String email,String realname,String postcode,String address
	,String telphone,int questionid,String answer)throws AuctionException;
	//�޸�����
	boolean checkPw(String username,String opassword,String npassword) throws AuctionException;
	//�ѳ�ָ���û���һ�ڼ۶���
	List getOrder(Integer userId)throws AuctionException;
	
	
	/**�ҳ����д���**/
	List getAllBigKind() throws AuctionException;

	
	/**�ҳ����д���**/
	Bigkind getBigKindById(Integer id) throws AuctionException;

	/**�ҳ�����������ݴ���**/

	List getAllkindByBigKind(Bigkind bigkind) throws AuctionException;


    List filldoubleselect()throws AuctionException;
	/**
	 * �������
	 * @param name ��������
	 * @param desc ��������
	 * @return �������������
	 */ 
	int addBigKind(String name , String desc) throws AuctionException;

	//��̨����,����Ա��½
	int adminLogin(String username , String password)throws AuctionException;
	//��̨��������������ID��������
	Kind findKindByIKind(int id)throws AuctionException;
//��̨����������������Ϣ
	void updateKind(Kind kind)throws AuctionException;
	//��̨����������ID������ƷMODEL
	Item getItemById(int itemId)throws AuctionException;
	//��̨����,��������Ʒ
	void updateItem(Item item)throws AuctionException;
	 //��Ӵ���󣬺�̨����2������bigkind ID����bigkind��
	Bigkind findBigKindByBigId(int id) throws AuctionException;
	//��Ӵ���󣬺�̨����2����������bigkind��
	List findAllBigKind();
	//��Ӵ���󣬺�̨����2������bigkind��
	void updateBigKind(Bigkind bigkind);
	
	//ǰ̨������Ʒ��ҳ����
	int getRowsStatePage();
    //ǰ̨������Ʒ��ҳ����
	int getRowsStateKindPage(int kindId);
	//ǰ̨������Ʒ��ҳ����
	List getAllItemStatePage(int pageSize,int startRow);
	//ǰ̨������Ʒ��ҳ����
	List getAllItemStateKindPage(int pageSize,int startRow,int kindId);
	
	Map getBigKindsForMap();
	List getAllBigKindNotOther() throws AuctionException;
	//�鿴������Ʒ
	List<OrderiBean> getOrderiByMember(Integer winer)throws AuctionException;
	//ɾ��ӮȡƷ��  
	void deleteOrderi(String orderid);
	//����Ӯȡ�߶���״̬
	void updateOrderiSign(String orderid);
	void updateOrderiCinSign(OrderiBean orderiBean);
	void updateOrderiFukuanSign(String orderid);
	//�������е�Ӯȡ�߶���
	List<OrderiBean> findAllOrderis();
	OrderiBean getOrderiByOrderId(String orderid);

}