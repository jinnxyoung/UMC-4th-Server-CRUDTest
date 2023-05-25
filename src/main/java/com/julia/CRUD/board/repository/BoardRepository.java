package com.julia.CRUD.board.repository;

import com.julia.CRUD.board.domain.Board;
import com.julia.CRUD.board.dto.BoardListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("SELECT b FROM Board b ORDER BY b.id DESC")
    List<BoardListResponseDto> findAllDesc();
}