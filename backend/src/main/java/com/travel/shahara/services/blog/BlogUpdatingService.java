package com.travel.shahara.services.blog;

import com.travel.shahara.entities.Blog;
import com.travel.shahara.models.serviceInputDto.BlogUpdatingServiceInputDto;
import com.travel.shahara.models.serviceOutputDto.BlogUpdatingServiceOutputDto;
import com.travel.shahara.repositories.BlogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BlogUpdatingService {
    @Autowired
    private BlogRepository blogRepository;

    /**
     * Update Blog
     * @param blogUpdatingServiceInputDto Input DTO of service
     * @return Updated Blog
     */
    public BlogUpdatingServiceOutputDto updateBLog(BlogUpdatingServiceInputDto blogUpdatingServiceInputDto) {
        // 1. Copy data from input to Blog
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogUpdatingServiceInputDto, blog);

        // 2. Check exist Blog by ID
        if (isExistBlog(blog)){
            // 3. Update Blog
            blogRepository.save(blog);
            // 4. Output of service
            return BlogUpdatingServiceOutputDto.builder()
                    .blogId(blog.getBlogId())
                    .blogTitle(blog.getBlogTitle())
                    .blogContent(blog.getBlogContent())
                    .blogDescription(blog.getBlogDescription())
                    .blogAuthor(blog.getBlogAuthor())
                    .build();
        }
        return null;
    }

    /*
     * 
     */
    private boolean isExistBlog(Blog blog){
        return blogRepository.existsById(blog.getBlogId());
    }
}
