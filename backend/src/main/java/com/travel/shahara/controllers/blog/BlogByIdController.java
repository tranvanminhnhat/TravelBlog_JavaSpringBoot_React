package com.travel.shahara.controllers.blog;

import com.travel.shahara.models.formDto.BlogByIdForm;
import com.travel.shahara.models.responseDto.BlogByIdResponseDto;
import com.travel.shahara.models.serviceInputDto.BlogByIdServiceInputDto;
import com.travel.shahara.models.serviceOutputDto.BlogByIdServiceOutputDto;
import com.travel.shahara.services.blog.BlogByIdService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog/detail")
public class BlogByIdController {
    @Autowired
    private BlogByIdService blogByIdService;

    @GetMapping
    public BlogByIdResponseDto getBlogById(@NotNull @Validated BlogByIdForm blogByIdForm) {
        BlogByIdServiceInputDto blogByIdServiceInputDto = BlogByIdServiceInputDto.builder().blogId(blogByIdForm.getBlogId()).build();
        BlogByIdServiceOutputDto blogByIdServiceOutputDto = blogByIdService.getBlogById(blogByIdServiceInputDto);
        return BlogByIdResponseDto.builder().blog(blogByIdServiceOutputDto.getBlog()).build();
    }
}
