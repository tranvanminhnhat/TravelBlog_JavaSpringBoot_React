package com.travel.shahara.models.formDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BlogByIdForm {
    /**
     * Blog ID
     */
    private Integer blogId;
}
