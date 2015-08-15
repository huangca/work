package org.hch.yhw.auction.dao;

import java.util.List;

import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.model.*;
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
public interface KindDao  
{
	/**
	 * ����id��������
	 * @param id ��Ҫ���ҵ������id
	 */
	Kind get(Integer id);

	/**
	 * ��������
	 * @param kind ��Ҫ���ӵ�����
	 */
	void save(Kind kind);

	/**
	 * �޸�����
	 * @param kind ��Ҫ�޸ĵ�����
	 */
	void update(Kind kind);

	/**
	 * ɾ������
	 * @param id ��Ҫɾ��������id
	 */
	void delete(Integer id);

	/**
	 * ɾ������
	 * @param kind ��Ҫɾ��������
	 */
	void delete(Kind kind);

	/**
	 * ��ѯȫ������
	 * @return ���ȫ������
	 */
	List<Kind> findAll();
	
	/**
	 * ��ѯȫ�����������ʶ
	 * @return ���ȫ������
	 */
	
	List<Kind> findAllByBigKindId(Integer bigkindId);
	/**
	 * ��ѯȫ��������ݴ������
	 * @return ���ȫ������
	 */
	List<Kind> findAllByBigKind(Bigkind bigKind);
	
}
