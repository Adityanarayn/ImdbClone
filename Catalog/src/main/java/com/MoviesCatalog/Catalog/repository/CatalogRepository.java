package com.MoviesCatalog.Catalog.repository;

import com.MoviesCatalog.Catalog.model.Catalog;
import com.MoviesCatalog.Catalog.model.Catalog;
import com.MoviesCatalog.Catalog.model.MoviesCatalog;
import lombok.ToString;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@ToString
public class CatalogRepository {



    public List<Catalog> moviesByTheDirectorRepo(String director){
        RestTemplate restTemplate= new RestTemplate();
        String movieUrl="http://localhost:8081/movies/director?director="+director;


        ResponseEntity<List<MoviesCatalog>> movieResponse=restTemplate.exchange(movieUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MoviesCatalog>>(){});
        List<MoviesCatalog> moviesCatalogList= movieResponse.getBody();
        List<Catalog> catalogList= new ArrayList<>();

        if (movieResponse.getStatusCode()==HttpStatus.OK){
            for (MoviesCatalog moviesCatalog: moviesCatalogList){
                Catalog catalog= new Catalog();
                catalog.setMoviesCatalog(moviesCatalog);

                String ratingUrl = "http://localhost:8080/ratings/name?name=" + moviesCatalog.getName();
                ResponseEntity<List<Catalog>> ratingResponse= restTemplate.exchange(ratingUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Catalog>>(){} );


                if (ratingResponse.getStatusCode()==HttpStatus.OK){
                    List<Catalog> ratingData=ratingResponse.getBody();

                    for (Catalog catalog1:ratingData){

                        catalog.setYear(catalog1.getYear());
                        catalog.setRating(catalog1.getRating());
                        catalog.setName(catalog1.getName());
                    }
                }
                catalogList.add(catalog);






            }

        }
        return catalogList;


    }
    public List<Catalog> moviesByTheNameRepo(String name){
        RestTemplate restTemplate= new RestTemplate();
        String movieUrl="http://localhost:8081/movies/name?name="+name;


        ResponseEntity<List<MoviesCatalog>> movieResponse=restTemplate.exchange(movieUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MoviesCatalog>>(){});
        List<MoviesCatalog> moviesCatalogList= movieResponse.getBody();
        List<Catalog> catalogList= new ArrayList<>();

        if (movieResponse.getStatusCode()==HttpStatus.OK){
            for (MoviesCatalog moviesCatalog: moviesCatalogList){
                Catalog catalog= new Catalog();
                catalog.setMoviesCatalog(moviesCatalog);

                String ratingUrl = "http://localhost:8080/ratings/name?name=" + name;
                ResponseEntity<List<Catalog>> ratingResponse= restTemplate.exchange(ratingUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Catalog>>(){} );


                if (ratingResponse.getStatusCode()==HttpStatus.OK){
                    List<Catalog> ratingData=ratingResponse.getBody();

                    for (Catalog catalog1:ratingData){

                        catalog.setYear(catalog1.getYear());
                        catalog.setRating(catalog1.getRating());
                        catalog.setName(catalog1.getName());
                    }
                }
                catalogList.add(catalog);






            }

        }
        return catalogList;


    }

    public List<Catalog> moviesByTheYearRepo(int year){
        RestTemplate restTemplate= new RestTemplate();
        String ratingUrl="http://localhost:8080/ratings/year?year="+year; // will give the response from rating aaplication


        ResponseEntity<List<Catalog>> ratingResponse=restTemplate.exchange(ratingUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Catalog>>(){});

        List<Catalog> catalogList= new ArrayList<>();

        if (ratingResponse.getStatusCode()==HttpStatus.OK){
            List<Catalog> ratingCatalogList= ratingResponse.getBody();
            for (Catalog ratingCatalog: ratingCatalogList){
                Catalog catalog= new Catalog();
                catalog.setYear(ratingCatalog.getYear());
                catalog.setRating(ratingCatalog.getRating());
                catalog.setName(ratingCatalog.getName());

                String movieUrl = "http://localhost:8081/movies/name?name=" + ratingCatalog.getName();
                ResponseEntity<List<MoviesCatalog>> movieResponse= restTemplate.exchange(movieUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<MoviesCatalog>>(){} );


                if (movieResponse.getStatusCode()==HttpStatus.OK){
                    List<MoviesCatalog> movieData=movieResponse.getBody();

                    for (MoviesCatalog catalog1:movieData){

                        catalog.setMoviesCatalog(catalog1);
                    }
                }
                catalogList.add(catalog);






            }

        }
        return catalogList;


    }

    public List<Catalog> moviesByTheRatingRepo(Double rating, String ratingUrl){   // add the rating url in the service layer
        RestTemplate restTemplate= new RestTemplate();
//        String ratingUrl="http://localhost:8080/movies/rating?rating="+rating; // will give the response from rating aaplication


        ResponseEntity<List<Catalog>> ratingResponse=restTemplate.exchange(ratingUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Catalog>>(){});

        List<Catalog> catalogList= new ArrayList<>();

        if (ratingResponse.getStatusCode()==HttpStatus.OK){
            List<Catalog> ratingCatalogList= ratingResponse.getBody();
            for (Catalog ratingCatalog: ratingCatalogList){
                Catalog catalog= new Catalog();
                catalog.setYear(ratingCatalog.getYear());
                catalog.setRating(ratingCatalog.getRating());
                catalog.setName(ratingCatalog.getName());

                String movieUrl = "http://localhost:8081/movies/name?name=" + ratingCatalog.getName();
                ResponseEntity<List<MoviesCatalog>> movieResponse= restTemplate.exchange(movieUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<MoviesCatalog>>(){} );


                if (movieResponse.getStatusCode()==HttpStatus.OK){
                    List<MoviesCatalog> movieData=movieResponse.getBody();

                    for (MoviesCatalog catalog1:movieData){

                        catalog.setMoviesCatalog(catalog1);
                    }
                }
                catalogList.add(catalog);






            }

        }
        return catalogList;


    }

    public List<Catalog> moviesByTheGenreRepo(String genre){
        RestTemplate restTemplate= new RestTemplate();
        String movieUrl="http://localhost:8081/movies/genre?genre="+genre;


        ResponseEntity<List<MoviesCatalog>> movieResponse=restTemplate.exchange(movieUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MoviesCatalog>>(){});
        List<MoviesCatalog> moviesCatalogList= movieResponse.getBody();
        List<Catalog> catalogList= new ArrayList<>();

        if (movieResponse.getStatusCode()==HttpStatus.OK){
            for (MoviesCatalog moviesCatalog: moviesCatalogList){
                Catalog catalog= new Catalog();
                catalog.setMoviesCatalog(moviesCatalog);

                String ratingUrl = "http://localhost:8080/ratings/name?name=" + moviesCatalog.getName();
                ResponseEntity<List<Catalog>> ratingResponse= restTemplate.exchange(ratingUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Catalog>>(){} );


                if (ratingResponse.getStatusCode()==HttpStatus.OK){
                    List<Catalog> ratingData=ratingResponse.getBody();

                    for (Catalog catalog1:ratingData){

                        catalog.setYear(catalog1.getYear());
                        catalog.setRating(catalog1.getRating());
                    }
                }
                catalogList.add(catalog);






            }

        }
        return catalogList;


    }

    public List<Catalog> moviesByTheCastRepo(String cast){
        RestTemplate restTemplate= new RestTemplate();
        String movieUrl="http://localhost:8081/movies/cast?cast="+cast;


        ResponseEntity<List<MoviesCatalog>> movieResponse=restTemplate.exchange(movieUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MoviesCatalog>>(){});
        List<MoviesCatalog> moviesCatalogList= movieResponse.getBody();
        List<Catalog> catalogList= new ArrayList<>();

        if (movieResponse.getStatusCode()==HttpStatus.OK){
            for (MoviesCatalog moviesCatalog: moviesCatalogList){
                Catalog catalog= new Catalog();
                catalog.setMoviesCatalog(moviesCatalog);

                String ratingUrl = "http://localhost:8080/ratings/name?name=" + moviesCatalog.getName();
                ResponseEntity<List<Catalog>> ratingResponse= restTemplate.exchange(ratingUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Catalog>>(){} );


                if (ratingResponse.getStatusCode()==HttpStatus.OK){
                    List<Catalog> ratingData=ratingResponse.getBody();

                    for (Catalog catalog1:ratingData){

                        catalog.setYear(catalog1.getYear());
                        catalog.setRating(catalog1.getRating());
                        catalog.setName(catalog1.getName());
                    }
                }
                catalogList.add(catalog);






            }

        }
        return catalogList;


    }





}
