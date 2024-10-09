package com.travel.shahara.models.serviceOutputDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BlogUpdatingServiceOutputDto {

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
