package com.MoviesCatalog.Catalog.service;

import com.MoviesCatalog.Catalog.model.Catalog;
import com.MoviesCatalog.Catalog.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CatalogService {
    @Autowired
    CatalogRepository catalogRepository;


    public List<Catalog> directorService(String director){
        return catalogRepository.moviesByTheDirectorRepo(director);

    }

    public List<Catalog> nameService(String name){
        return catalogRepository.moviesByTheNameRepo(name);

    }

    public List<Catalog> ratingService(Double rating,String url){
        return catalogRepository.moviesByTheRatingRepo(rating,url);

    }
    public List<Catalog> castService(String cast){
        return catalogRepository.moviesByTheCastRepo(cast);

    }

    public List<Catalog> yearService(int year){
        return catalogRepository.moviesByTheYearRepo(year);

    }
    public List<Catalog> genreService(String genre){
        return catalogRepository.moviesByTheGenreRepo(genre);

    }
}
