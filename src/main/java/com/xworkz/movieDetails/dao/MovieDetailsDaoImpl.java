package com.xworkz.movieDetails.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.movieDetails.dto.MovieDetailsDto;
import com.xworkz.singleton.HibernateUtil;

public class MovieDetailsDaoImpl implements MovieDetailsDao{

	static SessionFactory factory = HibernateUtil.getFactory();
	@Override
	public boolean createMovieDetails(MovieDetailsDto dto) {

		if(dto!= null)
		{
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.save(dto);
			
			transaction.commit();
			session.close();
			factory.close();
			return true;
		}
		return false;
	}

	@Override
	public MovieDetailsDto getMovieDetailsById(int id) {

		if(id>0)
		{
			String hql = "from MovieDetailsDto where id="+id;
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			MovieDetailsDto dto = (MovieDetailsDto) query.uniqueResult();
			transaction.commit();
			session.close();
			factory.close();
			return dto;
		}
		return null;
	}

	@Override
	public Object[] getMovieAndReleasedByDirector(String director) {

		if(director !=null)
		{
			String hql = "select movie, released from MovieDetailsDto where director= '"+ director+"'";
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			Object[] obj = (Object[]) query.uniqueResult();
			
			transaction.commit();
			session.close();
			factory.close();
			return obj;
		}
		return null;
	}

	@Override
	public Object[] getDirectorAndRatingByMovie(String movie) {

		if(movie !=null)
		{
			String hql = "select director, rating from MovieDetailsDto where movie= '"+ movie+"'";
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			Object[] obj = (Object[]) query.uniqueResult();
			
			transaction.commit();
			session.close();
			factory.close();
			return obj;
		}
		return null;
	}

	@Override
	public List<Object[]> getAllMovieAndLanguage() {
		
		String hql = "select movie, language from MovieDetailsDto";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery(hql);
		List<Object[]> list = (List<Object[]>) query.list();
		
		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public List<MovieDetailsDto> getAllMovieDetails() {
		
		String hql = "from MovieDetailsDto";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery(hql);
		List<MovieDetailsDto> list = (List<MovieDetailsDto>) query.list();
		
		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public boolean updateReleasedYearByMovie(String movie, int year) {

		if(movie != null && year>1000)
		{
			String hql = "update MovieDetailsDto set released="+year+" where movie='"+movie+"'";
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
	public boolean updateRatingByDirector(String director, double rating) {
		
		if(director != null && rating>0)
		{
			String hql = "update MovieDetailsDto set rating="+rating+" where director='"+director+"'";
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
	public boolean deleteMovieDetailsByMovie(String movie) {

		if(movie != null)
		{
			String hql = "delete MovieDetailsDto where movie='"+movie+"'";
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

}
