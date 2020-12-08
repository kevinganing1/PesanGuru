package com.example.tugasakhirpab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tugasakhirpab.adapter.PenggunaAdapter;
import com.example.tugasakhirpab.pengguna.CreateActivity;
import com.example.tugasakhirpab.pengguna.UpdateActivity;
import com.example.tugasakhirpab.model.Pengguna;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class KeranjangPesanan extends AppCompatActivity implements View.OnClickListener{

    private ListView listView;
    private Button btnAdd;

    private PenggunaAdapter adapter;
    private ArrayList<Pengguna> penggunaList;
    DatabaseReference dbPengguna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang_pesanan);

        dbPengguna = FirebaseDatabase.getInstance().getReference("pengguna");

        listView = findViewById(R.id.lvList);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        penggunaList = new ArrayList<>();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(KeranjangPesanan.this, UpdateActivity.class);
                intent.putExtra(UpdateActivity.EXTRA_PENGGUNA, penggunaList.get(i));

                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd) {
            Intent intent = new Intent(KeranjangPesanan.this, CreateActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        dbPengguna.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                penggunaList.clear();

                for (DataSnapshot penggunaSnapshot : dataSnapshot.getChildren()) {
                    Pengguna pengguna = penggunaSnapshot.getValue(Pengguna.class);
                    penggunaList.add(pengguna);
                }

                PenggunaAdapter adapter = new PenggunaAdapter(KeranjangPesanan.this);
                adapter.setPenggunaList(penggunaList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(KeranjangPesanan.this, "Terjadi kesalahan.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}