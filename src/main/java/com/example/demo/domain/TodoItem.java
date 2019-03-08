package com.example.demo.domain;


import org.springframework.data.annotation.Id;

/**
 * @author Howells
 * @DATE 03/08/2019
 */

public class TodoItem {
    @Id
    private String id;
    private String text;
    private Long completed;
    private String date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public Long getCompleted() {
        return completed;
    }

    public void setCompleted(Long completed) {
        this.completed = completed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
