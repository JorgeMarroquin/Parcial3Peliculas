package com.example.peliculas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
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

public class MainActivity extends AppCompatActivity implements IMovieView {

    private IMoviePresenter moviePresenter;
    private MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.moviePresenter = new MoviePresenter(this);
        this.moviePresenter.getMovies();

        RecyclerView rvMovies = (RecyclerView) findViewById(R.id.list_movies);
        this.adapter = new MoviesAdapter(new ArrayList<>());
        rvMovies.setAdapter(adapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));

        Button button = (Button) findViewById(R.id.extra_button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, ExtraActivity.class);
            startActivity(intent);
        });

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

}