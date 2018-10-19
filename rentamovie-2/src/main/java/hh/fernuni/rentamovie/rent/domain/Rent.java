package hh.fernuni.rentamovie.rent.domain;

import java.time.LocalDate;

import hh.fernuni.rentamovie.common.domain.AbstractIdCarrier;
import hh.fernuni.rentamovie.customer.domain.Customer;
import hh.fernuni.rentamovie.movie.domain.Copy;

public class Rent extends AbstractIdCarrier {
	private Customer customer;
	private Copy copy;
	private LocalDate startDate;
	private LocalDate endDate;

	public Rent(Customer user, Copy copy, LocalDate startDate) {
		super();
		this.customer = user;
		this.copy = copy;
		this.startDate = startDate;
	}

	Rent(Long id, LocalDate startDate, LocalDate endDate, Customer user, Copy copy) {
		super(id);
		this.customer = user;
		this.copy = copy;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Customer getUser() {
		return customer;
	}

	public Copy getCopy() {
		return copy;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public boolean isValid() {
		return endDate == null;
	}

	public void endRent() {
		endDate = LocalDate.now();
	}

	@Override
	public String toString() {
		return "Rent [" + super.toString() + ", startDate=" + startDate + ", endDate=" + endDate + ", user= " + customer
				+ ", copy=" + copy + "]";
	}

}
