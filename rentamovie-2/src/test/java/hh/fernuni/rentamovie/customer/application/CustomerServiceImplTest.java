package hh.fernuni.rentamovie.customer.application;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Test;

import hh.fernuni.rentamovie.customer.domain.Customer;

public class CustomerServiceImplTest {

	@Test
	public void testCreateCustomer() throws Exception {
		// Given
		CustomerService testee = CustomerServiceImpl.getInstance();
		// When
		Customer result = testee.createCustomer("Jan", "B", LocalDate.of(1965, 12, 24));
		// Then
		assertThat(result.getFirstname(), is("Jan"));
		assertThat(result.getLastname(), is("B"));
		assertThat(result.getBirthday(), is(LocalDate.of(1965, 12, 24)));
	}

}
