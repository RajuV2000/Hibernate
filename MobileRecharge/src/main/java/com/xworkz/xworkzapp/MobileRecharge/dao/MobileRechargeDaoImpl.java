package com.xworkz.xworkzapp.MobileRecharge.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.xworkzapp.MobileRecharge.Setup.Setup;
import com.xworkz.xworkzapp.MobileRecharge.dto.MobileRechargeDto;
import com.xworkz.xworkzapp.MobileRecharge.enums.RechargeType;
import com.xworkz.xworkzapp.MobileRecharge.enums.SeviceProvider;

public class MobileRechargeDaoImpl implements MobileRechargeDao{

	@Override
	public boolean createRecharge(MobileRechargeDto dto) {

		boolean res = false;
		if(dto != null)
		{
			SessionFactory factory = Setup.getConfiguration().buildSessionFactory();
			
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.save(dto);
			
			transaction.commit();
			session.close();
			factory.close();
			res = true;
		}
		else
			System.out.println("Dto cannot be null...");
		return res;
	}

	@Override
	public MobileRechargeDto getMobileRechargeDto(int id) {

		if(id>0)
		{
			SessionFactory factory = Setup.getConfiguration().buildSessionFactory();
			
			Session session = factory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			MobileRechargeDto dtoFromDb = session.get(MobileRechargeDto.class, id);
			
			transaction.commit();
			session.close();
			factory.close();
			
			return dtoFromDb;
		}
		else
			System.out.println("id Should be greater than zero...");
		return null;
	}

	@Override
	public boolean deleteMobileRechargeDto(int id) {
		
		boolean res = false;
		if(id>0)
		{
			SessionFactory factory = Setup.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			MobileRechargeDto dtoFromDb = session.get(MobileRechargeDto.class, id);
			if(dtoFromDb!=null)
			{
				session.delete(dtoFromDb);
				res = true;
			}
			transaction.commit();
			session.close();
			factory.close();
		}
		else
			System.out.println("id should be greater than zero...");
		return res;
	}

	@Override
	public boolean updateServiceProviderByNumber(int id, long num, SeviceProvider provider) {

		boolean res = false;
		if(id>0 && num>0 && provider !=null)
		{
			SessionFactory factory = Setup.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			MobileRechargeDto dtoFromDb = session.get(MobileRechargeDto.class, id);
			if(dtoFromDb!=null)
			{
				dtoFromDb.setServiceProvider(provider);
				session.update(dtoFromDb);
				res = true;
			}
			
			transaction.commit();
			session.close();
			factory.close();
		}
		else
			System.out.println("id should be greater than zero, Number and provider should not be null");
		return res;
	}

	@Override
	public SeviceProvider getServiceProviderByType(int id, RechargeType type) {

		if(id>0 && type!= null)
		{
			SeviceProvider providerFromDb = null;
			SessionFactory factory = Setup.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			RechargeType typeFromDb = session.get(MobileRechargeDto.class, id).getRechargeType();
			
			if(typeFromDb.equals(type))
			{
				providerFromDb = session.get(MobileRechargeDto.class, id).getServiceProvider();
			}
			else
				System.out.println("RechargeType not matching...");
			
			transaction.commit();
			session.close();
			factory.close();
			return providerFromDb;
		}
		else
			System.out.println("id should be greater than zero and type cannot be null");
		return null;
	}

	@Override
	public double getPlanByServiceProvider(int id, SeviceProvider provider) {
		
		if(id>0 && provider!= null)
		{
			double planFromDb = 0;
			SessionFactory factory = Setup.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			SeviceProvider providerFromDb = session.get(MobileRechargeDto.class, id).getServiceProvider();
			
			if(providerFromDb.equals(provider))
			{
				planFromDb = session.get(MobileRechargeDto.class, id).getPlan();
			}
			else
				System.out.println("Provider not matching...");
			transaction.commit();
			session.close();
			factory.close();
			return planFromDb;
		}
		else
			System.out.println("Id should be greater than zero and provider cannot be null");
		return 0;
	}

	@Override
	public long getNumberById(int id) {
		
		if(id>0)
		{
			SessionFactory factory = Setup.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			long numFromDb = session.get(MobileRechargeDto.class, id).getNumber();
			
			transaction.commit();
			session.close();
			factory.close();
			
			return numFromDb;
		}
		else
			System.out.println("id should be greater than zero...");
		return 0;
	}

	@Override
	public boolean updatePlanById(int id, double newPlan) {
		
		boolean res = false;
		if(id>0 && newPlan>0)
		{
			SessionFactory factory = Setup.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.get(MobileRechargeDto.class, id).setPlan(newPlan);
			
			transaction.commit();
			session.close();
			factory.close();
			
			res = true;
		}
		else
			System.out.println("id and plan should be greater than zero...");
		return res;
	}

	@Override
	public boolean updateRechargeTypeByNumber(int id, long number, RechargeType type) {
		boolean res = false;
		
		if(id>0 && number>0 && type != null)
		{
			SessionFactory factory = Setup.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			MobileRechargeDto dtoFromDb = session.get(MobileRechargeDto.class, id);
			
			if(dtoFromDb.getNumber() == number)
			{
				dtoFromDb.setRechargeType(type);
				
				session.update(dtoFromDb);
				res = true;
			}
			
			transaction.commit();
			session.close();
			factory.close();
		}
		else
			System.out.println("id and number should be greater than zero and type cannot be null");
		return res;
	}

	@Override
	public boolean deleteByServiceProvider(int id, SeviceProvider provider) {
		
		boolean res = false;
		if(id>0 && provider != null)
		{
			SessionFactory factory = Setup.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			MobileRechargeDto dtoFromDb = session.get(MobileRechargeDto.class, id);
			
			if(dtoFromDb.getServiceProvider().equals(provider))
			{
				session.delete(dtoFromDb);
				res = true;
			}
			
			transaction.commit();
			session.close();
			factory.close();
			return res;
		}
		else
			System.out.println("id should be greater than zero and provider cannot be null");
		return res;
	}

	@Override
	public boolean deleteByRechargeType(int id, RechargeType type) {

		boolean res = false;
		if(id>0 && type!=null)
		{
			
			SessionFactory factory = Setup.getConfiguration().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			MobileRechargeDto dtoFromDb = session.get(MobileRechargeDto.class, id);
			
			if(dtoFromDb.getRechargeType().equals(type))
			{
				session.delete(dtoFromDb);
				res = true;
			}
			
			transaction.commit();
			session.close();
			factory.close();
			return res;
		}
		else
			System.out.println("id should be greater than zero and type cannot be null...");
		return res;
	}
	

}
