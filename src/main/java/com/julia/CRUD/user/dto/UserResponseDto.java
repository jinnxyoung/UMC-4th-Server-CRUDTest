package com.julia.CRUD.user.dto;

import com.julia.CRUD.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private Long userId;
    private String nickname;

    public UserResponseDto(User entity) {
        this.userId = entity.getUserId();
        this.nickname = entity.getNickname();
    }
}
