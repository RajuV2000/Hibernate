package com.xworkz.movieDetails;

import java.util.List;

import com.xworkz.movieDetails.Enums.Language;
import com.xworkz.movieDetails.dao.MovieDetailsDao;
import com.xworkz.movieDetails.dao.MovieDetailsDaoImpl;
import com.xworkz.movieDetails.dto.MovieDetailsDto;

public class MovieDetailsCommence {

	public static void main(String[] args) {
		
		MovieDetailsDao dao = new MovieDetailsDaoImpl();
		
		MovieDetailsDto dto = new MovieDetailsDto(7, "Badava Rascal", "Shankar Guru", Language.KANNADA, 2021, 8.2);
		
		//System.out.println(dao.createMovieDetails(dto));
		
		//System.out.println(dao.getMovieDetailsById(7));
		
//		Object[] objList = dao.getMovieAndReleasedByDirector("Sukumar");
//		for (Object object : objList) {
//			System.out.print(object + " ");
//		}
		
//		Object[] objList = dao.getDirectorAndRatingByMovie("Badava Rascal");
//		for (Object object : objList) {
//			System.out.print(object + " ");
//		}
		
//		List<Object[]> lists = dao.getAllMovieAndLanguage();
//		for (Object[] objects : lists) {
//			for (Object objects2 : objects) {
//				System.out.print(objects2 + " ");
//			}
//			System.out.println(System.lineSeparator());
//		}
		
		List<MovieDetailsDto> lists = dao.getAllMovieDetails();
		for (MovieDetailsDto movieDetailsDto : lists) {
			System.out.println(movieDetailsDto);
		}
		
		//System.out.println(dao.updateReleasedYearByMovie("Sooryavamshi", 2020));
		//System.out.println(dao.updateRatingByDirector("Sukumar", 5.2));
		//System.out.println(dao.deleteMovieDetailsByMovie("Pushpa"));
	}

}
