package com.example.peliculas.model;

import com.example.peliculas.api.ApiClient;
import com.example.peliculas.api.BooksApi;
import com.example.peliculas.beans.Book;
import com.example.peliculas.presenter.IBookPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookModel implements IBookModel {

    private IBookPresenter presenter;
    private BooksApi api;

    public BookModel(IBookPresenter presenter) {
        this.presenter = presenter;
        api = ApiClient.getBookInstance().create(BooksApi.class);
    }

    @Override
    public void getBooks() {
        Call<List<Book>> bookCall = api.getBooks();
        bookCall.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                presenter.onBooksSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                presenter.onBooksError("Error el obtener los libros");
            }
        });
    }
}
