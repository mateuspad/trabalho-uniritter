package com.example.geolocation_application.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Comments implements Parcelable {
    private int postId;
    private int id;
    private String name;
    private String email;

    public Comments(int postId, int id, String name, String email) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
    }

    protected Comments(Parcel in) {
        postId = in.readInt();
        id = in.readInt();
        name = in.readString();
        email = in.readString();
    }

    public static final Creator<Comments> CREATOR = new Creator<Comments>() {
        @Override
        public Comments createFromParcel(Parcel in) {
            return new Comments(in);
        }

        @Override
        public Comments[] newArray(int size) {
            return new Comments[size];
        }
    };

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comment = (Comments) o;
        return postId == comment.postId && id == comment.id && Objects.equals(name, comment.name) && Objects.equals(email, comment.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, id, name, email);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getPostId());
        parcel.writeInt(getId());
        parcel.writeString(getName());
        parcel.writeString(getEmail());
    }
}
