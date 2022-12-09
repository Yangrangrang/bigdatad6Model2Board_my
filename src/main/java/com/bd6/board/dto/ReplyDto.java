package com.bd6.board.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ReplyDto {
    private int replyNo;
    private String title;
    private String contents;
    private Date postTime;
    private String imgPath;
    private int boardNo;    // 게시글이 무조건 있어야 댓글이 있기때문에
    private String userId;
    private int views;
    private Integer fkReplyNo;  // 대댓글, null값이 들어올수 있기 때문에 Integer!
    private List<ReplyDto> replyList;   // 1:N(fkReplyNo) join


}
