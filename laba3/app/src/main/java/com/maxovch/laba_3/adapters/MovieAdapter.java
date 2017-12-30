package com.maxovch.laba_3.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxovch.laba_3.Movie;
import com.maxovch.laba_3.OnMovieClickListener;
import com.maxovch.laba_3.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<Movie> movies;
    private OnMovieClickListener clickListener;

    public MovieAdapter(ArrayList<Movie> movies, OnMovieClickListener clickListener) {
        this.movies = movies;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Movie movie = movies.get(position);

        holder.poster.setImageResource(movie.getPoster());
        holder.name.setText(movie.getName());
        holder.genre.setText(movie.getGenre());

        holder.setOnClickListener(movie.getPoster(), movie.getName(), movie.getCountry(),
                movie.getRating(), movie.getDescription());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageview_poster)
        ImageView poster;
        @BindView(R.id.textview_title)
        TextView name;
        @BindView(R.id.textview_genre)
        TextView genre;

        private View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            ButterKnife.bind(this, view);
        }

        public void setOnClickListener(final int poster, final String name, final String country,
                                       final double rating, final String description) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(poster, name, country, rating, description);
                }
            });
        }
    }
}
