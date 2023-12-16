package moviesApp2.MoviesApplication.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import moviesApp2.MoviesApplication.model.Movie;
import moviesApp2.MoviesApplication.repository.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

@Component
@Slf4j
public class CsvToDB {

    private final MoviesRepo moviesRepo;

    @Autowired
    public  CsvToDB(MoviesRepo moviesRepo){
        this.moviesRepo=moviesRepo;
    }
    public void uploadToDB(String filePath){
        String line ="";
        BufferedReader bufferedReader;
        try{
            bufferedReader= new BufferedReader(new FileReader(filePath));

            while ((line= bufferedReader.readLine())!=null){
                String[] s=line.split(",");
                Movie movie= new Movie();

                movie.setName(s[0]);
                movie.setCast(s[2]); // this might create problem with List op type
                movie.setGenre(s[1]);
                movie.setDirector(s[3]);
                movie.setBudget(Long.parseLong(s[4]));


                moviesRepo.save(movie);

            }
        }catch(IOException e){
            log.error("File Not Found");


        }
    }

    public List<Movie> listCSV(String filePath){

        String line ="";
        BufferedReader bufferedReader;
        try{
            bufferedReader= new BufferedReader(new FileReader(filePath));
            List<Movie> movieList=new ArrayList<>();

            while ((line= bufferedReader.readLine())!=null){
                String[] s=line.split(",");
                Movie movie= new Movie();

                movie.setName(s[0]);
                movie.setCast(s[2]); // this might create problem with List op type
                movie.setGenre(s[1]);
                movie.setDirector(s[3]);
                movie.setBudget(Long.parseLong(s[4]));


                movieList.add(movie);

            }
            return movieList;

        }catch(IOException e){
            log.error("File Not Found");


        }
        return null;

    }
}
