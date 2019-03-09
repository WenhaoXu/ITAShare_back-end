package com.example.demo.domain;


import org.springframework.data.annotation.Id;

import java.util.UUID;

/**
 * @author Howells
 * @DATE 03/08/2019
 */

public class TodoItem {
    private String id;

    private String title;

    private Boolean finished;

    public TodoItem() {
    }

    public TodoItem(String title, Boolean finished) {
        this.id=UUID.randomUUID().toString();
        this.title = title;
        this.finished = finished;
    }

    public TodoItem(String id, String title, Boolean finished) {
        this.id = id;
        this.title = title;
        this.finished = finished;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }
}
