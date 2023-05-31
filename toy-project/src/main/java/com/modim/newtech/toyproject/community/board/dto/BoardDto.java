package com.modim.newtech.toyproject.community.board.dto;

import com.modim.newtech.toyproject.community.board.model.Board;
import lombok.*;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private Integer hit;
    private String author;
    private String title;
    private String content;

    // repository를 통해 조회된 entity(model) 를 dto로 변환하기 위한
    public Board toEntity(){
        Board board = Board.builder()
                .id(id)
                .hit(hit)
                .author(author)
                .title(title)
                .content(content)
                .build();
        return board;
    }
}
