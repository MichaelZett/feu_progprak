package hh.fernuni.rentamovie.rent.application;

import java.util.Collection;

import hh.fernuni.rentamovie.movie.domain.Copy;
import hh.fernuni.rentamovie.movie.domain.Movie;
import hh.fernuni.rentamovie.rent.domain.Rent;

public interface RentService {
	Collection<Copy> findAllFreeCopies(Movie movie);

	static RentService getService() {
		return RentServiceImpl.getInstance();
	}

	Collection<Rent> readAllRents();
}
