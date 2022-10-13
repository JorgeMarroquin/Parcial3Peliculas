package com.example.peliculas.beans;

import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("title")
    public String mTitle;
    @SerializedName("imageURL")
    public String mImageUrl;
    @SerializedName("author")
    public String mAuthor;

    public Book() {
    }

    public Book(String mTitle, String mImageUrl, String mAuthor) {
        this.mTitle = mTitle;
        this.mImageUrl = mImageUrl;
        this.mAuthor = mAuthor;
    }
}
