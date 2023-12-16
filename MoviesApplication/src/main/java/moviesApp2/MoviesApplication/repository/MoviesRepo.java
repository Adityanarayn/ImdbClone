package moviesApp2.MoviesApplication.repository;

import moviesApp2.MoviesApplication.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MoviesRepo extends CrudRepository<Movie,Long> {

    List<Movie> findByNameContaining(String name);

    List<Movie> findByCastContaining(String cast);

    List<Movie> findByDirectorContaining(String director);

    List<Movie> findByBudgetGreaterThanEqual(Long budget);

    List<Movie> findByGenreContaining(String genre);

    @Modifying
    @Query("UPDATE Movie m SET m.name = :name, m.cast = :cast, m.genre = :genre, m.director = :director, m.budget = :budget WHERE m.id = :id")
    void updateMovieById(@Param("id") Long id,
                         @Param("name") String name,
                         @Param("cast") String cast,
                         @Param("genre") String genre,
                         @Param("director") String director,
                         @Param("budget") Long budget);



}
