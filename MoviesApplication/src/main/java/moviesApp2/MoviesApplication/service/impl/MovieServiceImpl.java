package moviesApp2.MoviesApplication.service.impl;

import moviesApp2.MoviesApplication.model.Movie;
import moviesApp2.MoviesApplication.repository.MoviesRepo;
import moviesApp2.MoviesApplication.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MoviesService {

    @Autowired
    MoviesRepo moviesRepo;

    public List<Movie> byNameService(String name){
        return moviesRepo.findByNameContaining(name);
    }


    public List<Movie> byCastService(String cast) {
        return moviesRepo.findByCastContaining(cast);
    }

    public List<Movie> byDirectorService(String director) {

        return moviesRepo.findByDirectorContaining(director);
    }

    public List<Movie> byBudgetService(Long budget) {


            return moviesRepo.findByBudgetGreaterThanEqual(budget);



    }
@Override
    public List<Movie> byGenreService(String genre) {
        return moviesRepo.findByGenreContaining(genre);
    }






}

