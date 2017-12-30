package com.maxovch.laba_3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.maxovch.laba_3.adapters.GenresAdapter;
import com.maxovch.laba_3.OnGenreClickListener;
import com.maxovch.laba_3.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GenresActivity extends AppCompatActivity implements OnGenreClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        GenresAdapter adapter = new GenresAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int genreId) {
        Intent intent = new Intent(this, MoviesActivity.class);
        switch (genreId) {
            case 0:
                intent.putExtra("GENRE", 0);
                break;
            case 1:
                intent.putExtra("GENRE", 1);
                break;
            case 2:
                intent.putExtra("GENRE", 2);
                break;
        }
        startActivity(intent);
    }
}
