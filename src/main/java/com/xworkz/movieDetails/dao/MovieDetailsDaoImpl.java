package com.xworkz.movieDetails.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.movieDetails.dto.MovieDetailsDto;
import com.xworkz.singleton.HibernateUtil;

public class MovieDetailsDaoImpl implements MovieDetailsDao{
	
	@Override
	public boolean createMovieDetails(MovieDetailsDto dto) {

		if(dto!= null)
		{
			SessionFactory factory = HibernateUtil.getFactory();
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
			//String hql = "from MovieDetailsDto where id=?";
			
			MovieDetailsDto dto = (MovieDetailsDto) HibernateUtil.getFactory().openSession().getNamedQuery("getMovieDetailsById").setParameter("id", id).uniqueResult();
			
			return dto;
		}
		return null;
	}

	@Override
	public Object[] getMovieAndReleasedByDirector(String director) {

		if(director !=null)
		{
			//String hql = "select movie, released from MovieDetailsDto where director=?";
	
			Object[] obj = (Object[]) HibernateUtil.getFactory().openSession().getNamedQuery("getMovieAndReleasedByDirector").setParameter("dir", director).uniqueResult();
			return obj;
		}
		return null;
	}

	@Override
	public Object[] getDirectorAndRatingByMovie(String movie) {

		if(movie !=null)
		{
			//String hql = "select director, rating from MovieDetailsDto where movie= ?";
			Object[] obj = (Object[]) HibernateUtil.getFactory().openSession().getNamedQuery("getDirectorAndRatingByMovie").setParameter("movie", movie).uniqueResult();

			return obj;
		}
		return null;
	}

	@Override
	public List<Object[]> getAllMovieAndLanguage() {
		
		//String hql = "select movie, language from MovieDetailsDto";
		List<Object[]> list = HibernateUtil.getFactory().openSession().getNamedQuery("getAllMovieAndLanguage").list();
		return list;
	}

	@Override
	public List<MovieDetailsDto> getAllMovieDetails() {
		
		//String hql = "from MovieDetailsDto";
		List<MovieDetailsDto> list = HibernateUtil.getFactory().openSession().getNamedQuery("getAllMovieDetails").list();
		return list;
	}

	@Override
	public boolean updateReleasedYearByMovie(String movie, int year) {

		if(movie != null && year>1000)
		{
			//String hql = "update MovieDetailsDto set released=:year where movie=:movie";
			SessionFactory factory = HibernateUtil.getFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.getNamedQuery("updateReleasedYearByMovie");
			query.setParameter("year", year);
			query.setParameter("movie", movie);
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
			//String hql = "update MovieDetailsDto set rating=:rating where director=:dir";
			SessionFactory factory = HibernateUtil.getFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.getNamedQuery("updateRatingByDirector");
			query.setParameter("rating", rating);
			query.setParameter("dir", director);
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
			//String hql = "delete MovieDetailsDto where movie=:movie";
			SessionFactory factory = HibernateUtil.getFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.getNamedQuery("deleteMovieDetailsByMovie");
			query.setParameter("movie", movie);
			int rowsAffected = query.executeUpdate();
			
			transaction.commit();
			session.close();
			factory.close();
			return rowsAffected>0 ? true:false;
		}
		return false;
	}

}
