package com.travel.shahara.services.blog;

import com.travel.shahara.entities.Blog;
import com.travel.shahara.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlogListService {
    @Autowired
    private BlogRepository blogRepository;

    /**
     * Get all Blogs
     * @return Blog list
     */
    public List<Blog> getAllBlogs() {
        return blogRepository.getAllBlogs();
    }
}
