package com.modim.newtech.toyproject.Board.Repository;

import com.modim.newtech.toyproject.Board.Model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
