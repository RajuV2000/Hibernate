package com.xworkz.xworkzapp.MobileRecharge.dao;

import com.xworkz.xworkzapp.MobileRecharge.dto.MobileRechargeDto;
import com.xworkz.xworkzapp.MobileRecharge.enums.RechargeType;
import com.xworkz.xworkzapp.MobileRecharge.enums.SeviceProvider;

public interface MobileRechargeDao {

	public boolean createRecharge(MobileRechargeDto dto);
	
	public MobileRechargeDto getMobileRechargeDto(int id);
	
	public boolean deleteMobileRechargeDto(int id);
	
	public boolean updateServiceProviderByNumber(int id, long num, SeviceProvider provider);
	
	public SeviceProvider getServiceProviderByType(int id, RechargeType type);
	
	public double getPlanByServiceProvider(int id, SeviceProvider provider);
	
	public long getNumberById(int id);
	
	public boolean updatePlanById(int id, double newPlan);
	
	public boolean updateRechargeTypeByNumber(int id, long number, RechargeType type);
	
	public boolean deleteByServiceProvider(int id, SeviceProvider provider);
	
	public boolean deleteByRechargeType(int id, RechargeType type);
}
