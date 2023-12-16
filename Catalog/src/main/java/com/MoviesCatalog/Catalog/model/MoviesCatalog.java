package com.MoviesCatalog.Catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class MoviesCatalog {
    private String name;

    private String cast;
    private String genre;

    private String director;
    private String budget;

}
