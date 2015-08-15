package org.hch.yhw.auction.service;

import java.util.List;

import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.dao.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.State;
import org.hch.yhw.auction.model.YiItem;
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
/**
 * ��һ�ڼ���Ʒ���д���Ľӿ�
 * */
public interface AuctionManagerToYiItem {

	  /**
	  * ���µķ����Ƕ�һ�ڼ���Ʒ���д����
	  * */
	
	/**
	 * ���ݹ����߲�ѯ��Ʒ
	 * @param winerId �����ߵ�ID
	 * @return �����߹����ȫ����Ʒ
	 */
	/*List getYiItemByWiner(Integer winerId) 
		throws AuctionException;
*/
	/**
	 * ��ѯһ�ڼ۵�ȫ����Ʒ
	 * @return ȫ��һ�ڼ���Ʒ
	 */
	List getFullItems()throws AuctionException;
	/**
	 * ��ѯһ�ڼ۵��ϼܼ���Ʒ
	 * @return ȫ��һ�ڼ���Ʒ
	 */
	List getOnlineItems()throws AuctionException;
	/**
	 * ��ѯһ�ڼ۵�ȫ���¼���Ʒ
	 * @return ȫ��һ�ڼ���Ʒ
	 */
	List getDownlineItems()throws AuctionException;

	/**
	 * �����û�����������֤��¼�Ƿ�ɹ�
	 * @param username ��¼���û���
 	 * @param pass ��¼������
	 * @return ��¼�ɹ������û�ID�����򷵻�-1
	 */
	/*int validLogin(String username , String pass)
		throws AuctionException;*/

	/**
	 * �����û�����Ŀǰ�����ϼ��е�ȫ����Ʒ
	 * @param userId �����ߵ�ID
	 * @return �������ϼ��е�ȫ����Ʒ��
	 */
	List getYiItemsByOwner(Integer userId)
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
		double initPrice , int avail , int kind , Integer userId,int bigkindid,int number) 
		throws AuctionException;

	/**
	 * �������
	 * @param name ��������
	 * @param desc ��������
	 * @return �������������
	 */ 
	//int addKind(String name , String desc) throws AuctionException;

	/**
	 * ���ݲ�Ʒ���࣬��ȡ�����ϼ��е�ȫ����Ʒ
	 * @param kindId ����id;
	 * @return �����ȫ����Ʒ
	 */
	List getYiItemsByKind(int kindId) throws AuctionException;

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
	YiItemBean getYiItem(int itemId) throws AuctionException;

	/**
	 * �����µľ��ۣ����Ծ����û����ʼ�֪ͨ
	 * @param itemId ��Ʒid;
	 * @param bidPrice ���ۼ۸�
	 * @param userId �����û���ID
	 * @return �����������ۼ�¼��ID
	 */
	

	/**
	 * ����ʱ�����޸���Ʒ��Ӯȡ��
	 */
	void updateWiner(Integer yitemid,Integer wid)throws AuctionException;
	
	/**
	 * ����ʱ������ȡ������Ʒ
	 */
      
	 List<YiItem> getNewSaleYiItems()throws AuctionException;
	
	 List getNewSaleYiItemsToList()throws AuctionException;
     /**
      * �Թ��ﳵ���в���
      * */
      
      /**����һ
       * ���ﳵ���ĳ��Ʒ��������һ���б�
       * */ 
      List<CartBean> putCartBeans(int number,Integer yitemid,List<CartBean> fromList)throws Exception;
      /**������
       * ���㹺�ﳵ���ڵ��ܼ�Ǯ
       * */   
      double summomey(List<CartBean> fromList)throws Exception;
      /**������
       * ��չ��ﳵ�е�ĳ����Ʒ
       * */  
      List<CartBean> removeCartBeanById(Integer id,List<CartBean> fromList)throws Exception;

      //��̨����������ID����һ�ڼ���Ʒ��model
      YiItem getYiItemById(Integer id)throws Exception;
    //��̨����,��������state
      List getAllState()throws Exception;
    //��̨����������state ID����state model
      State findStateByStateId(int id) throws Exception;
      //��̨����������һ�ڼ���Ʒ
      void updateYiItem(YiItem yiItem)throws Exception;

      //ǰ̨��ҳ����
  	int getRows();
  	 //ǰ̨��ҳ����
  	int getKindRows(int kindId);
  	
    
  //��ҳ����
      List getAllItemPage(int pageSize,int startRow);
    
    //ǰ̨��ҳ����
      List getAllItemStatePage(int pageSize,int startRow,int stateId);
      //ǰ̨��ҳ����
      List getAllItemStateKindPage(int pageSize,int startRow,int kindId);
      
      //��̨��ҳ����
      int getAllRows();
      //��̨��ҳ����
      int getStateRoes(int stateid);

}
