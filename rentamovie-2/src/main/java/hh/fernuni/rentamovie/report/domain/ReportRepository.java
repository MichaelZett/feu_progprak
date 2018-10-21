package hh.fernuni.rentamovie.report.domain;

public interface ReportRepository {
	void save(Long count);

	static ReportRepository getRepository() {
		return ReportRepositoryImpl.getInstance();
	};
}
