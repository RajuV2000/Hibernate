package com.xworkz.islands.setup;

import org.hibernate.cfg.Configuration;

import com.xworkz.islands.dto.IslandsHqlDto;

public class CreateConfiguration {

	public static Configuration getConfiguration()
	{
		Configuration configuration = new Configuration();
		configuration.configure("resources/hibernate.cfg.xml");
		configuration.addAnnotatedClass(IslandsHqlDto.class);
		
		return configuration;
	}
}
