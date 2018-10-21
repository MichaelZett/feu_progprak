package hh.fernuni.rentamovie.rent.application;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import hh.fernuni.rentamovie.movie.application.MovieService;
import hh.fernuni.rentamovie.movie.domain.Copy;
import hh.fernuni.rentamovie.movie.domain.Movie;
import hh.fernuni.rentamovie.rent.domain.Rent;
import hh.fernuni.rentamovie.rent.domain.RentRepository;

public class RentServiceImpl implements RentService {
	private static final RentService INSTANCE = new RentServiceImpl();
	private MovieService movieService = MovieService.getService();
	private RentRepository rentRepository = RentRepository.getRepository();

	private RentServiceImpl() {
		// not intended
	}

	@Override
	public Collection<Copy> findAllFreeCopies(Movie movie) {
		Collection<Copy> allCopies = movieService.findAllCopiesOfMovie(movie);
		Set<Copy> rentedCopies = rentRepository.readAll().stream()
		        .filter(r -> r.isValid() && allCopies.contains(r.getCopy())).map(r -> r.getCopy())
		        .collect(Collectors.toSet());
		allCopies.removeAll(rentedCopies);
		return allCopies;
	}

	public static RentService getInstance() {
		return INSTANCE;
	}

	@Override
	public Collection<Rent> readAllRents() {
		return rentRepository.readAll();
	}

	@Override
	public void save(Rent rent) {
		rentRepository.save(rent);
	}

}
