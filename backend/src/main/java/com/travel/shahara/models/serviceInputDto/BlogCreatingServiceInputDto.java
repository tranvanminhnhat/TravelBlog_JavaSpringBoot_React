package com.travel.shahara.models.serviceInputDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BlogCreatingServiceInputDto {

    private Integer blogId;

    private String blogTitle;

    private String blogContent;

    private String blogDescription;

    private String blogAuthor;
}
