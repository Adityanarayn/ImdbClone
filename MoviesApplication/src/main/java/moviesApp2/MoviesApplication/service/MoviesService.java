package moviesApp2.MoviesApplication.service;

import moviesApp2.MoviesApplication.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MoviesService {

    List<Movie> byNameService(String name);

   List<Movie> byCastService(String cast);// be careful it can throw an error here


    List<Movie> byDirectorService(String director);

    List<Movie> byBudgetService(Long budget); // problem in budget since its comparing it to a string

    List<Movie> byGenreService(String genre);



}
