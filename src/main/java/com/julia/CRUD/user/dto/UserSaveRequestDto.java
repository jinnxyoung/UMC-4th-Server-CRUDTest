package com.julia.CRUD.user.dto;

import com.julia.CRUD.board.domain.Board;
import com.julia.CRUD.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String nickname;

    @Builder
    public UserSaveRequestDto(String nickname){
        this.nickname = nickname;
    }

    public User toEntity() {
        return User.builder()
                .nickname(nickname)
                .build();
    }
}
