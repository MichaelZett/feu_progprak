package hh.fernuni.rentamovie.movie.application;

import java.time.Year;
import java.util.Collection;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hh.fernuni.rentamovie.movie.domain.Copy;
import hh.fernuni.rentamovie.movie.domain.CopyRepository;
import hh.fernuni.rentamovie.movie.domain.Movie;
import hh.fernuni.rentamovie.movie.domain.MovieRepository;
import hh.fernuni.rentamovie.report.application.ReportService;
import hh.fernuni.rentamovie.report.application.ReportServiceImpl;

class MovieServiceImpl implements MovieService {
	private static final Logger LOG = LoggerFactory.getLogger(MovieServiceImpl.class);
	private static final MovieService INSTANCE = new MovieServiceImpl();
	private MovieRepository movieRepository = MovieRepository.getRepository();
	private CopyRepository copyRepository = CopyRepository.getRepository();
	private ReportService reportRepository = new ReportServiceImpl();

	private MovieServiceImpl() {
		// not creatable from out of this class
	}

	public static MovieService getInstance() {
		return INSTANCE;
	}

	@Override
	public Movie createMovie(Year yearOfPublication, String title) {
		reportRepository.createRentReport();
		Movie movie = new Movie(title, yearOfPublication);
		movieRepository.save(movie);
		return movie;
	}

	@Override
	public void updateMovie(Movie currentMovie, Year year, String title) {
		currentMovie.updateData(year, title);
		movieRepository.save(currentMovie);
	}

	@Override
	public void createCopies(Movie movie, int numberToCreate) {
		createCopiesWhile(movie, numberToCreate);
		// for (int i = 0; i < numberToCreate; i++) {
		// Copy copy = new Copy(movie);
		// copyRepository.save(copy);
		// LOG.info("Created: {}", copy);
		// }
	}

	private void createCopiesWhile(Movie movie, int numberToCreate) {
		int i = 0;
		while (i < numberToCreate) {
			Copy copy = new Copy(movie);
			copyRepository.save(copy);
			LOG.info("Created: {}", copy);
			i++;
		}
	}

	@Override
	public Collection<Movie> readAllMovies() {
		return movieRepository.readAll();
	}

	@Override
	public Collection<Copy> findAllCopiesOfMovie(Movie movie) {
		return copyRepository.readAll().stream().filter(c -> c.getMovie().equals(movie)).collect(Collectors.toSet());
	}

}
