package com.modim.newtech.toyproject.community.board.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert
public class Board {

    @Id
    @Column(nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long id;

    @ColumnDefault("0")
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

    public void increaseHit()
    {
        this.hit += 1;
    }
}
