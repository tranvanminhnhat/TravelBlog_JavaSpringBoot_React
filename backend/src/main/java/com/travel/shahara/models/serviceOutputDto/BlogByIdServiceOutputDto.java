package com.travel.shahara.models.serviceOutputDto;

import com.travel.shahara.entities.Blog;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BlogByIdServiceOutputDto {
    private Blog blog;
}
