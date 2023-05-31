package com.modim.newtech.toyproject.community.board.service;


import com.modim.newtech.toyproject.community.board.dto.BoardDto;
import com.modim.newtech.toyproject.community.board.model.Board;
import com.modim.newtech.toyproject.community.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@RequiredArgsConstructor
@Service
public class BoardService {

    // @Autowird 사용 X -> RequiredArgsConstructor로 생성되는 생성자로 주입받기 위해 final 적어야함.
    private final BoardRepository boardRepository;

    // 게시물 리스트 조회
    @Transactional
    public List<Board> getBoardList(){
        return boardRepository.findAll();
    }
    // 게시물 조회
    @Transactional
    public Board getBoard(Long id) {
        //return boardRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id =" +id));
        Board board = boardRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id =" +id));
        board.increaseHit();
        return board;
    }

    // 게시물 생성
    @Transactional
    public Long createBoard(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    // 게시물 수정
    @Transactional
    public Long updateBoard(Long id, BoardDto boardDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
        board.updateBoard(boardDto.getTitle(),boardDto.getContent());
        return id;
    }

    // 게시물 삭제
    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }


}
