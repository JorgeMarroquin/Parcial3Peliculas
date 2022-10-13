package com.example.peliculas.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GenresAndMovies {

    @SerializedName("genres")
    public List<String> genres;
    @SerializedName("movies")
    public List<Movie> movies;

    public GenresAndMovies(List<String> genres, List<Movie> movies) {
        this.genres = genres;
        this.movies = movies;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
