package com.xworkz.xworkzApp.islands.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.xworkz.xworkzApp.islands.dto.IslandDto;

public class IslandsDaoImpl implements IslandsDao{

	@Override
	public boolean createIsland(IslandDto dto) {
		
		if(dto!=null)
		{
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(IslandDto.class);
			
			SessionFactory factory = configuration.buildSessionFactory();
			
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(dto);
			transaction.commit();
			session.close();
			factory.close();
			return true;
		}
		else
			System.out.println("Island cannot be empty....");
		return false;
	}

	@Override
	public boolean deleteIslandById(int id) {
		
		if(id>0)
		{
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(IslandDto.class);
			
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			IslandDto idFromDb = session.get(IslandDto.class, id);
			
			if(idFromDb != null)
			{
				session.delete(idFromDb);
			}
			transaction.commit();
			session.close();
			factory.close();
			return true;
		}
		else
		{
			System.out.println("Id Cannot be less than 0...");
		}
		return false;
	}

	@Override
	public boolean updateIslandNameById(int id, String name) {
		
		if(id>0 && name!=null)
		{
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(IslandDto.class);
			
			SessionFactory factory = configuration.buildSessionFactory();
			
			Session session = factory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			IslandDto idFromDb = session.get(IslandDto.class, id);
			if(idFromDb != null)
			{
				idFromDb.setName(name);
				session.update(idFromDb);
			}
			transaction.commit();
			session.close();
			factory.close();
			return true;
		}
		else
			System.out.println("ID should be greater than zero....");
		return false;
	}

	@Override
	public IslandDto getIslandById(int id) {

		if(id>0)
		{
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(IslandDto.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			IslandDto dtoFromDb = session.get(IslandDto.class, id);
			
			transaction.commit();
			session.close();
			factory.close();
			
			return dtoFromDb;
		}
		else
			System.out.println("Id cannot be zero or less than zero...");
		return null;
	}
	
}
