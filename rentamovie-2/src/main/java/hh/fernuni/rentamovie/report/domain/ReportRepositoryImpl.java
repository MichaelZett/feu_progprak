package hh.fernuni.rentamovie.report.domain;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.Collections;

class ReportRepositoryImpl implements ReportRepository {
	private static final ReportRepository INSTANCE = new ReportRepositoryImpl();

	private ReportRepositoryImpl() {
		super();
	}

	@Override
	public void save(Long count) {
		Path newReportPath = Paths.get("./" + Instant.now().toString().replace(":", "").replace(".", "") + "-report.txt");
		try {
			Files.createFile(newReportPath);
			Files.write(newReportPath, Collections.singletonList("Anzahl Ausleihen: " + count), StandardCharsets.UTF_8,
			        StandardOpenOption.WRITE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ReportRepository getInstance() {
		return INSTANCE;
	}

}
