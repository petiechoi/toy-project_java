package com.modim.newtech.toyproject.community.board.repository;

import com.modim.newtech.toyproject.community.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
