package com.julia.CRUD.comment.controller;

import com.julia.CRUD.comment.dto.CommentListResponseDto;
import com.julia.CRUD.comment.dto.CommentSaveRequestDto;
import com.julia.CRUD.comment.dto.CommentUpdateRequestDto;
import com.julia.CRUD.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // 특정 게시물의 댓글 전체 조회
    @GetMapping("/board/post/{id}/comments")
    public List<CommentListResponseDto> getAllComment() {
        return commentService.findAllComment();
    }

    // 특정 게시물에 댓글 등록
    @PostMapping("/board/post/{pId}/comments/post")
    public String commentSave(@RequestBody CommentSaveRequestDto requestDto) {
        return commentService.commentSave(requestDto);
    }

    // 댓글 수정
    @PatchMapping("/board/post/{pId}/comments/update/{cId}")
    public String commentUpdate(@PathVariable Long cId, CommentUpdateRequestDto requestDto) {
        return commentService.commentUpdate(cId, requestDto);
    }

    // 댓글 삭제
    @DeleteMapping("/board/post/{pId}/comments/delete/{cId}")
    public String delete(@PathVariable Long cId) {
        commentService.commentDelete(cId);
        return "댓글이 삭제되었습니다.";
    }
}