package com.example.peliculas.api;

import com.example.peliculas.beans.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApi {

        @GET("erik-sytnyk/movies-list/master/db.json")
        Call<List<Movie>> getMovies();

}
