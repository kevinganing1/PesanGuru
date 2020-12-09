package com.example.tugasakhirpab.pengguna;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tugasakhirpab.R;
import com.example.tugasakhirpab.model.Pengguna;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtName, edtPhone, edtAddress, edtJadwal;
    private Button btnUpdate;

    public static final String EXTRA_PENGGUNA = "extra_pengguna";
    public final int ALERT_DIALOG_CLOSE = 10;
    public final int ALERT_DIALOG_DELETE = 20;

    private Pengguna pengguna;
    private String penggunaId;

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        edtName = findViewById(R.id.edtEditName);
        edtPhone = findViewById(R.id.edtEditPhone);
        edtAddress = findViewById(R.id.edtEditAddress);
        edtJadwal = findViewById(R.id.edtEditJadwal);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(this);

        pengguna = getIntent().getParcelableExtra(EXTRA_PENGGUNA);

        if (pengguna != null) {
            penggunaId = pengguna.getId();
        } else {
            pengguna = new Pengguna();
        }

        if (pengguna != null) {
            edtName.setText(pengguna.getName());
            edtPhone.setText(pengguna.getPhone());
            edtAddress.setText(pengguna.getAddress());
            edtJadwal.setText(pengguna.getJadwal());
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Ubah Pesanan");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnUpdate) {
            updatePengguna();
        }
    }

    private void updatePengguna() {
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

        if (! isEmptyFields) {

            Toast.makeText(UpdateActivity.this, "Updating Data...", Toast.LENGTH_SHORT).show();

            pengguna.setName(name);
            pengguna.setPhone(phone);
            pengguna.setAddress(address);
            pengguna.setJadwal(jadwal);

            DatabaseReference dbPengguna = mDatabase.child("pengguna");

            //update data
            dbPengguna.child(penggunaId).setValue(pengguna);

            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_form, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //pilih menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                showAlertDialog(ALERT_DIALOG_DELETE);
                break;
            case android.R.id.home:
                showAlertDialog(ALERT_DIALOG_CLOSE);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        showAlertDialog(ALERT_DIALOG_CLOSE);
    }

    private void showAlertDialog(int type) {
        final boolean isDialogClose = type == ALERT_DIALOG_CLOSE;
        String dialogTitle, dialogMessage;

        if (isDialogClose) {
            dialogTitle = "Kembali";
            dialogMessage = "Apakah anda ingin membatalkan perubahan?";
        } else {
            dialogTitle = "Batalkan Pesanan";
            dialogMessage = "Apakah anda yakin ingin membatalkan pesanan ini?";
        }

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle(dialogTitle);
        alertDialogBuilder.setMessage(dialogMessage)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (isDialogClose) {
                            finish();
                        } else {
                            //kode hapus data masuk disini
                            if (isDialogClose) {
                                finish();
                            } else {
                                //hapus data
                                DatabaseReference dbPengguna =
                                        mDatabase.child("pengguna").child(penggunaId);

                                dbPengguna.removeValue();

                                Toast.makeText(UpdateActivity.this, "Deleting data...",
                                        Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}