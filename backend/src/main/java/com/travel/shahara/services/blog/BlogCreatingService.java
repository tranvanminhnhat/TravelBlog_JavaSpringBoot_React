package com.travel.shahara.services.blog;

import com.travel.shahara.entities.Blog;
import com.travel.shahara.models.serviceInputDto.BlogCreatingServiceInputDto;
import com.travel.shahara.models.serviceOutputDto.BlogCreatingServiceOutputDto;
import com.travel.shahara.repositories.BlogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BlogCreatingService {
    @Autowired
    private BlogRepository blogRepository;

    public BlogCreatingServiceOutputDto createNewBlog(BlogCreatingServiceInputDto blogCreatingServiceInputDto) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogCreatingServiceInputDto, blog);
        blogRepository.save(blog);
        return BlogCreatingServiceOutputDto.builder()
                .blogId(blog.getBlogId())
                .blogTitle(blog.getBlogTitle())
                .blogContent(blog.getBlogContent())
                .blogDescription(blog.getBlogDescription())
                .blogAuthor(blog.getBlogAuthor())
                .build();
    }
}
