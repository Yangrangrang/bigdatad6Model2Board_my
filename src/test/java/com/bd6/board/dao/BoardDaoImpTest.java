package com.bd6.board.dao;

import com.bd6.board.dto.PagingDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardDaoImpTest {
    static BoardDao boardDao;

    @BeforeAll
    static void init() throws Exception {
        boardDao = new BoardDaoImp();
    }

    @Test
    void findAll() throws Exception {
        System.out.println(boardDao.findAll());
    }

    @Test
    void findPaging() throws Exception{
        PagingDto paging = new PagingDto(2,3,"title","ASC");
//        paging.setTotalRows(100);  // 페이징 네비게이션 세팅
        System.out.println(boardDao.findPaging(paging));
    }

    @Test
    void count() throws Exception {
        System.out.println(boardDao.count(null));
    }

    @Test
    void findById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void updateById() {
    }

    @Test
    void insert() {
    }
}