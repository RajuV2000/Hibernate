package com.xworkz.movieDetails.dto;

import javax.persistence.*;

import com.xworkz.movieDetails.Enums.Language;

@Entity
@Table(name = "movie_details", schema = "hibernate")
public class MovieDetailsDto {

	@Id
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

	public MovieDetailsDto(int id, String movie, String director,Language language, int released, double rating) {
		super();
		this.id = id;
		this.movie = movie;
		this.director = director;
		this.language = language;
		this.released = released;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
