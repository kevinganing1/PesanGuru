package com.example.tugasakhirpab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TampilkanGuru extends AppCompatActivity {

    ListView listView;
    String mTitle[]={"Roy", "kevin", "Ricky", "Cantika"};
    String mDeskripsi[]={"test","test","test","test"};
    int image[]= {R.drawable.jum,R.drawable.haji,R.drawable.ricky,R.drawable.guru};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilkan_guru);
        listView =findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDeskripsi, image);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent intent = new Intent(getApplicationContext(), TampilGuruBayar.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", image[0]);
                    intent.putExtras(bundle);
                    intent.putExtra("title", mTitle[0]);
                    intent.putExtra("description", mDeskripsi[0]);
                    intent.putExtra("position", ""+0);
                    startActivity(intent);
                }
                if (position ==  1) {
                    Intent intent = new Intent(getApplicationContext(), TampilGuruBayar.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", image[1]);
                    intent.putExtras(bundle);
                    intent.putExtra("title", mTitle[1]);
                    intent.putExtra("description", mDeskripsi[1]);
                    intent.putExtra("position", ""+1);
                    startActivity(intent);
                }
                if (position ==  2) {
                    Intent intent = new Intent(getApplicationContext(), TampilGuruBayar.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", image[2]);
                    intent.putExtras(bundle);
                    intent.putExtra("title", mTitle[2]);
                    intent.putExtra("description", mDeskripsi[2]);
                    intent.putExtra("position", ""+2);
                    startActivity(intent);
                }
                if (position ==  3) {
                    Intent intent = new Intent(getApplicationContext(), TampilGuruBayar.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", image[3]);
                    intent.putExtras(bundle);
                    intent.putExtra("title", mTitle[3]);
                    intent.putExtra("description", mDeskripsi[3]);
                    intent.putExtra("position", ""+3);
                    startActivity(intent);
                }

            }
        });
    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context ;
        String rTitle[];
        String rDeskirpsi[];
        int rImg[];

        MyAdapter(Context c, String title[],  String deskripsi[], int img[] ){
            super(c, R.layout.tampil, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDeskirpsi = deskripsi;
            this.rImg = img;
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.tampil, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImg[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDeskirpsi[position]);




            return row;
        }
    }
}