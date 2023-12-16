package RatingsApp2.RatingApplication.util;

import RatingsApp2.RatingApplication.model.Rating;
import RatingsApp2.RatingApplication.repository.RatingCrudRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CsvToDatabaseService {
    private final RatingCrudRepo ratingCrudRepo;
    @Autowired
    public CsvToDatabaseService (RatingCrudRepo ratingCrudRepo){
        this.ratingCrudRepo=ratingCrudRepo;

    }

    public void csvToDBService(String filePath) {
        String line ="";
        BufferedReader bufferedReader;
        try{
            bufferedReader= new BufferedReader(new FileReader(filePath));
            while ((line= bufferedReader.readLine())!=null){
                String[] s=line.split(",");
                Rating rating= new Rating();
                rating.setName(s[0]);
                rating.setYear(Integer.parseInt(s[1]));
                rating.setDirector(s[2]);
                rating.setRating(Double.parseDouble(s[3]));

                ratingCrudRepo.save(rating);

            }

            }catch(IOException exception){
                log.error ("file not found ",exception);


        }
    }

    public List<Rating> newFile(String filePath) {
        String line ="";
        List<Rating> ratings=new ArrayList<>();

        BufferedReader bufferedReader;
        try{
            bufferedReader= new BufferedReader(new FileReader(filePath));
            while ((line= bufferedReader.readLine())!=null){
                String[] s=line.split(",");
                Rating rating= new Rating();
                rating.setName(s[0]);
                rating.setYear(Integer.parseInt(s[1]));
                rating.setDirector(s[2]);
                rating.setRating(Double.parseDouble(s[3]));

                ratings.add(rating);


            }
            return ratings;

        }catch(IOException exception){
            log.error ("file not found ",exception);


        }
        return null;

    }





}
