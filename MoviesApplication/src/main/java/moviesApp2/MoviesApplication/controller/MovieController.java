package moviesApp2.MoviesApplication.controller;

import moviesApp2.MoviesApplication.model.Movie;
import moviesApp2.MoviesApplication.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MoviesService moviesService;


    @GetMapping("/name")
    public List<Movie> byNameController(@Param("name") String name){
        return moviesService.byNameService(name);

    }

    @GetMapping("/cast")
    public List<Movie> byCastController(@Param("cast") String cast){
        return moviesService.byCastService(cast);


    }
    @GetMapping("/director")
    public List<Movie> byDirectorController(@Param("director") String director){
        return moviesService.byDirectorService(director);

    }

    @GetMapping("/budget")
    public List<Movie> byBudgetController(@Param("budget") Long budget){
        return moviesService.byBudgetService(budget);



    }

    @GetMapping("/genre")
    public List<Movie> byGenreController(@Param("genre") String genre){
        return moviesService.byGenreService(genre);

    }


}
