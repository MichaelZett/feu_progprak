package hh.fernuni.rentamovie.movie.domain;

import java.time.Year;

import hh.fernuni.rentamovie.common.domain.AbstractIdCarrier;

public class Movie extends AbstractIdCarrier {
	private String title;
	private Year yearOfPublication;

	public Movie(String title, Year yearOfPublication) {
		super();
		this.title = title;
		this.yearOfPublication = yearOfPublication;
	}

	public Movie(long id, Year yearOfPublication, String title) {
		super(id);
		this.title = title;
		this.yearOfPublication = yearOfPublication;
	}

	public void updateData(Year yearOfPublication, String title) {
		this.yearOfPublication = yearOfPublication;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public Year getYearOfPublication() {
		return yearOfPublication;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", yearOfPublication=" + yearOfPublication + ", id=" + id + "]";
	}

}
