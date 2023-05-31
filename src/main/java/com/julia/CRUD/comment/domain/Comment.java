package com.julia.CRUD.comment.domain;

import com.julia.CRUD.board.domain.Board;
import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="commet_id")
    private Long cId;

    @Column
    private String comment;

    @Column
    private String writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id")
    private Board pId;

    @Builder
    public Comment(String comment, String writer, Board pId) {
        this.comment = comment;
        this.pId = pId;
        this.writer = writer;
    }

    public void update(String comment) {
        this.comment = comment;
    }
}
