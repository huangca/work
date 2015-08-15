package org.hch.yhw.auction.dao;

import java.util.List;

import org.hch.yhw.auction.model.Admin;

public interface AdminDao {
	/**
	 * ����id�����û�
	 * @param id ��Ҫ���ҵ��û�id
	 */
	Admin get(Integer id);
	
	/**
	 * �����û�
	 * @param user ��Ҫ���ӵ��û�
	 */
	void save(Admin user);

	/**
	 * �޸��û�
	 * @param user ��Ҫ�޸ĵ��û�
	 */
	void update(Admin user);

	/**
	 * ɾ���û�
	 * @param id ��Ҫɾ�����û�id
	 */  
	void delete(Integer id);

	/**
	 * ɾ���û�
	 * @param user ��Ҫɾ�����û�
	 */
	void delete(Admin user);

	/**
	 * ��ѯȫ���û�
 	 * @return ���ȫ���û�
	 */
	List<Admin> findAll();

	/**
	 * �����û�������������û�
	 * @param username ��ѯ������û���
	 * @param pass ��ѯ���������
	 * @return ָ���û����������Ӧ���û�
	 */
	Admin findAdminByNameAndPass(String username , String pass);
}
