package com.travel.shahara.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Blog {

    /**
     * Blog ID
     */
    @Id
    private Integer blogId;

    /**
     * Blog title
     */
    private String blogTitle;

    /**
     * Blog content
     */
    private String blogContent;

    /**
     * Blog description
     */
    private String blogDescription;

    /**
     * Blog author
     */
    private String blogAuthor;

    /**
     * Getter Blog ID
     * @return Blog ID
     */
    public Integer getBlogId() {
        return blogId;
    }

    /**
     * Setter Blog ID
     * @param blogId Blog ID
     */
    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    /**
     * Getter Blog title
     * @return Blog title
     */
    public String getBlogTitle() {
        return blogTitle;
    }

    /**
     * Setter Blog title
     * @param blogTitle Blog title
     */
    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    /**
     * Getter Blog content
     * @return Blog content
     */
    public String getBlogContent() {
        return blogContent;
    }

    /**
     * Setter Blog content
     * @param content Blog content
     */
    public void setBlogContent(String content) {
        this.blogContent = content;
    }

    /**
     * Getter blog description
     * @return Blog description
     */
    public String getBlogDescription() {
        return blogDescription;
    }

    /**
     * Setter Blog description
     * @param description Blog description
     */
    public void setBlogDescription(String description) {
        this.blogDescription = description;
    }

    /**
     * Getter Blog author
     * @return Blog author
     */
    public String getBlogAuthor() {
        return blogAuthor;
    }

    /**
     * Setter Blog author
     * @param author Blog author
     */
    public void setBlogAuthor(String author) {
        this.blogAuthor = author;
    }
}
