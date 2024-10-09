package com.travel.shahara.controllers.blog;

import com.travel.shahara.exceptions.ShaException;
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
@RequestMapping("/blog")
public class BlogByIdController {
    @Autowired
    private BlogByIdService blogByIdService;

    /**
     * Get Blog by ID
     * @param blogByIdForm Request param of API
     * @return Blog
     */
    @GetMapping("detail")
    public BlogByIdResponseDto getBlogById(@NotNull @Validated BlogByIdForm blogByIdForm) throws ShaException {
        BlogByIdServiceInputDto blogByIdServiceInputDto = BlogByIdServiceInputDto.builder().blogId(blogByIdForm.getBlogId()).build();
        BlogByIdServiceOutputDto blogByIdServiceOutputDto = blogByIdService.getBlogById(blogByIdServiceInputDto);
        return BlogByIdResponseDto.builder().blog(blogByIdServiceOutputDto.getBlog()).build();
    }
}
