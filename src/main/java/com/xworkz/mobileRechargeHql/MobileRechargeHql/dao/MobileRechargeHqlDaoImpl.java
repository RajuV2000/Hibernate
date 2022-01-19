package com.xworkz.mobileRechargeHql.MobileRechargeHql.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.mobileRechargeHql.MobileRechargeHql.dto.MobileRechargeHqlDto;
import com.xworkz.mobileRechargeHql.MobileRechargeHql.enums.RechargeType;
import com.xworkz.mobileRechargeHql.MobileRechargeHql.enums.ServiceProvider;
import com.xworkz.mobileRechargeHql.MobileRechargeHql.setup.GetConfiguration;

public class MobileRechargeHqlDaoImpl implements MobileRechargeHqlDao{

	@Override
	public boolean createRecharge(MobileRechargeHqlDto dto) {
		
		if(dto != null)
		{
			SessionFactory factory = GetConfiguration.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.save(dto);
			
			transaction.commit();
			session.close();
			factory.close();
			return true;
		}
		else
			System.out.println("dto cannot be null");
		return false;
	}

	@Override
	public MobileRechargeHqlDto getMobileRechargeDto(int id) {
		
		if(id >0)
		{
			String hql = "from MobileRechargeHqlDto where id ='"+id+"'";
			SessionFactory factory = GetConfiguration.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			
			Query query = session.createQuery(hql);
			//MobileRechargeHqlDto dtoFromDb = (MobileRechargeHqlDto) query.getSingleResult();
			
			MobileRechargeHqlDto dtoFromDb = (MobileRechargeHqlDto) query.getSingleResult();
			session.close();
			factory.close();
			
			return dtoFromDb;
		}
		else
			System.out.println("id should be greater than zero...");
		return null;
	}

	@Override
	public boolean deleteMobileRechargeDto(int id) {
		if(id >0)
		{
			String hql = "delete MobileRechargeHqlDto dto where dto.id ='"+id+"'";
			SessionFactory factory = GetConfiguration.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			int rowsAffected = query.executeUpdate();
			
			transaction.commit();
			session.close();
			factory.close();
			
			if(rowsAffected>0)
			{
				return true;
			}
		}
		else
			System.out.println("id should be greater than zero...");
		return false;
	}

	@Override
	public boolean updateServiceProviderByNumber(long num, ServiceProvider provider) {

		if(num>0 && provider != null)
		{
			String hql = "update MobileRechargeHqlDto set serviceProvider = '"+provider+"' where number = "+num;
			SessionFactory factory = GetConfiguration.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			int rowsAffected = query.executeUpdate();
			
			transaction.commit();
			session.close();
			factory.close();
			
			if(rowsAffected>0)
			{
				return true;
			}
		}
		else
			System.out.println("number should be greater than zero...");
		return false;
	}

	@Override
	public List<ServiceProvider> getServiceProviderByType(RechargeType type) {

		if(type != null)
		{
			String hql = "select serviceProvider from MobileRechargeHqlDto where type ='"+type+"'";
			SessionFactory factory = GetConfiguration.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			
			Query query = session.createQuery(hql);			
			List<ServiceProvider> provider = query.list();
			session.close();
			factory.close();
			
			return provider;
		}
		else
			System.out.println("type should not be null...");
		return null;
	}

	@Override
	public double getPlanByServiceProvider(ServiceProvider provider) {
		
		if(provider != null)
		{
			String hql = "select plan from MobileRechargeHqlDto where serviceProvider ='"+provider+"'";
			SessionFactory factory = GetConfiguration.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			
			Query query = session.createQuery(hql);			
			double planFromDb = (double) query.getSingleResult();
			
			session.close();
			factory.close();
			
			return planFromDb;
		}
		else
			System.out.println("provider should not be null...");
		return 0;
	}

	@Override
	public long getNumberById(int id) {

		if(id > 0)
		{
			String hql = "select number from MobileRechargeHqlDto where id ='"+id+"'";
			SessionFactory factory = GetConfiguration.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			
			Query query = session.createQuery(hql);			
			long num = (long) query.getSingleResult();
			
			session.close();
			factory.close();
			
			return num;
		}
		else
			System.out.println("id should be greater than zero...");
		return 0;
	}

	@Override
	public boolean updatePlanByServiceProvider(ServiceProvider provider, double newPlan) {
		
		if(newPlan>0 && provider != null)
		{
			String hql = "update MobileRechargeHqlDto set plan = "+newPlan+" where serviceProvider = '"+provider+"'";
			SessionFactory factory = GetConfiguration.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			int rowsAffected = query.executeUpdate();
			
			transaction.commit();
			session.close();
			factory.close();
			
			if(rowsAffected>0)
			{
				return true;
			}
		}
		else
			System.out.println("newplan should be greater than zero...");
		return false;
	}

	@Override
	public boolean updateRechargeTypeByNumber(long number, RechargeType type) {
		
		if(number>0 && type != null)
		{
			String hql = "update MobileRechargeHqlDto set type = '"+type+"' where number = "+number;
			SessionFactory factory = GetConfiguration.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			int rowsAffected = query.executeUpdate();
			
			transaction.commit();
			session.close();
			factory.close();
			
			if(rowsAffected>0)
			{
				return true;
			}
		}
		else
			System.out.println("number should be greater than zero...");
		return false;
	}

	@Override
	public boolean deleteByServiceProvider(ServiceProvider provider) {
		
		if(provider != null)
		{
			String hql = "delete MobileRechargeHqlDto dto where dto.serviceProvider ='"+provider+"'";
			SessionFactory factory = GetConfiguration.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			int rowsAffected = query.executeUpdate();
			
			transaction.commit();
			session.close();
			factory.close();
			
			if(rowsAffected>0)
			{
				return true;
			}
		}
		else
			System.out.println("provide should not be null...");
		return false;
	}

	@Override
	public boolean deleteByRechargeType(RechargeType type) {
		
		if(type != null)
		{
			String hql = "delete MobileRechargeHqlDto dto where dto.type ='"+type+"'";
			SessionFactory factory = GetConfiguration.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			int rowsAffected = query.executeUpdate();
			
			transaction.commit();
			session.close();
			factory.close();
			
			if(rowsAffected>0)
			{
				return true;
			}
		}
		else
			System.out.println("type should not be null...");
		return false;
	}

	@Override
	public List<MobileRechargeHqlDto> getAllMobileRecharge() {
		
		String hql = "from MobileRechargeHqlDto";
		SessionFactory factory = GetConfiguration.getConfiguration().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery(hql);
		List<MobileRechargeHqlDto> lists = query.list();
		
		transaction.commit();
		session.close();
		factory.close();
		return lists;
	}

}
