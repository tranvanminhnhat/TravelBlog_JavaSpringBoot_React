package com.travel.shahara.controllers.blog;

import com.travel.shahara.exceptions.ShaException;
import com.travel.shahara.models.formDto.BlogUpdatingForm;
import com.travel.shahara.models.responseDto.BlogUpdatingResponseDto;
import com.travel.shahara.models.serviceInputDto.BlogCreatingServiceInputDto;
import com.travel.shahara.models.serviceInputDto.BlogUpdatingServiceInputDto;
import com.travel.shahara.models.serviceOutputDto.BlogUpdatingServiceOutputDto;
import com.travel.shahara.services.blog.BlogUpdatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogUpdatingController {
    @Autowired
    private BlogUpdatingService blogUpdatingService;

    /**
     * Update Blog
     * @param blogUpdatingForm Request body of API
     * @return Updated Blog
     */
    @PostMapping("/update")
    public BlogUpdatingResponseDto updateBlog(@Validated @RequestBody BlogUpdatingForm blogUpdatingForm) throws ShaException {
        BlogUpdatingServiceInputDto blogUpdatingServiceInputDto =
                BlogUpdatingServiceInputDto.builder()
                        .blogId(blogUpdatingForm.getBlogId())
                        .blogTitle(blogUpdatingForm.getBlogTitle())
                        .blogContent(blogUpdatingForm.getBlogContent())
                        .blogDescription(blogUpdatingForm.getBlogDescription())
                        .blogAuthor(blogUpdatingForm.getBlogAuthor())
                        .build();

        BlogUpdatingServiceOutputDto blogUpdatingServiceOutputDto = blogUpdatingService.updateBLog(blogUpdatingServiceInputDto);

        return BlogUpdatingResponseDto.builder()
                .blogId(blogUpdatingServiceOutputDto.getBlogId())
                .blogTitle(blogUpdatingServiceOutputDto.getBlogTitle())
                .blogContent(blogUpdatingServiceOutputDto.getBlogContent())
                .blogDescription(blogUpdatingServiceOutputDto.getBlogDescription())
                .blogAuthor(blogUpdatingServiceOutputDto.getBlogAuthor())
                .build();
    }


}
