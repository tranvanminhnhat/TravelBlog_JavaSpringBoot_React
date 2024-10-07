package com.travel.shahara.controllers.blog;

import com.travel.shahara.models.formDto.BlogCreatingForm;
import com.travel.shahara.models.responseDto.BlogCreatingResponseDto;
import com.travel.shahara.models.serviceInputDto.BlogCreatingServiceInputDto;
import com.travel.shahara.models.serviceOutputDto.BlogCreatingServiceOutputDto;
import com.travel.shahara.services.blog.BlogCreatingService;
import com.travel.shahara.services.blog.BlogListService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog/create")
public class BlogCreatingController {
    @Autowired
    private BlogCreatingService blogCreatingService;

    @PostMapping
    public BlogCreatingResponseDto createBlog(@RequestBody BlogCreatingForm blogCreatingForm) {

        BlogCreatingServiceInputDto blogCreatingServiceInputDto =
                BlogCreatingServiceInputDto.builder()
                .blogId(blogCreatingForm.getBlogId())
                .blogTitle(blogCreatingForm.getBlogTitle())
                .blogContent(blogCreatingForm.getBlogContent())
                .blogDescription(blogCreatingForm.getBlogDescription())
                .blogAuthor(blogCreatingForm.getBlogAuthor())
                .build();

        BlogCreatingServiceOutputDto blogCreatingServiceOutputDto = blogCreatingService.createNewBlog(blogCreatingServiceInputDto);

        return BlogCreatingResponseDto.builder()
                .blogId(blogCreatingServiceOutputDto.getBlogId())
                .blogTitle(blogCreatingServiceOutputDto.getBlogTitle())
                .blogContent(blogCreatingServiceOutputDto.getBlogContent())
                .blogDescription(blogCreatingServiceOutputDto.getBlogDescription())
                .blogAuthor(blogCreatingServiceOutputDto.getBlogAuthor())
                .build();
    }
}
