package com.MoviesCatalog.Catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Catalog{
    private String name ;
    private String rating;
    private int year;
    private MoviesCatalog moviesCatalog;
}
