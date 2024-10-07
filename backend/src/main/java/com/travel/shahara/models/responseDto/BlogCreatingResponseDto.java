package com.travel.shahara.models.responseDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BlogCreatingResponseDto {

    private Integer blogId;

    private String blogTitle;

    private String blogContent;

    private String blogDescription;

    private String blogAuthor;
}
