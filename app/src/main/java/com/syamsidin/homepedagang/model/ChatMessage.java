package com.syamsidin.homepedagang.model;

/**
 * Created by Syam on 04/02/2017.
 */

public class ChatMessage {
    private long id;
    private boolean isMe; //untuk nama
    private String message; // untuk pesannya
    private Long userId; // user id
    private String dateTime; // waktu pesan

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public boolean getIsme() {
        return isMe;
    }
    public void setMe(boolean isMe) {
        this.isMe = isMe;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDate() {
        return dateTime;
    }

    public void setDate(String dateTime) {
        this.dateTime = dateTime;
    }
}