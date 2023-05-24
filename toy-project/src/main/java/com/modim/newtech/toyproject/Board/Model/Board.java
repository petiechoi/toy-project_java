package com.modim.newtech.toyproject.Board.Model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @Column(nullable=false)
    private Long id;

    @ColumnDefault("0")
    @Column(nullable = true)
    private Integer hit;

    @Column(nullable=false)
    private String author;
    @Column(nullable=false)
    private String title;
    @Column(nullable=false)
    private String content;

    public void updateBoard(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}
