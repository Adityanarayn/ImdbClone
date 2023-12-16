package RatingsApp2.RatingApplication.controller;

import RatingsApp2.RatingApplication.model.Rating;
import RatingsApp2.RatingApplication.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @GetMapping("/name")
    public List<Rating> byNameController(@Param("name") String name){
        return ratingService.byName(name);

    }

    @GetMapping("/director")
    public List<Rating> byDirectorController(@Param("director") String director){
        return ratingService.byDirector(director);

    }

    @GetMapping("/year")
    public List<Rating> byYearController(@Param("year")int year){
        return  ratingService.byYear(year);

    }

    @GetMapping("/rating")
    public List<Rating> byRatingController(@Param("rating") Double rating){
        return ratingService.byRating(rating);

    }
    @GetMapping("/rating/less-than")
    public List<Rating> byRatingLessThanController(@Param("rating") Double rating){
        return ratingService.byRatingLessThan(rating);

    }
    @GetMapping("/rating/greater-than")
    public List<Rating> byRatingGreaterThanController(@Param("rating") Double rating){
        return ratingService.byRatingGreaterThan(rating);

    }




}
