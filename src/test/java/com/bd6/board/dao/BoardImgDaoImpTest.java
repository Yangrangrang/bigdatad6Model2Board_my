package com.bd6.board.dao;

import com.bd6.board.dto.BoardImgDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardImgDaoImpTest {
    static BoardImgDao boardImgDao;
    @BeforeAll
    static void init() throws Exception {
        boardImgDao = new BoardImgDaoImp();
    }
    @Test
    void insert() throws Exception {
        BoardImgDto boardImg = new BoardImgDto();
        boardImg.setBoardNo(2);
        boardImg.setImgPath("a.jpg");   // 임의
        System.out.println(boardImgDao.insert(boardImg));
    }

    @Test
    void findByBoard() throws Exception {
        System.out.println(boardImgDao.findByBoard(1));
    }

    @Test
    void deleteByBoard() throws Exception {
        System.out.println(boardImgDao.deleteByBoard(1));
    }

    @Test
    void deleteById() throws Exception {
        System.out.println(boardImgDao.deleteById(2));
    }


}