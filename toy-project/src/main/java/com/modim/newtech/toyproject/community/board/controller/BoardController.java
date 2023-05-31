package com.modim.newtech.toyproject.community.board.controller;

import com.modim.newtech.toyproject.community.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardController{
    private final BoardService boardService;

    @GetMapping("/")
    public String root() {
        return "redirect:/boardList";
    }

    // 전체목록
    @GetMapping("/boardList")
    public String boardList(Model model){
        model.addAttribute("boardList", boardService.getBoardList());
        return "board/board";
    }


//    @GetMapping("/board/{id}")
//    public String string(){
//        return "edit";
//    }

//    // 글 작성
//    @GetMapping("/board/write")
//    public String boardWrite(){
//        return "write";
//    }
//
//    // 글 수정
//    @GetMapping("/board/edit")
//    public String boardEdit(){
//        return "edit";
//    }


}
