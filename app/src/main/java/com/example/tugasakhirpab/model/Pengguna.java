package com.example.tugasakhirpab.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pengguna implements Parcelable {
    private String id;
    private String name;
    private String phone;
    private String address;
    private String jadwal;

    public Pengguna() {

    }

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.phone);
        dest.writeString(this.address);
        dest.writeString(this.jadwal);
    }

    protected Pengguna(Parcel in){
        this.id = in.readString();
        this.name = in.readString();
        this.phone = in.readString();
        this.address = in.readString();
        this.jadwal = in.readString();
    }

    public static final Parcelable.Creator<Pengguna> CREATOR = new Parcelable.Creator<Pengguna>() {
        @Override
        public Pengguna createFromParcel(Parcel source) {
            return new Pengguna(source);
        }

        @Override
        public Pengguna[] newArray(int size) {
            return new Pengguna[size];
        }
    };
}

