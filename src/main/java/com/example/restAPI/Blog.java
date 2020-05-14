package com.example.restAPI;


import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity

public class Blog {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String title;
    private String content;

    public void parseResponse(ResultSet resultSet) throws SQLException {

    }

    public Blog(){}

    public int getId() {
        return id;
    }

    public Blog(String title, String content) {
        this.setTitle(title);
        this.setContent(content);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Blog(int id, String title, String content) {
        this.setId(id);
        this.setTitle(title);
        this.setContent(content);
    }



    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
