package com.example.peliculas.presenter;

import com.example.peliculas.beans.Movie;
import com.example.peliculas.model.IMovieModel;
import com.example.peliculas.model.MovieModel;
import com.example.peliculas.view.IMovieView;

import java.util.List;

public class MoviePresenter implements IMoviePresenter{

    private IMovieView view;
    private IMovieModel model;

    public MoviePresenter(IMovieView v) {
        this.view = v;
        this.model = new MovieModel(this);
    }

    @Override
    public void getMovies() {
        this.model.getMovies();
    }

    @Override
    public void onMovieSuccess(List<Movie> movies) {
        if (view == null)
            return;

        this.view.onMovieSuccess(movies);
    }

    @Override
    public void onMovieError(String msg) {
        if (view == null)
            return;

        this.view.onMovieError(msg);
    }
}
