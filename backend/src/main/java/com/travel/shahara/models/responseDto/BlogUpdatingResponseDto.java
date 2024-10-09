package com.travel.shahara.models.responseDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BlogUpdatingResponseDto {

    /**
     * Blog ID
     */
    private Integer blogId;

    /**
     * Blog title
     */
    private String blogTitle;

    /**
     * Blog content
     */
    private String blogContent;

    /**
     * Blog description
     */
    private String blogDescription;

    /**
     * Blog author
     */
    private String blogAuthor;
}
