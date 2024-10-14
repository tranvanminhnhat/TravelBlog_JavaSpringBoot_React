package com.travel.shahara.controllers.blog;

import com.travel.shahara.exceptions.ShaException;
import com.travel.shahara.models.formDto.BlogCreatingForm;
import com.travel.shahara.models.responseDto.BlogCreatingResponseDto;
import com.travel.shahara.models.serviceInputDto.BlogCreatingServiceInputDto;
import com.travel.shahara.models.serviceOutputDto.BlogCreatingServiceOutputDto;
import com.travel.shahara.services.blog.BlogCreatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogCreatingController {
    @Autowired
    private BlogCreatingService blogCreatingService;

    /**
     * Create new Blog
     *
     * @param blogCreatingForm Request body of API
     * @return Created Blog
     */
    @PostMapping("/create")
    public BlogCreatingResponseDto createBlog(@RequestBody BlogCreatingForm blogCreatingForm) throws ShaException {

        BlogCreatingServiceInputDto blogCreatingServiceInputDto = BlogCreatingServiceInputDto.builder()
                .blogTitle(blogCreatingForm.getBlogTitle())
                .blogContent(blogCreatingForm.getBlogContent())
                .blogDescription(blogCreatingForm.getBlogDescription())
                .blogAuthor(blogCreatingForm.getBlogAuthor())
                .build();

        BlogCreatingServiceOutputDto blogCreatingServiceOutputDto = blogCreatingService.createNewBlog(blogCreatingServiceInputDto);

        return BlogCreatingResponseDto.builder().blogId(blogCreatingServiceOutputDto.getBlogId()).blogTitle(blogCreatingServiceOutputDto.getBlogTitle()).blogContent(blogCreatingServiceOutputDto.getBlogContent()).blogDescription(blogCreatingServiceOutputDto.getBlogDescription()).blogAuthor(blogCreatingServiceOutputDto.getBlogAuthor()).build();
    }
}
