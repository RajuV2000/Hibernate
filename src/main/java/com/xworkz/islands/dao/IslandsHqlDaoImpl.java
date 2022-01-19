package com.xworkz.islands.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.islands.dto.IslandsHqlDto;
import com.xworkz.islands.setup.CreateConfiguration;

public class IslandsHqlDaoImpl implements IslandsHqlDao{

	@Override
	public boolean createIsland(IslandsHqlDto dto) {
		
		if(dto != null)
		{
			SessionFactory factory = CreateConfiguration.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.save(dto);
			
			transaction.commit();
			session.close();
			factory.close();
			return true;
		}
		else
			System.out.println("dto should not be null...");
		return false;
	}

	@Override
	public boolean deleteIslandByLocation(String loc) {

		if(loc != null)
		{
			String hql = "delete IslandsHqlDto where loc='"+loc+"'";
			SessionFactory factory = CreateConfiguration.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			int rowsAffected = query.executeUpdate();
			
			transaction.commit();
			session.close();
			factory.close();
			
			return rowsAffected>0 ? true:false;
		}
		return false;
	}

	@Override
	public boolean updateIslandNameByLocation(String loc, String name) {

		if(loc != null && name !=null)
		{
			String hql = "update IslandsHqlDto set name= '"+name+"' where loc='"+loc+"'";
			SessionFactory factory = CreateConfiguration.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			int rowsAffected = query.executeUpdate();
			
			transaction.commit();
			session.close();
			factory.close();
			
			return rowsAffected>0 ? true:false;
		}
		return false;
	}

	@Override
	public IslandsHqlDto getIslandByName(String name) {
		
		if(name != null)
		{
			String hql = "from IslandsHqlDto where name = '"+name+"'";
			SessionFactory factory = CreateConfiguration.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			IslandsHqlDto dtoFromDb = (IslandsHqlDto) query.getSingleResult();
			
			transaction.commit();
			session.close();
			factory.close();
			return dtoFromDb;
		}
		return null;
	}

	@Override
	public List<IslandsHqlDto> getAllIslands() {

		String hql = "from IslandsHqlDto";
		SessionFactory factory = CreateConfiguration.getConfiguration().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery(hql);
		List<IslandsHqlDto> lists = query.list();
		
		transaction.commit();
		session.close();
		factory.close();
		
		return lists;
	}

}
