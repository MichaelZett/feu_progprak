package hh.fernuni.rentamovie.movie.domain;

import hh.fernuni.rentamovie.common.domain.AbstractIdCarrier;

public class Copy extends AbstractIdCarrier {
	private Movie movie;

	public Copy(Movie movie) {
		super();
		this.movie = movie;
	}

	Copy(Long id, Movie movie) {
		super(id);
		this.movie = movie;
	}

	public Movie getMovie() {
		return movie;
	}

	@Override
	public String toString() {
		return "Copy [" + super.toString() + ", movie=" + movie + "]";
	}

}
