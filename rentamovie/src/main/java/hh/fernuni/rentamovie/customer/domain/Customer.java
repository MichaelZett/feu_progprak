package hh.fernuni.rentamovie.customer.domain;

import java.time.LocalDate;
import java.time.Period;

import hh.fernuni.rentamovie.common.domain.AbstractIdCarrier;

public class Customer extends AbstractIdCarrier {
	private String firstname;
	private String lastname;
	private LocalDate birthday;

	/**
	 * TODO Explain constructor. *
	 */
	public Customer(String firstname, String lastname, LocalDate birthday) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
	}

	Customer(Long id, String firstname, String lastname, LocalDate birthday) {
		super(id);
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
	}

	/**
	 * TODO Explain information hiding
	 */
	public void updateData(String firstname, String lastname, LocalDate birthdate) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
	}

	public int retrieveAge() {
		Period age = Period.between(birthday, LocalDate.now());
		return age.getYears();
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	@Override
	public String toString() {
		return "Customer [" + super.toString() + ", firstname=" + firstname + ", lastname=" + lastname + ", birthday="
				+ birthday + "]";
	}

}
