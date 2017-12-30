package com.maxovch.laba_3.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.maxovch.laba_3.adapters.MovieAdapter;
import com.maxovch.laba_3.Movies;
import com.maxovch.laba_3.OnMovieClickListener;
import com.maxovch.laba_3.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesActivity extends AppCompatActivity implements OnMovieClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        MovieAdapter adapter;

        if (getIntent().getExtras() == null) {
            adapter = new MovieAdapter(Movies.getAllMovies(), this);
        } else {
            switch (getIntent().getIntExtra("GENRE", 0)) {
                case 0:
                    adapter = new MovieAdapter(Movies.getComedyMovies(), this);
                    break;
                case 1:
                    adapter = new MovieAdapter(Movies.getDramaMovies(), this);
                    break;
                case 2:
                    adapter = new MovieAdapter(Movies.getCartoons(), this);
                    break;
                default:
                    adapter = new MovieAdapter(Movies.getComedyMovies(), this);
            }
        }
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.about:
                intent = new Intent(this, AboutActivity.class);
                break;
            case R.id.genres:
                intent = new Intent(this, GenresActivity.class);
                break;
            case R.id.exit:
                SharedPreferences.Editor editor = getSharedPreferences(MainActivity.MY_PREFS, MODE_PRIVATE).edit();
                editor.putString("password", null);
                editor.apply();
                intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        startActivity(intent);
        return true;
    }

    @Override
    public void onItemClick(int poster, String name, String country, double rating, String description) {
        Intent intent = new Intent(this, DetailMovieActivity.class);
        intent.putExtra("POSTER", poster);
        intent.putExtra("NAME", name);
        intent.putExtra("COUNTRY", country);
        intent.putExtra("RATING", rating);
        intent.putExtra("DESCRIPTION", description);
        startActivity(intent);
    }
}
