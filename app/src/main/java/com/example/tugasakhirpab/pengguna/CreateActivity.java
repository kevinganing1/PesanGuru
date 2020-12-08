package com.example.tugasakhirpab.pengguna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tugasakhirpab.R;
import com.example.tugasakhirpab.model.Pengguna;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtName, edtPhone, edtAddress, edtJadwal;
    private Button btnSave;

    private Pengguna pengguna;

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtAddress = findViewById(R.id.edtAddress);
        edtJadwal = findViewById(R.id.edtJadwal);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(this);

        pengguna = new Pengguna();
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnSave) {
            savePengguna();
        }

    }

    private void savePengguna() {
        String name = edtName.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();
        String address = edtAddress.getText().toString().trim();
        String jadwal = edtJadwal.getText().toString().trim();

        boolean isEmptyFields = false;

        if (TextUtils.isEmpty(name)) {
            isEmptyFields = true;
            edtName.setError("Field ini tidak boleh kosong");
        }

        if (TextUtils.isEmpty(phone)) {
            isEmptyFields = true;
            edtPhone.setError("Field ini tidak boleh kosong");
        }

        if (TextUtils.isEmpty(address)) {
            isEmptyFields = true;
            edtAddress.setError("Field ini tidak boleh kosong");
        }

        if (TextUtils.isEmpty(jadwal)) {
            isEmptyFields = true;
            edtJadwal.setError("Field ini tidak boleh kosong");
        }

        if (!isEmptyFields) {

            Toast.makeText(CreateActivity.this, "Saving Data...", Toast.LENGTH_SHORT).show();

            DatabaseReference dbPengguna = mDatabase.child("pengguna");

            String id = dbPengguna.push().getKey();
            pengguna.setId(id);
            pengguna.setName(name);
            pengguna.setPhone(phone);
            pengguna.setAddress(address);
            pengguna.setJadwal(jadwal);

            //insert data
            dbPengguna.child(id).setValue(pengguna);

            finish();

        }
    }
}