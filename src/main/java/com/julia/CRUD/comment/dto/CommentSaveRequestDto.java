package com.julia.CRUD.comment.dto;

import com.julia.CRUD.comment.domain.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentSaveRequestDto {
    private String comment;
    private String writer;

    @Builder
    public CommentSaveRequestDto(String comment, String writer) {
        this.comment = comment;
        this.writer = writer;
    }

    public Comment toEntity() {
        return Comment.builder()
                .comment(comment)
                .writer(writer)
                .build();
    }
}
