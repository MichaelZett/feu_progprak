package hh.fernuni.rentamovie.report.application;

import hh.fernuni.rentamovie.rent.application.RentService;
import hh.fernuni.rentamovie.report.domain.ReportRepository;

public class ReportServiceImpl implements ReportService {
	private RentService rentService = RentService.getService();
	private ReportRepository reportRepository = ReportRepository.getRepository();

	@Override
	public void createRentReport() {
		int size = rentService.readAllRents().size();
		reportRepository.save((long) size);
	}

}
