package RatingsApp2.RatingApplication.util;

import RatingsApp2.RatingApplication.model.Rating;
import RatingsApp2.RatingApplication.repository.RatingCrudRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
@Component
@Slf4j
public class InitializationUtility {

    @Autowired
    RatingCrudRepo ratingCrudRepo;
    @Autowired
    CsvToDatabaseService csvToDatabaseService;


    public boolean isDatabasePopulated() {
        List<Rating> ratingList = (List<Rating>) ratingCrudRepo.findAll();
        return !ratingList.isEmpty(); // true when the database is Populated

    }

    public void compareAndUpdateData(List<Rating> newRating, String filePath) {
        List<Rating> oldRating = (List<Rating>) ratingCrudRepo.findAll();
        if (oldRating.size() != newRating.size()) {
            ratingCrudRepo.deleteAll();
            csvToDatabaseService.csvToDBService(filePath);
            log.info("Saved the new database ");
            return;


        }

        for (Long i = 0L; i < oldRating.size(); i++) {
            Rating oldMovie1 = oldRating.get(Math.toIntExact(i));
            Rating newMovie1 = oldRating.get(Math.toIntExact(i));

            if (!Objects.equals(oldMovie1.getName(), newMovie1.getName())
                    || !Objects.equals(oldMovie1.getDirector(), newMovie1.getDirector())
                    || !Objects.equals(oldMovie1.getYear(), newMovie1.getYear())
                    || !Objects.equals(oldMovie1.getRating(), newMovie1.getRating())) {
                ratingCrudRepo.updateMovieById(i, newMovie1.getName(),
                        newMovie1.getDirector(),
                        newMovie1.getYear(),
                        newMovie1.getRating());
                log.info("Database has been updated");
                return;


            }
        }
    }
}
