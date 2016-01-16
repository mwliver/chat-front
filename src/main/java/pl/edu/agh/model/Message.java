package pl.edu.agh.model;

import java.util.Date;

/**
 * Copyright (C) Coderion sp. z o.o
 */
public class Message {

    private Long id;
    private Date createDate;
    private String text;
    private User user;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
