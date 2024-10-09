package com.travel.shahara.models.serviceOutputDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BlogCreatingServiceOutputDto {

    /**
     * BLog ID
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
