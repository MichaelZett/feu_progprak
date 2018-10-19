package hh.fernuni.rentamovie.movie.domain;

import java.time.Year;

import hh.fernuni.rentamovie.common.domain.CommonRepositoryImpl;

class MovieRepositoryImpl extends CommonRepositoryImpl<Movie> implements MovieRepository {
	private static final MovieRepositoryImpl INSTANCE = new MovieRepositoryImpl("./movie.db");

	protected MovieRepositoryImpl(String filename) {
		super(filename);
	}

	public static MovieRepository getInstance() {
		return INSTANCE;
	}

	@Override
	protected Movie fromText(String[] strings) {
		return new Movie(Long.parseLong(strings[0]), Year.parse(strings[1]), strings[2]);
	}

	@Override
	protected String toText(Movie movie) {
		StringBuilder b = new StringBuilder();
		b.append(movie.getId()).append(DELIMITER);
		b.append(movie.getYearOfPublication().toString()).append(DELIMITER);
		b.append(movie.getTitle());
		return b.toString();
	}
}
