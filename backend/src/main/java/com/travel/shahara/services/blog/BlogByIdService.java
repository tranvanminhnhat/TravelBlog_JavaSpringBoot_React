package com.travel.shahara.services.blog;
import com.travel.shahara.entities.Blog;
import com.travel.shahara.exceptions.ShaException;
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

    /**
     * Get Blog by ID
     * @param blogByIdServiceInputDto Input DTO of service
     * @return Blog was got by ID
     */
    public BlogByIdServiceOutputDto getBlogById(BlogByIdServiceInputDto blogByIdServiceInputDto) throws ShaException {
        Blog blog = blogRepository.findById(blogByIdServiceInputDto.getBlogId()).orElse(null);

        if (blog == null) {
            throw ShaException.builder().code("0001").message("Blog not found").build();
        }
        return BlogByIdServiceOutputDto.builder().blog(blog).build();
    }
}
