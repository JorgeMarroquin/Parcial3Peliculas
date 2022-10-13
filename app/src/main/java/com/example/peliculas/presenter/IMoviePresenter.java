package com.example.peliculas.presenter;

import com.example.peliculas.beans.Movie;

import java.util.List;

public interface IMoviePresenter {
    void onMovieSuccess(List<Movie> movie);
    void onMovieError(String msg);
}
