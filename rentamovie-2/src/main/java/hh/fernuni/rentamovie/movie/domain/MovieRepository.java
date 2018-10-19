package hh.fernuni.rentamovie.movie.domain;

import hh.fernuni.rentamovie.common.domain.CommonRepository;

public interface MovieRepository extends CommonRepository<Movie> {

	static MovieRepository getRepository() {
		return MovieRepositoryImpl.getInstance();
	}

}
