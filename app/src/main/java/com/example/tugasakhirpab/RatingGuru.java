package com.example.tugasakhirpab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatingGuru extends AppCompatActivity {
    RatingBar ratingBar;
    Button btSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_guru);

        ratingBar = findViewById(R.id.rb_ratingBar);
        btSubmit = findViewById(R.id.button);

    }

    public void OnButtonClickListiner() {
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RatingGuru.this,
                        String.valueOf(ratingBar.getRating()),
                Toast.LENGTH_SHORT).show();
            }
        });
    }
}