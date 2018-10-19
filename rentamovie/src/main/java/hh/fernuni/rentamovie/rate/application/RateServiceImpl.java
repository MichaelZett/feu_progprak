package hh.fernuni.rentamovie.rate.application;

import hh.fernuni.rentamovie.rate.domain.Rate;

class RateServiceImpl implements RateService {

	@Override
	public Rate retrieveRateByAge(int age) {

		if (age < 18) {
			return Rate.JUNIOR;
		} else if (age > 60) {
			return Rate.SENIOR;
		} else {
			return Rate.REGULAR;
		}
	}

	public Rate retrieveRateByAgeCase(int age) {
		Rate rate = Rate.REGULAR;
		switch (age) {
		case 18:
			rate = Rate.JUNIOR;
			break;
		case 25:
			rate = Rate.REGULAR;
			break;
		default:

		}
		return rate;
	}

}
