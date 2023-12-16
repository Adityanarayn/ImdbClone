package RatingsApp2.RatingApplication.service;

import RatingsApp2.RatingApplication.model.Rating;

import java.util.List;

public interface RatingService {

     List<Rating> byRating(Double rating);

     List<Rating> byDirector(String director);

      List<Rating> byYear(int year);

      List<Rating> byName(String name);

    List<Rating> byRatingLessThan(Double rating);
    List<Rating> byRatingGreaterThan(Double rating);

}
