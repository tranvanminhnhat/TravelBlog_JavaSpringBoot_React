package com.travel.shahara.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Blog {

    @Id
    private Integer blogId;

    private String blogTitle;

    private String blogContent;

    private String blogDescription;

    private String blogAuthor;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String content) {
        this.blogContent = content;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String description) {
        this.blogDescription = description;
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String author) {
        this.blogAuthor = author;
    }
}
