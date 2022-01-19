package com.xworkz.mobileRechargeHql.MobileRechargeHql.setup;

import org.hibernate.cfg.Configuration;

import com.xworkz.mobileRechargeHql.MobileRechargeHql.dto.MobileRechargeHqlDto;

public class GetConfiguration {

	public static Configuration getConfiguration()
	{
		Configuration configuration = new Configuration();
		configuration.configure("resources/hibernate.cfg.xml");
		configuration.addAnnotatedClass(MobileRechargeHqlDto.class);
		
		return configuration;
	}
}
