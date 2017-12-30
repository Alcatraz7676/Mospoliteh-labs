package com.maxovch.laba_3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxovch.laba_3.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailMovieActivity extends AppCompatActivity {

    @BindView(R.id.imageview_poster)
    ImageView imageviewPoster;
    @BindView(R.id.textview_title)
    TextView textviewTitle;
    @BindView(R.id.textview_country)
    TextView textviewCountry;
    @BindView(R.id.textview_rating)
    TextView textviewRating;
    @BindView(R.id.textview_desc)
    TextView textviewDesc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        imageviewPoster.setImageResource(intent.getIntExtra("POSTER", 0));
        textviewTitle.setText(intent.getStringExtra("NAME"));
        textviewCountry.setText(intent.getStringExtra("COUNTRY"));
        textviewRating.setText(String.valueOf(intent.getDoubleExtra("RATING", 5)));
        textviewDesc.setText(intent.getStringExtra("DESCRIPTION"));
    }
}
