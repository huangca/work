package org.hch.yhw.auction.schedule;

import java.util.TimerTask;

import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.service.AuctionManager;
import org.hch.yhw.auction.service.AuctionManagerToYiItem;
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
public class CheckWiner extends TimerTask
{
	//������������ҵ���߼����
	private AuctionManager mgr;

	//����ע��ҵ���߼���������setter����
	public void setMgr(AuctionManager mgr)
	{
		this.mgr = mgr;
	}
	//�������ִ����
	public void run()
	{
		try
		{
			mgr.updateWiner();
			
		}
		catch (AuctionException ae)
		{
			ae.printStackTrace();
		}
	}
}
