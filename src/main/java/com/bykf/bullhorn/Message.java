package com.bykf.bullhorn;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=4)
    private string message;

    @NotNull
    @Size(min=4)
    private Date date;

    @NotNull
    @Size(min=4)
    private string author;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotNull
    public string getMessage() {
        return message;
    }

    public void setMessage(@NotNull string message) {
        this.message = message;
    }

    @NotNull
    public date getDate() {
        return date;
    }

    public void setDate(@NotNull date date) {
        this.date = date;
    }

    @NotNull
    public string getAuthor() {
        return author;
    }

    public void setAuthor(@NotNull string author) {
        this.author = author;
    }
}
