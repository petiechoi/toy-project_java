package com.modim.newtech.toyproject.board.controller;

import com.modim.newtech.toyproject.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardController{
    private final BoardService boardService;

    @GetMapping("/board")
    public String Getboard(Model model){
        model.addAttribute("boardList", boardService.getBoardList());
        return "board";
    }
}
