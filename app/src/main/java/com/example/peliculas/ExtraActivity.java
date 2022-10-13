package com.example.peliculas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.peliculas.adapter.BooksAdapter;
import com.example.peliculas.adapter.MoviesAdapter;
import com.example.peliculas.beans.Book;
import com.example.peliculas.beans.Movie;
import com.example.peliculas.presenter.BookPresenter;
import com.example.peliculas.presenter.IBookPresenter;
import com.example.peliculas.presenter.IMoviePresenter;
import com.example.peliculas.presenter.MoviePresenter;
import com.example.peliculas.view.IBookView;
import com.example.peliculas.view.IMovieView;

import java.util.ArrayList;
import java.util.List;

public class ExtraActivity extends AppCompatActivity implements IMovieView, IBookView {

    private IMoviePresenter moviePresenter;
    private IBookPresenter bookPresenter;
    private MoviesAdapter adapter;
    private BooksAdapter booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);
        this.moviePresenter = new MoviePresenter(this);
        this.moviePresenter.getMovies();

        RecyclerView rvMovies = (RecyclerView) findViewById(R.id.list_movies_Extra);
        this.adapter = new MoviesAdapter(new ArrayList<>());
        rvMovies.setAdapter(adapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));

        this.bookPresenter = new BookPresenter(this);
        this.bookPresenter.getBooks();

        RecyclerView rvBooks = (RecyclerView) findViewById(R.id.list_books_Extra);
        this.booksAdapter = new BooksAdapter(new ArrayList<>());
        rvBooks.setAdapter(booksAdapter);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onMovieSuccess(@NonNull List<Movie> movies) {
        adapter.reloadData(movies);
    }

    @Override
    public void onMovieError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onBookSuccess(List<Book> books) {
        booksAdapter.reloadData(books);
    }

    @Override
    public void onBookError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG)
                .show();
    }
}