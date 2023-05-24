package com.modim.newtech.toyproject.Board.Controller;

import com.modim.newtech.toyproject.Board.Dto.BoardDto;
import com.modim.newtech.toyproject.Board.Model.Board;
import com.modim.newtech.toyproject.Board.Service.BoardService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/board")
public class BoardRestController {
    private final BoardService boardService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Board> getBoard(@PathVariable(value="id")Long id){
        return ResponseEntity.ok(boardService.getBoard(id));

    }

    @RequestMapping(method=RequestMethod.POST)
    public Long createBoard(@RequestBody BoardDto boardDto){
        return boardService.createBoard(boardDto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Long updateBoard(@PathVariable(value="id")Long id, @RequestBody BoardDto boardDto){
        return boardService.updateBoard(id, boardDto);
    }


}
