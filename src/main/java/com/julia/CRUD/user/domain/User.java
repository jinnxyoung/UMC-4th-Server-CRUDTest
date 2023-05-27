package com.julia.CRUD.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Column
    private String nickname;

    @Builder
    public User(String nickname) {
        this.nickname = nickname;
    }

    public void update(String nickname) {
        this.nickname = nickname;
    }
}
