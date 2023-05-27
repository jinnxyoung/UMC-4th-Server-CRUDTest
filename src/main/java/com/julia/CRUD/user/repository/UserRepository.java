package com.julia.CRUD.user.repository;

import com.julia.CRUD.user.domain.User;
import com.julia.CRUD.user.dto.UserListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u ORDER BY u.userId DESC")
    List<UserListResponseDto> findAllDesc();
    User findByNickname(String nickname);

    // 중복인 경우 true, 중복되지 않은 경우 false 리턴
    boolean existsByNickname(String nickname);
}
