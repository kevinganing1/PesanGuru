package com.example.tugasakhirpab;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tugasakhirpab.pengguna.CreateActivity;

public class TampilGuruBayar extends AppCompatActivity {

    ImageView imageView;
    TextView title, description;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_guru_bayar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);

            imageView = findViewById(R.id.another_imageView);
            title = findViewById(R.id.titleText);
            description = findViewById(R.id.descriptionText);
            if (position == 0) {
                Intent intent = getIntent();

                Bundle bundle = this.getIntent().getExtras();
                int pic = bundle.getInt("image");
                String aTitle = intent.getStringExtra("title");
                String aDescription = intent.getStringExtra("description");

                imageView.setImageResource(pic);
                title.setText(aTitle);
                description.setText(aDescription);

                actionBar.setTitle(aTitle);
            }

            if (position == 1) {
                Intent intent = getIntent();

                Bundle bundle = this.getIntent().getExtras();
                int pic = bundle.getInt("image");
                String aTitle = intent.getStringExtra("title");
                String aDescription = intent.getStringExtra("description");

                imageView.setImageResource(pic);
                title.setText(aTitle);
                description.setText(aDescription);

                actionBar.setTitle(aTitle);
            }

            if (position == 2) {
                Intent intent = getIntent();

                Bundle bundle = this.getIntent().getExtras();
                int pic = bundle.getInt("image");
                String aTitle = intent.getStringExtra("title");
                String aDescription = intent.getStringExtra("description");

                imageView.setImageResource(pic);
                title.setText(aTitle);
                description.setText(aDescription);

                actionBar.setTitle(aTitle);
            }

            if (position == 3) {
                Intent intent = getIntent();

                Bundle bundle = this.getIntent().getExtras();
                int pic = bundle.getInt("image");
                String aTitle = intent.getStringExtra("title");
                String aDescription = intent.getStringExtra("description");

                imageView.setImageResource(pic);
                title.setText(aTitle);
                description.setText(aDescription);

                actionBar.setTitle(aTitle);
            }

        }
    }

    public void PindahBiodata(View view) {
        startActivity(new Intent(TampilGuruBayar.this, CreateActivity.class));
    }
}