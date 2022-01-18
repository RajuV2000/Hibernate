package com.xworkz.xworkzapp.MobileRecharge.Setup;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.xworkz.xworkzapp.MobileRecharge.dto.MobileRechargeDto;

public class Setup {

	public static Configuration getConfiguration()
	{
		Configuration configuration = new Configuration();
		configuration.configure("resources/hibernate.cfg.xml");
		configuration.addAnnotatedClass(MobileRechargeDto.class);
		return configuration;
	}
}
