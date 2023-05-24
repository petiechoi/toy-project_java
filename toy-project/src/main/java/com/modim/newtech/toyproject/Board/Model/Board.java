package com.modim.newtech.toyproject.Board.Model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @Column(nullable=false)
    private Long id;
    private Long hit;

    @Column(nullable=false)
    private String author;
    @Column(nullable=false)
    private String title;
    @Column(nullable=false)
    private String content;
}
