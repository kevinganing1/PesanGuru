package com.example.tugasakhirpab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuUtama extends AppCompatActivity {
    Spinner spinner1, spinner2, spinner3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);

        String[] value = {"Sekolah Menengah Pertama", "Sekolah Menengah Akhir"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.style_spinner_utama,arrayList);
        spinner1.setAdapter(arrayAdapter);

        String[] value2 = {"1", "2", "3"};
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList(value2));
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this,R.layout.style_spinner_utama,arrayList2);
        spinner2.setAdapter(arrayAdapter2);

        String[] value3 = {"IPA", "Matematika", "IPS"};
        ArrayList<String> arrayList3 = new ArrayList<>(Arrays.asList(value3));
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<>(this,R.layout.style_spinner_utama,arrayList3);
        spinner3.setAdapter(arrayAdapter3);


    }
}