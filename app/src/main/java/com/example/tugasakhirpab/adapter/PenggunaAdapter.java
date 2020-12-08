package com.example.tugasakhirpab.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tugasakhirpab.R;
import com.example.tugasakhirpab.model.Pengguna;

import java.util.ArrayList;

public class PenggunaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Pengguna> penggunaList = new ArrayList<>();

    public void setPenggunaList(ArrayList<Pengguna> penggunaList) {
        this.penggunaList = penggunaList;
    }

    public PenggunaAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return penggunaList.size();
    }

    @Override
    public Object getItem(int i) {
        return penggunaList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;

        if (itemView == null) {
            itemView = LayoutInflater.from(context)
                    .inflate(R.layout.item_pengguna, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Pengguna pengguna = (Pengguna) getItem(i);
        viewHolder.bind(pengguna);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtName, txtPhone, txtAddress, txtJadwal;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txtName);
            txtPhone = view.findViewById(R.id.txtPhone);
            txtAddress = view.findViewById(R.id.txtAddress);
            txtJadwal = view.findViewById(R.id.txtJadwal);
        }

        void bind(Pengguna pengguna) {
            txtName.setText(pengguna.getName());
            txtPhone.setText(pengguna.getPhone());
            txtAddress.setText(pengguna.getAddress());
            txtJadwal.setText(pengguna.getJadwal());
        }
    }
}