package hh.fernuni.rentamovie.movie.application;

import java.time.Year;
import java.util.Collection;

import hh.fernuni.rentamovie.movie.domain.Copy;
import hh.fernuni.rentamovie.movie.domain.Movie;

public interface MovieService {

	static MovieService getService() {
		return MovieServiceImpl.getInstance();
	}

	Movie createMovie(Year yearOfPublication, String title);

	void createCopies(Movie movie, int count);

	Collection<Movie> readAllMovies();

	Collection<Copy> findAllCopiesOfMovie(Movie movie);

	void updateMovie(Movie currentMovie, Year year, String title);
}
