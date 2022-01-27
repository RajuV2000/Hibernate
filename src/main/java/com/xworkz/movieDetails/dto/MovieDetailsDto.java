package com.xworkz.movieDetails.dto;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.xworkz.movieDetails.Enums.Language;

@Entity
@Table(name = "movie_details", schema = "hibernate")
@NamedQueries({
	@NamedQuery(name = "getMovieDetailsById", query= "from MovieDetailsDto where id=:id"),
	@NamedQuery(name = "getMovieAndReleasedByDirector", query= "select movie, released from MovieDetailsDto where director=:dir"),
	@NamedQuery(name = "getDirectorAndRatingByMovie", query= "select director, rating from MovieDetailsDto where movie=:movie"),
	@NamedQuery(name = "getAllMovieAndLanguage", query="select movie, language from MovieDetailsDto"),
	@NamedQuery(name = "getAllMovieDetails", query= "from MovieDetailsDto"),
	@NamedQuery(name = "updateReleasedYearByMovie", query= "update MovieDetailsDto set released=:year where movie=:movie"),
	@NamedQuery(name = "deleteMovieDetailsByMovie", query= "delete MovieDetailsDto where movie=:movie"),
	@NamedQuery(name = "updateRatingByDirector", query="update MovieDetailsDto set rating=:rating where director=:dir")
})
public class MovieDetailsDto {

	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "movie")
	private String movie;
	@Column(name = "director")
	private String director;
	@Enumerated(EnumType.STRING)
	@Column(name = "language")
	private Language language;
	@Column(name = "released")
	private int released;
	@Column(name = "rating")
	private double rating;

	public MovieDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieDetailsDto(String movie, String director,Language language, int released, double rating) {
		super();
	//	this.id = id;
		this.movie = movie;
		this.director = director;
		this.language = language;
		this.released = released;
		this.rating = rating;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public int getReleased() {
		return released;
	}

	public void setReleased(int released) {
		this.released = released;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "MovieDetailsDto [id=" + id + ", movie=" + movie + ", director=" + director + ", language=" + language
				+ ", released=" + released + ", rating=" + rating + "]";
	}
	
}
