package com.example.geolocation_application.model;

import android.location.Address;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Usuario implements Parcelable {
    private int id;
    private String name;
    private String userName;
    private String email;
    private Address address;
    private String phone;
    private String website;

    public Usuario(int id, String name, String userName, String email) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
    }

    protected Usuario(Parcel in) {
        id = in.readInt();
        name = in.readString();
        userName = in.readString();
        email = in.readString();
        address = in.readParcelable(Address.class.getClassLoader());
        phone = in.readString();
        website = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getId());
        parcel.writeString(getName());
        parcel.writeString(getUserName());
        parcel.writeString(getEmail());
        parcel.writeString(getAddress().toString());
        parcel.writeString(getPhone());
        parcel.writeString(getWebsite());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(name, usuario.name) && Objects.equals(userName, usuario.userName) && Objects.equals(email, usuario.email) && Objects.equals(address, usuario.address) && Objects.equals(phone, usuario.phone) && Objects.equals(website, usuario.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userName, email, address, phone, website);
    }

}
