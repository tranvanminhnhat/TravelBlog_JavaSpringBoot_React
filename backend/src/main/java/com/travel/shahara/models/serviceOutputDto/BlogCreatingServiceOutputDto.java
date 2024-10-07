package com.travel.shahara.models.serviceOutputDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BlogCreatingServiceOutputDto {

    private Integer blogId;

    private String blogTitle;

    private String blogContent;

    private String blogDescription;

    private String blogAuthor;
}
