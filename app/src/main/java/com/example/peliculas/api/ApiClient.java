package com.example.peliculas.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;
    private static Retrofit bookRetrofit = null;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getBookInstance() {
        if (bookRetrofit == null) {
            bookRetrofit = new Retrofit.Builder()
                    .baseUrl("http://de-coding-test.s3.amazonaws.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return bookRetrofit;
    }
}