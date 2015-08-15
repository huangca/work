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
public interface YiItemDao {
	/**
	 * ��������������Ʒ
	 * @param itemId ����ҵ���Ʒ��id;
	 * @return id��Ӧ����Ʒ
	 */
	YiItem get(Integer itemId);

	/**
	 * ������Ʒ
	 * @param item ��Ҫ�������Ʒ
	 */
	void save(YiItem item);

	/**
	 * �޸���Ʒ
	 * @param item ��Ҫ�޸ĵ���Ʒ
	 */
	void update(YiItem item);

	/**
	 * ɾ����Ʒ
	 * @param id ��Ҫɾ������Ʒid
	 */
	void delete(Integer id);

	/**
	 * ɾ����Ʒ
	 * @param item ��Ҫɾ������Ʒ
	 */
	void delete(YiItem item);

	/**
	 * ���ݲ�Ʒ���࣬��ȡ��ǰ������ȫ����Ʒ
	 * @param kindId ����id;
	 * @return �����ȫ����Ʒ
	 */
	List<YiItem> findYiItemByKind(Integer kindId);

	/**
	 * ���������߲��Ҵ��������е���Ʒ
	 * @param useId ������Id;
	 * @return ָ���û����������е�ȫ����Ʒ
	 */
	List<YiItem> findYiItemByOwner(Integer userId);



	/**
	 * ������Ʒ״̬������Ʒ
	 * @param stateId ״̬Id;
	 * @return ��״̬�µ�ȫ����Ʒ
	 */
	List<YiItem> findYiItemByState(Integer stateId);
	/**
	 * ������Ʒ
	 * @return ȫ����Ʒ
	 */
	List<YiItem> findYiItem();
	/**
	 * �������·�����������Ʒ��Ʒ
	 * @return ȫ����Ʒ
	 */
	List<YiItem> findNewYiItemTop();
	
	//��ҳ���ԣ���ɺ�̨��
	List getYiItemPage(int pageSize, int startRow);
	//ǰ̨��ҳ����
	List getYiItemStatePage(int pageSize, int startRow,int stateId);
	//ǰ̨��ҳ����
	List getYiItemStateKindPage(int pageSize, int startRow,int kindId);
}
