package moviesApp2.MoviesApplication;

import lombok.extern.slf4j.Slf4j;
import moviesApp2.MoviesApplication.model.Movie;
import moviesApp2.MoviesApplication.util.CsvToDB;
import moviesApp2.MoviesApplication.util.DatabaseInitialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class MoviesApplication implements CommandLineRunner {

@Autowired
private CsvToDB csvToDB; // why is this private ?

@Autowired
private DatabaseInitialization  databaseInitialization;



	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}
@Override
	public void run(String... args) throws Exception{
		String filePath= "/Users/adityanarayan/Downloads/MoviesApplication/src/main/java/moviesApp2/MoviesApplication/util/data2.csv";
		if (!databaseInitialization.isDatabasePopulated()){
			try{
				csvToDB.uploadToDB(filePath);
				log.info("The Database file has been uploaded ");

			}catch(Exception e){
				log.error("The file cannot be uploaded to the database ",e);
			}
		}
		else {
			List<Movie> newMovie= csvToDB.listCSV(filePath);
			try{
				databaseInitialization.compareAndUpdateData(newMovie,filePath);
				log.info("Database exists");
			}catch (Exception exception){
				log.error("The database Cannot be Updated");
			}
		}

}


}
