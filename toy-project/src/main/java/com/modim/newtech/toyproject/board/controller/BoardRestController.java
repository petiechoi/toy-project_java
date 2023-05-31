package com.modim.newtech.toyproject.board.controller;

import com.modim.newtech.toyproject.board.dto.BoardDto;
import com.modim.newtech.toyproject.board.model.Board;
import com.modim.newtech.toyproject.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/board")
public class BoardRestController {
    private final BoardService boardService;

    @GetMapping("/")    // 게시판 전체 목록 불러오는 api
    public List<Board> getBoardList(){
        return boardService.getBoardList();
    }

    @GetMapping("/{articleId}")    // 게시판 상세 페이지의 정보를 불러오는 api
    public Board getBoard(@PathVariable Long articleId){
        return boardService.getBoard(articleId);
    }

    @PostMapping("/")       // 게시판 게시글 등록 api
    public Long createBoard(@RequestBody BoardDto boardDto){
        return boardService.createBoard(boardDto);
    }

    @PutMapping("/{articleId}")        // 해당 articleId의 게시글을 수정하는 api
    public Long updateBoard(@PathVariable Long articleId, @RequestBody BoardDto boardDto){
        return boardService.updateBoard(articleId, boardDto);
    }

    @DeleteMapping("/{articleId}")
    public void deleteBoard(@PathVariable Long articleId) {
        boardService.deleteBoard(articleId);
    }


}
