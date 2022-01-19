package com.xworkz.mobileRechargeHql.MobileRechargeHql.dao;

import java.util.List;

import com.xworkz.mobileRechargeHql.MobileRechargeHql.dto.MobileRechargeHqlDto;
import com.xworkz.mobileRechargeHql.MobileRechargeHql.enums.RechargeType;
import com.xworkz.mobileRechargeHql.MobileRechargeHql.enums.ServiceProvider;


public interface MobileRechargeHqlDao {

public boolean createRecharge(MobileRechargeHqlDto dto);
	
	public MobileRechargeHqlDto getMobileRechargeDto(int id);
	
	public boolean deleteMobileRechargeDto(int id);
	
	public boolean updateServiceProviderByNumber(long num, ServiceProvider provider);
	
	public List<ServiceProvider> getServiceProviderByType(RechargeType type);
	
	public double getPlanByServiceProvider(ServiceProvider provider);
	
	public long getNumberById(int id);
	
	public boolean updatePlanByServiceProvider(ServiceProvider provider, double newPlan);
	
	public boolean updateRechargeTypeByNumber(long number, RechargeType type);
	
	public boolean deleteByServiceProvider(ServiceProvider provider);
	
	public boolean deleteByRechargeType(RechargeType type);
	
	public List<MobileRechargeHqlDto> getAllMobileRecharge();
}
