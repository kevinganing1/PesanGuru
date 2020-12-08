package com.example.tugasakhirpab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;


import java.util.ArrayList;
import java.util.Arrays;

public class MenuUtama extends AppCompatActivity  {

    Spinner spinner1, spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_menu_utama);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Spinner_items2,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);


    }


    public void TampilkanGuru(View view) {
        startActivity(new Intent(MenuUtama.this, TampilkanGuru.class));
    }

    public void TampilkanGuruu(MenuItem item) {
        startActivity(new Intent(MenuUtama.this, KeranjangPesanan.class));
    }
}