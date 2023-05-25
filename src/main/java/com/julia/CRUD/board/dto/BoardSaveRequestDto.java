package com.julia.CRUD.board.dto;

import com.julia.CRUD.board.domain.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private String title;
    private String content;
    private Long userId;

    @Builder
    public BoardSaveRequestDto(String title, String content, Long userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .userId(userId)
                .build();
    }
}