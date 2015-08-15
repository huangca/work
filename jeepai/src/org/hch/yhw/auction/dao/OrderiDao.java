package org.hch.yhw.auction.dao;

import java.util.List;

import org.hch.yhw.auction.model.Orderi;

public interface OrderiDao {
	//����ID���Ҷ���ͷ��ϸ����
	 //�ñ����˶���ID��������Ϣ������������Ʒ
		/**
		 * ����id���Ҷ���
		 * @param id ��Ҫ���ҵľ���Ʒ����id
		 */
		Orderi get(Integer id);
		
		/**
		 * ���Ӷ���
		 * @param Orderi ��Ҫ���ӵľ���Ʒ����
		 */
		void save(Orderi orderi);

		/**
		 * �޸Ķ���
		 * @param Orderi ��Ҫ�޸ľ���Ʒ�Ķ���
		 */
		void update(Orderi orderi);

		/**
		 * ɾ������
		 * @param id ��Ҫɾ���ľ���Ʒ����id
		 */  
		void delete(Integer id);

		/**
		 * ɾ���û�
		 * @param Orderi ��Ҫɾ������Ʒ�Ķ���
		 */
		void delete(Orderi orderi);

		/**
		 * ��ѯȫ������
	 	 * @return ���ȫ������Ʒ����
		 */
		List<Orderi> findAll();
		/**
		 * ���ݻ�Ա��ѯȫ������
	 	 * @return ���ȫ������Ʒ����
		 */
		List<Orderi> findByMember(Integer userId);
		/**
		 * ����״̬��ѯȫ������
	 	 * @return ���ȫ������--����ģ�û�����
		 */
		List<Orderi> findBySign(boolean flag);
		/**
		 * ����״̬��ѯ������
	 	 * @return ��ö���
		 */
		Orderi findByOrderi(String orderId);
}
