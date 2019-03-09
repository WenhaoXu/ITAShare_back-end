package com.oocl.demo.domain;


import javax.persistence.*;
import java.util.UUID;


@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private Boolean finished;

    public TodoItem() {
    }

    public TodoItem(String title, Boolean finished) {
        this.title = title;
        this.finished = finished;
    }

    public TodoItem(Long id, String title, Boolean finished) {
        this.id = id;
        this.title = title;
        this.finished = finished;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
