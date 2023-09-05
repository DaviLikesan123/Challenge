package br.com.mvc.desafio.model;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int userId;

    private Integer id;

    private String title;
    @SerializedName("body")
    private String text;

    public Post(int userId,  String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }
    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {this.title = title;}

    public void setText(String text) {
        this.text = text;
    }
}
