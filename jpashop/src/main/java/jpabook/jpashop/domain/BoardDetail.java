package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class BoardDetail {
    @Id
    private Long boardId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    public void setBoard(Board board) {
        this.board = board;
    }
}
