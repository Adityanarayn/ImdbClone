package com.MoviesCatalog.Catalog.controller;

import com.MoviesCatalog.Catalog.model.Catalog;
import com.MoviesCatalog.Catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CatalogController {
    @Autowired
    CatalogService catalogService;
//    @GetMapping("/byName")
//    public Catalog getByNameController(@RequestParam String name){
//        return catalogService.nameService(name);
//    }
//    @GetMapping("/byYear")
//    public Catalog getByYearController(@RequestParam String year){
//        return catalogService.yearService(year);
//    }
    @GetMapping("/byDirector")
    public List<Catalog> getByDirectorController(String director){
        return catalogService.directorService(director);

    }

    @GetMapping("/byName")
    public List<Catalog> getByNameController(String name){
        return catalogService.nameService(name);

    }
    @GetMapping("/byYear")
    public List<Catalog> getByYearController(int year){
        return catalogService.yearService(year);

    }

    @GetMapping("/byGenre")
    public List<Catalog> getByGenreController(String genre){
        return catalogService.genreService(genre);

    }
    @GetMapping("/byCast")
    public List<Catalog> getByCastController(String cast){
        return catalogService.castService(cast);

    }
    @GetMapping("/byRating")
    public List<Catalog> getByRatingController(Double rating){

        String url="http://localhost:8080/ratings/rating?rating="+rating;
        return catalogService.ratingService(rating,url);

    }
    @GetMapping("/byRating/less-than")
    public List<Catalog> getByRatingLessController(Double rating){

        String url="http://localhost:8080/ratings/rating/less-than?rating="+rating;
        return catalogService.ratingService(rating,url);

    }
    @GetMapping("/byRating/greater-than")
    public List<Catalog> getByRatingGreaterController(Double rating){

        String url="http://localhost:8080/ratings/rating/greater-than?rating="+rating;
        return catalogService.ratingService(rating,url);

    }
}
