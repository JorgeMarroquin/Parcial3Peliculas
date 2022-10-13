package com.example.peliculas.view;

import com.example.peliculas.beans.Movie;

import java.util.List;

public interface IMovieView {
    void onMovieSuccess(List<Movie> movie);
    void onMovieError(String msg);
}
