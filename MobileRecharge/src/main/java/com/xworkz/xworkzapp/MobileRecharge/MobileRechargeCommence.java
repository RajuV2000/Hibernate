package com.xworkz.xworkzapp.MobileRecharge;

import com.xworkz.xworkzapp.MobileRecharge.dao.MobileRechargeDao;
import com.xworkz.xworkzapp.MobileRecharge.dao.MobileRechargeDaoImpl;
import com.xworkz.xworkzapp.MobileRecharge.dto.MobileRechargeDto;
import com.xworkz.xworkzapp.MobileRecharge.enums.RechargeType;
import com.xworkz.xworkzapp.MobileRecharge.enums.SeviceProvider;

public class MobileRechargeCommence {

	public static void main(String[] args) {
		
		MobileRechargeDao dao = new MobileRechargeDaoImpl();
		
		MobileRechargeDto dto = new MobileRechargeDto(3, SeviceProvider.IDEA, 8970413590l, 399, RechargeType.PREPAID);
		
		//System.out.println(dao.createRecharge(dto));
		
		//System.out.println(dao.deleteMobileRechargeDto(3));
		
		//System.out.println(dao.getMobileRechargeDto(3));
		
		//System.out.println(dao.updateServiceProviderByNumber(3, 8970413590l, SeviceProvider.VODAFONE));
		
		//System.out.println(dao.getServiceProviderByType(3, RechargeType.PREPAID));
		
		//System.out.println(dao.getPlanByServiceProvider(3, SeviceProvider.IDEA));
		
		//System.out.println(dao.deleteByRechargeType(3,RechargeType.PREPAID));
		
		//System.out.println(dao.getNumberById(3));
		
		//System.out.println(dao.deleteByServiceProvider(3, SeviceProvider.IDEA));
		
		//System.out.println(dao.updatePlanById(1, 259));
		
		//System.out.println(dao.updateRechargeTypeByNumber(3, 8970413590l, RechargeType.NULL));
	}
}
