package com.xworkz.mobileRechargeHql.MobileRechargeHql;

import com.xworkz.mobileRechargeHql.MobileRechargeHql.dao.MobileRechargeHqlDao;
import com.xworkz.mobileRechargeHql.MobileRechargeHql.dao.MobileRechargeHqlDaoImpl;
import com.xworkz.mobileRechargeHql.MobileRechargeHql.dto.MobileRechargeHqlDto;
import com.xworkz.mobileRechargeHql.MobileRechargeHql.enums.RechargeType;
import com.xworkz.mobileRechargeHql.MobileRechargeHql.enums.ServiceProvider;

public class MobileRechargeHqlCommence {

	public static void main(String[] args) {

		MobileRechargeHqlDto dto = new MobileRechargeHqlDto(1, ServiceProvider.AIRTEL, 9844465890l, 129, RechargeType.POSTPAID);
		
		MobileRechargeHqlDao dao = new MobileRechargeHqlDaoImpl();
		
		//System.out.println(dao.createRecharge(dto));
		
		//System.out.println(dao.getMobileRechargeDto(1));
		//System.out.println(dao.getServiceProviderByType(RechargeType.PREPAID));
		//System.out.println(dao.getPlanByServiceProvider(ServiceProvider.JIO));
		//System.out.println(dao.getNumberById(1));
		System.out.println(dao.getAllMobileRecharge());
		
		//System.out.println(dao.updateServiceProviderByNumber(8970413590l, ServiceProvider.VI));
		//System.out.println(dao.updatePlanByServiceProvider(ServiceProvider.AIRTEL, 399));
		//System.out.println(dao.updateRechargeTypeByNumber(9844465890l, RechargeType.PREPAID));
		
		//System.out.println(dao.deleteMobileRechargeDto(1));
		//System.out.println(dao.deleteByServiceProvider(ServiceProvider.AIRTEL));
		//System.out.println(dao.deleteByRechargeType(RechargeType.POSTPAID));
	}

}
