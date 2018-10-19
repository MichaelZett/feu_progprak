package hh.fernuni.rentamovie.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import hh.fernuni.rentamovie.customer.application.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class RentAMovieTest {
	@Mock
	private CustomerService customerServiceMock;
	@InjectMocks
	private RentAMovie testee;

	@Test
	public void testCreateCustomer() throws Exception {
		// TODO
	}

}
