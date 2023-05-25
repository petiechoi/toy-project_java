package com.modim.newtech.toyproject.board.repository;

import com.modim.newtech.toyproject.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
