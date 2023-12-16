package moviesApp2.MoviesApplication.util;

import lombok.extern.slf4j.Slf4j;
import moviesApp2.MoviesApplication.model.Movie;
import moviesApp2.MoviesApplication.repository.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class DatabaseInitialization {
    @Autowired
    MoviesRepo moviesRepo;
    @Autowired
    CsvToDB csvToDB;

    public boolean isDatabasePopulated(){
        List<Movie> movieList= (List<Movie>) moviesRepo.findAll();
        return !movieList.isEmpty(); // this will return true if the is populated

    }
    // after this if the database is populated we need to check that the pre-existing database is same or different

    public void compareAndUpdateData(List<Movie> newMovie, String filePath){
        List<Movie> oldMovie=(List<Movie>) moviesRepo.findAll();
        if (newMovie.size()!= oldMovie.size()){
            moviesRepo.deleteAll();
            csvToDB.uploadToDB(filePath);
            log.info("Saved the new database ");
            return;


        }

        for (Long i = 0L; i<oldMovie.size(); i++){
            Movie oldMovie1=oldMovie.get(Math.toIntExact(i));
            Movie newMovie1=newMovie.get(Math.toIntExact(i));

            if (!Objects.equals(oldMovie1.getName(), newMovie1.getName())
            || !Objects.equals(oldMovie1.getCast(), newMovie1.getCast())
            || !Objects.equals(oldMovie1.getBudget(), newMovie1.getBudget())
            || !Objects.equals(oldMovie1.getGenre(), newMovie1.getGenre())
            || !Objects.equals(oldMovie1.getDirector(), newMovie1.getDirector())){
                moviesRepo.updateMovieById(i,
                        newMovie1.getName(),
                        newMovie1.getCast(),
                        newMovie1.getGenre(),
                        newMovie1.getDirector(),
                        newMovie1.getBudget());
                log.info("Database has been updated");
                return;


            }
        }



    }
}
