package com.example.peliculas.model;

import android.util.Log;

import com.example.peliculas.api.ApiClient;
import com.example.peliculas.api.MoviesApi;
import com.example.peliculas.beans.GenresAndMovies;
import com.example.peliculas.beans.Movie;
import com.example.peliculas.presenter.IMoviePresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieModel implements IMovieModel{

    private IMoviePresenter presenter;
    private MoviesApi api;

    public MovieModel(IMoviePresenter presenter) {
        this.presenter = presenter;
        api = ApiClient.getInstance().create(MoviesApi.class);
    }

    @Override
    public void getMovies() {
        Call<GenresAndMovies> bookCall = api.getMovies();
        bookCall.enqueue(new Callback<GenresAndMovies>() {
            @Override
            public void onResponse(Call<GenresAndMovies> call, Response<GenresAndMovies> response) {
                GenresAndMovies temp = response.body();
                presenter.onMovieSuccess(temp.getMovies());
            }

            @Override
            public void onFailure(Call<GenresAndMovies> call, Throwable t) {
                presenter.onMovieError("Error el obtener peliculas");
            }
        });
    }
}
