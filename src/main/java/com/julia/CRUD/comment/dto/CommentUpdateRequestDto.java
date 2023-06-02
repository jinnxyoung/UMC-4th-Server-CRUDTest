package com.julia.CRUD.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentUpdateRequestDto {
    private String comment;

    @Builder
    public CommentUpdateRequestDto(String comment) {
        this.comment = comment;
    }
}
