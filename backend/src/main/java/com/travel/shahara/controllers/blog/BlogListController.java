package com.travel.shahara.controllers.blog;

import com.travel.shahara.entities.Blog;
import com.travel.shahara.services.blog.BlogListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogListController {
    @Autowired
    private BlogListService blogListService;

    @GetMapping("/list")
    public List<Blog> getBlogList(){
        return blogListService.getAllBlogs();
    }
}
