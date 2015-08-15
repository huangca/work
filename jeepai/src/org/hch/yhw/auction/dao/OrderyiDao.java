package org.hch.yhw.auction.dao;

import java.util.List;

import org.hch.yhw.auction.model.AuctionUser;
import org.hch.yhw.auction.model.Orderyi;



public interface OrderyiDao {
 //����ID���Ҷ���ͷ��ϸ����
 //�ñ����˶���ID��������Ϣ������������Ʒ
	/**
	 * ����id���Ҷ���
	 * @param id ��Ҫ���ҵĶ���id
	 */
	Orderyi get(Integer id);
	
	/**
	 * ���Ӷ���
	 * @param Orderyi ��Ҫ���ӵĶ���
	 */
	void save(Orderyi orderyi);

	/**
	 * �޸Ķ���
	 * @param Orderyi ��Ҫ�޸ĵĶ���
	 */
	void update(Orderyi orderyi);

	/**
	 * ɾ������
	 * @param id ��Ҫɾ���Ķ���id
	 */  
	void delete(Integer id);

	/**
	 * ɾ���û�
	 * @param Orderyi ��Ҫɾ���Ķ���
	 */
	void delete(Orderyi orderyi);

	/**
	 * ��ѯȫ������
 	 * @return ���ȫ������
	 */
	List<Orderyi> findAll();
	/**
	 * ���ݻ�Ա��ѯȫ������
 	 * @return ���ȫ������
	 */
	List<Orderyi> findByMember(Integer userId);
	/**
	 * ����״̬��ѯȫ������
 	 * @return ���ȫ������--����ģ�û�����
	 */
	List<Orderyi> findBySign(boolean flag);
	
	//����orderyiid�Ѷ���
	Orderyi findByOrderyiid(String Orderyiid);
}
