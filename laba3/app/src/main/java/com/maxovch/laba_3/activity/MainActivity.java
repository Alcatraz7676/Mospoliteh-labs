package com.maxovch.laba_3.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.maxovch.laba_3.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String MY_PREFS = "prefs";

    @BindView(R.id.editText)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        String enteredPassword = editText.getText().toString();
        if (!enteredPassword.trim().equals("")) {
            SharedPreferences prefs = getSharedPreferences(MY_PREFS, MODE_PRIVATE);
            String password = prefs.getString("password", null);
            if (password != null) {
                if (enteredPassword.equals(password)) {
                    Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                            | Intent.FLAG_ACTIVITY_NEW_TASK
                            | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "НЕВЕРНЫЙ ПАРОЛЬ", Toast.LENGTH_LONG).show();
                }
            } else {
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();
                editor.putString("password", enteredPassword);
                editor.apply();
                Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                                | Intent.FLAG_ACTIVITY_NEW_TASK
                                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }
    }
}
