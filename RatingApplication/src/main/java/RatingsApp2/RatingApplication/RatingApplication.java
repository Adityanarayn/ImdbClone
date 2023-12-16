package RatingsApp2.RatingApplication;

import RatingsApp2.RatingApplication.model.Rating;
import RatingsApp2.RatingApplication.util.CsvToDatabaseService;
import RatingsApp2.RatingApplication.util.InitializationUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class RatingApplication implements CommandLineRunner {

	@Autowired
	private CsvToDatabaseService csvToDatabaseService;
	@Autowired
	private InitializationUtility utility;


	public static void main(String[] args) {
		SpringApplication.run(RatingApplication.class, args);
	}

	@Override
	public void run(String... args) {

		String filePath = "/Users/adityanarayan/Downloads/RatingApplication/src/main/java/RatingsApp2/RatingApplication/repository/Book2.csv";
		if (!utility.isDatabasePopulated()) {
			try {
				csvToDatabaseService.csvToDBService(filePath);
				log.info("CSV data loaded into the database successfully!");
			}catch (Exception ex) {
				log.error("Failed to load CSV data into the database ");
			}
		} else {
			try {
				List<Rating> newRating = csvToDatabaseService.newFile(filePath);
				utility.compareAndUpdateData(newRating, filePath);
			} catch (Exception e) {
				log.error("Database cannot be updated ");
			}

		}
	}
}
