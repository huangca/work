package org.hch.yhw.auction.dao;

import java.util.List;

import org.hch.yhw.auction.model.Bigkind;

public interface BigKindDao {

	

	/**
	 * ����id���Ҵ���
	 * @param id ��Ҫ���ҵĴ����id
	 */
	Bigkind get(Integer id);

	/**
	 * ���Ӵ���
	 * @param kind ��Ҫ���ӵĴ���
	 */
	void save(Bigkind bigkind);

	/**
	 * �޸Ĵ���
	 * @param kind ��Ҫ�޸ĵĴ���
	 */
	void update(Bigkind bigkind);

	/**
	 * ɾ������
	 * @param id ��Ҫɾ���Ĵ���id
	 */
	void delete(Integer id);

	/**
	 * ɾ������
	 * @param kind ��Ҫɾ���Ĵ���
	 */
	void delete(Bigkind bigkind);

	/**
	 * ��ѯȫ������
	 * @return ���ȫ������
	 */
	List<Bigkind> findAll();
	
	
	
}
