package org.hch.yhw.auction.exception;

/**
 * Description:
 * <br/>地址: <a href="http://www.sise.com.cn">华软高效</a> 
 * <br/>Copyright (C), 2010-201?, 黄灿华   余宏伟
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:20100301-20100401
 * @author  hch0612@scse.com.cn
 * @version  1.0
 */
public class AuctionException extends Exception
{
	//定义一个无参数的构造器
	public AuctionException()
	{
	}
	//定义一个带message参数的构造参数
	public AuctionException(String message)
	{
		super(message);
	}
}
