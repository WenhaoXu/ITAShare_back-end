package com.oocl.demo.domain;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "todo_item")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private Boolean finished;
    private Date created;
    private Date done;

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", finished=" + finished +
                ", created=" + created +
                ", done=" + done +
                '}';
    }

    public TodoItem() {
    }

    public TodoItem(String content, Boolean finished) {
        this.content = content;
        this.finished = finished;
    }

    public TodoItem(Long id, String content, Boolean finished) {
        this.id = id;
        this.content = content;
        this.finished = finished;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getDone() {
        return done;
    }

    public void setDone(Date done) {
        this.done = done;
    }
}
