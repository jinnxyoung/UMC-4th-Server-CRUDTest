package com.julia.CRUD.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String nickname;

    @Builder
    public UserUpdateRequestDto(String nickname) {
        this.nickname = nickname;
    }
}