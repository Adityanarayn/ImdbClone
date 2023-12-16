package RatingsApp2.RatingApplication.repository;

import RatingsApp2.RatingApplication.model.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingCrudRepo extends CrudRepository<Rating, Long> {
    @Query("SELECT r FROM Rating r WHERE r.rating= :rating")
    List<Rating> findByRatingValue(@Param("rating") Double rating);

    // write one more query to get the rating of the movie greater than the given rating

    @Query("SELECT r FROM Rating r WHERE r.director LIKE %:director%")
    List<Rating> findByDirector(@Param("director") String director); // the director should be able to find the director name even with the given keyword matchings

    @Query("SELECT r FROM Rating r WHERE r.name LIKE %:name%")
    List<Rating> findByNameValue(@Param("name") String name); // it should be more like contains the given name

    @Query("SELECT y FROM Rating y WHERE y.year= :year")
    List<Rating> findByYearValue(int year);

    List<Rating> findByRatingLessThanEqual(Double rating);

    List<Rating> findByRatingGreaterThanEqual(Double rating);
    @Query("UPDATE Rating r SET r.name = :name, r.director = :director, r.year = :year, r.rating = :rating WHERE r.id = :id")
    void updateMovieById(@Param("id") Long id,
                         @Param("name") String name,
                         @Param("director") String director,
                         @Param("year") int year,
                         @Param("rating") Double rating);

}
