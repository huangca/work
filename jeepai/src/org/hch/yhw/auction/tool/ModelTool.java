package org.hch.yhw.auction.tool;

public class ModelTool {
private static final String EMS="EMS";
private static final String KUAIDI="���";
private static final String PP="��ͨ����";
public static double getModelMoney(String model){
	
	if(model.equals(EMS)){return 25.0;}
	if(model.equals(KUAIDI)){return 15.0;
	}
	if(model.equals(PP)){return 10.0;}
	return 0;
}
	
	
}
