package com.travel.shahara.models.responseDto;

import com.travel.shahara.entities.Blog;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BlogByIdResponseDto {
    /**
     * Blog
     */
    private Blog blog;
}
