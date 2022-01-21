package com.xworkz.movieDetails.dao;

import java.util.List;

import com.xworkz.movieDetails.dto.MovieDetailsDto;

public interface MovieDetailsDao {

	boolean createMovieDetails(MovieDetailsDto dto);
	
	MovieDetailsDto getMovieDetailsById(int id);
	
	Object[] getMovieAndReleasedByDirector(String director);
	
	Object[] getDirectorAndRatingByMovie(String movie);
	
	List<Object[]> getAllMovieAndLanguage();
	
	List<MovieDetailsDto> getAllMovieDetails();
	
	boolean updateReleasedYearByMovie(String movie, int years);
	
	boolean updateRatingByDirector(String director, double rating);
	
	boolean deleteMovieDetailsByMovie(String movie);
}
