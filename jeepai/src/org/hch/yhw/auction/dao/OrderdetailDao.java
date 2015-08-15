package org.hch.yhw.auction.dao;

import java.util.List;

import org.hch.yhw.auction.model.AuctionUser;
import org.hch.yhw.auction.model.Orderdetail;
import org.hch.yhw.auction.model.Orderyi;

public interface OrderdetailDao {

	/**
	 * ����id���Ҷ���
	 * @param id ��Ҫ���ҵĶ���id
	 */
	Orderdetail get(Integer id);
	
	/**
	 * ���Ӷ���
	 * @param Orderdetail ��Ҫ���ӵĶ���
	 */
	void save(Orderdetail orderyi);

	/**
	 * �޸Ķ���
	 * @param Orderdetail ��Ҫ�޸ĵĶ���
	 */
	void update(Orderdetail orderyi);

	/**
	 * ɾ������
	 * @param id ��Ҫɾ���Ķ���id
	 */  
	void delete(Integer id);

	/**
	 * ɾ���û�
	 * @param user ��Ҫɾ���Ķ���
	 */
	void delete(Orderdetail orderyi);

	/**
	 * ��ѯȫ������
 	 * @return ���ȫ������
	 */
	List<Orderdetail> findAll();
	/**
	 * ���ݶ����Ų�ѯȫ������
 	 * @return ���ȫ��������ϸ
	 */
	List<Orderdetail> findByOrderyi(Integer orderyiid);

	
	
}
