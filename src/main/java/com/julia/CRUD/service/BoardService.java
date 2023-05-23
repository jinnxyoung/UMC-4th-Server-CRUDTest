package com.julia.CRUD.service;

import com.julia.CRUD.domain.Board;
import com.julia.CRUD.dto.BoardListResponseDto;
import com.julia.CRUD.dto.BoardResponseDto;
import com.julia.CRUD.dto.BoardSaveRequestDto;
import com.julia.CRUD.dto.BoardUpdateRequestDto;
import com.julia.CRUD.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public String save(BoardSaveRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity()).getId() + ": 게시물이 등록되었습니다.";
    }

    @Transactional
    public String update(Long id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("해당 게시물이 없습니다. id="+id));
        board.update(requestDto.getTitle(), requestDto.getContent());

        return id + ": 게시물이 수정되었습니다.";
    }
    @Transactional
    public void delete(Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id =" + id));
        // 존재하는 게시물인지 확인하기 위해 조회 후 삭제
        boardRepository.delete(board);
    }

    public BoardResponseDto findById(Long id) {
        Board entity = boardRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("해당 게시물이 없습니다. id="+id));

        return new BoardResponseDto(entity);
    }

    @Transactional
    public List<BoardListResponseDto> findAllBoard() {
        try {
            List<Board> boardList = boardRepository.findAll();
            List<BoardListResponseDto> responseDtoList = new ArrayList<>();
            for (Board board : boardList) {
                responseDtoList.add(
                        new BoardListResponseDto(board)
                );
            }
            return responseDtoList;
        } catch (Exception e) {
        }
        return null;
    }
}