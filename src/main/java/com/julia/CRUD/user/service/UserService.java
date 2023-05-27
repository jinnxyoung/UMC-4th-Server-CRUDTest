package com.julia.CRUD.user.service;

import com.julia.CRUD.user.domain.User;
import com.julia.CRUD.user.dto.UserListResponseDto;
import com.julia.CRUD.user.dto.UserResponseDto;
import com.julia.CRUD.user.dto.UserSaveRequestDto;
import com.julia.CRUD.user.dto.UserUpdateRequestDto;
import com.julia.CRUD.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    @Transactional
    public String userSave(UserSaveRequestDto requestDto) {
        return userRepository.save(requestDto.toEntity()).getUserId() + ": 회원이 등록되었습니다.";
    }

    @Transactional
    public String userUpdate(Long userId, UserUpdateRequestDto requestDto) {
        User user = userRepository.findById(userId).orElseThrow
                (()-> new IllegalArgumentException("존재하지 않는 회원입니다."));
        user.update(requestDto.getNickname());

        return userId + "의 닉네임이 수정되었습니다.";
    }
    @Transactional
    public void userDelete(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 회원입니다."));
        userRepository.delete(user);
    }
    public UserResponseDto findById(Long userId) {
        User entity = userRepository.findById(userId).orElseThrow
                (()-> new IllegalArgumentException("해당 회원이 없습니다."));

        return new UserResponseDto(entity);
    }

    @Transactional
    public List<UserListResponseDto> findAllUser() {
        try{
            List<User> userList = userRepository.findAll();
            List<UserListResponseDto> responseDtoList = new ArrayList<>();
            for (User user : userList) {
                responseDtoList.add(
                        new UserListResponseDto(user)
                );
            }
            return responseDtoList;
        } catch (Exception e){

        }
        return null;
    }
}