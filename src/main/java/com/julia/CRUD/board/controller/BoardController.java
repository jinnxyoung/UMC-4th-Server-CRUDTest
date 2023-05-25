package com.julia.CRUD.board.controller;

import com.julia.CRUD.board.dto.BoardListResponseDto;
import com.julia.CRUD.board.dto.BoardResponseDto;
import com.julia.CRUD.board.dto.BoardSaveRequestDto;
import com.julia.CRUD.board.dto.BoardUpdateRequestDto;
import com.julia.CRUD.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // 게시물 전체 조회
    @GetMapping("/board/posts")
    public List<BoardListResponseDto> getAllBoard() {
        return boardService.findAllBoard();
    }
    // 게시물 등록
    @PostMapping("/board/post")
    public String save(@RequestBody BoardSaveRequestDto requestDto) {
        return boardService.save(requestDto);
    }
    // 게시물 수정
    @PutMapping ("/board/update/{id}")
    public String update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }
    // 게시물 조회
    @GetMapping("/board/post/{id}")
    public BoardResponseDto findById (@PathVariable Long id) {
        return boardService.findById(id);
    }
    // 게시물 삭제
    @DeleteMapping("/board/delete/{id}")
    public String delete(@PathVariable Long id) {
        boardService.delete(id);
        return id + ": 게시물이 삭제되었습니다.";
    }
}