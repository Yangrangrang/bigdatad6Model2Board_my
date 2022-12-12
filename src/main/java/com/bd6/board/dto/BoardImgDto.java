package com.bd6.board.dto;

import lombok.Data;

@Data
public class BoardImgDto {
    private int boardImgNo;   // pk auto increment
    private int boardNo;       // fk board.board_no
    private String imgPath;
}

