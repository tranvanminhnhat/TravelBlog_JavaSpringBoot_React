package com.travel.shahara.models.formDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BlogCreatingForm {
    private Integer blogId;

    private String blogTitle;

    private String blogContent;

    private String blogDescription;

    private String blogAuthor;
}
