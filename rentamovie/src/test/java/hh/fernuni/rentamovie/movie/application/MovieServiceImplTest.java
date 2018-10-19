package hh.fernuni.rentamovie.movie.application;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Year;
import java.util.Collection;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import hh.fernuni.rentamovie.movie.domain.Movie;
import hh.fernuni.rentamovie.movie.domain.MovieRepository;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceImplTest {
	@Mock
	MovieRepository movieRepositoryMock;
	@InjectMocks
	MovieServiceImpl testee;

	@Test
	public void testCreateCopies() throws Exception {
		Movie movie = mock(Movie.class);

		testee.createCopies(movie, 3);
	}

	@Test
	public void shouldCreateAMovie() throws Exception {
		Movie result = testee.createMovie(Year.of(2000), "Title");

		assertThat(result.getYearOfPublication(), is(Year.of(2000)));
		verify(movieRepositoryMock).save(any(Movie.class));
	}

	@Test
	public void shouldReturnAllAMovies() throws Exception {
		Movie movie = mock(Movie.class);
		Collection<Movie> col = Collections.singleton(movie);
		when(movieRepositoryMock.readAll()).thenReturn(col);

		Collection<Movie> result = testee.readAllMovies();

		assertThat(result.contains(movie), is(true));
	}
}
