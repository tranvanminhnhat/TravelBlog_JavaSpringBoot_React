package com.travel.shahara.models.serviceInputDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BlogByIdServiceInputDto {
    /**
     * Blog ID
     */
    private Integer blogId;
}
