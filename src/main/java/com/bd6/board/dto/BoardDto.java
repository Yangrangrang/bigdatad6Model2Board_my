package com.bd6.board.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BoardDto {
    private int boardNo;
    private String title;
    private String contents;
    private Date postTime;
    private String userId;
    private int views;
    private List<ReplyDto> replyList;
}
