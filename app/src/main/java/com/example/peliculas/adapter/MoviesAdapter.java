package com.example.peliculas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.peliculas.R;
import com.example.peliculas.beans.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>  {

    private List<Movie> mMovies;
    private Context context;

    public MoviesAdapter(List<Movie> mMovies) {
        this.mMovies = mMovies;
    }

    public void reloadData(List<Movie> movies) {
        this.mMovies = movies;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(this.context);

        View contactView = inflater.inflate(R.layout.item_movie, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.ViewHolder holder, int position) {
        Movie movie = mMovies.get(position);

        holder.mMovieTitle.setText(movie.getTitle());
        holder.mMovieYear.setText(movie.getYear());
        holder.mMovieRuntime.setText(movie.getRuntime());
        holder.mMovieGenres.setText(movie.toString());
        holder.mMovieDirector.setText(movie.getDirector());
        holder.mMovieActors.setText(movie.getActors());
        holder.mMoviePlot.setText(movie.getPlot());
        Glide.with(this.context).load(movie.getPosterUrl()).into(holder.mMoviePoster);

    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mMoviePoster;
        private TextView mMovieTitle;
        private TextView mMovieYear;
        private TextView mMovieRuntime;
        private TextView mMovieGenres;
        private TextView mMovieDirector;
        private TextView mMovieActors;
        private TextView mMoviePlot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mMoviePoster = itemView.findViewById(R.id.movie_posterUrl);
            mMovieTitle = itemView.findViewById(R.id.movie_title);
            mMovieYear = itemView.findViewById(R.id.movie_year);
            mMovieRuntime = itemView.findViewById(R.id.movie_runtime);
            mMovieGenres = itemView.findViewById(R.id.movie_genres);
            mMovieDirector = itemView.findViewById(R.id.movie_director);
            mMovieActors = itemView.findViewById(R.id.movie_actors);
            mMoviePlot = itemView.findViewById(R.id.movie_plot);

            // itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
