package RatingsApp2.RatingApplication.service.impl;

import RatingsApp2.RatingApplication.model.Rating;
import RatingsApp2.RatingApplication.repository.RatingCrudRepo;
import RatingsApp2.RatingApplication.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingCrudRepo ratingCrudRepo;

    @Override
    public List<Rating> byRating(Double rating) {
        return ratingCrudRepo.findByRatingValue(rating);

    }

    public List<Rating> byDirector(String director ){
        return ratingCrudRepo.findByDirector(director);
    }

    public List<Rating> byName(String name){
        return ratingCrudRepo.findByNameValue(name);
    }

    @Override
    public List<Rating> byYear(int year) {
        return ratingCrudRepo.findByYearValue(year);
    }

    @Override
    public List<Rating> byRatingLessThan(Double rating) {
        return ratingCrudRepo.findByRatingLessThanEqual(rating);

    }
    @Override
    public List<Rating> byRatingGreaterThan(Double rating) {
        return ratingCrudRepo.findByRatingGreaterThanEqual(rating);

    }
}
