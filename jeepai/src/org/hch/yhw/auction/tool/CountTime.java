package org.hch.yhw.auction.tool;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



public class CountTime {

	public  String currentlyTime() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		return dateFormat.format(date);
	}
	
	public  String createLiushuihao(Date date) {		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return simpleDateFormat.format(date);
	}

}
