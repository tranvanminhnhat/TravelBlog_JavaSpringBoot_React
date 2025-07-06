package com.travel.blog.api.pages.post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @GetMapping("/post")
    public String hello(){
        return "hello";
    }
}
