package com.travel.shahara.services.blog;
import com.travel.shahara.entities.Blog;
import com.travel.shahara.models.serviceInputDto.BlogByIdServiceInputDto;
import com.travel.shahara.models.serviceOutputDto.BlogByIdServiceOutputDto;
import com.travel.shahara.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BlogByIdService {
    @Autowired
    private BlogRepository blogRepository;

    public BlogByIdServiceOutputDto getBlogById(BlogByIdServiceInputDto blogByIdServiceInputDto) {
        Blog blog = blogRepository.findById(blogByIdServiceInputDto.getBlogId()).orElse(null);
        return BlogByIdServiceOutputDto.builder().blog(blog).build();
    }
}
