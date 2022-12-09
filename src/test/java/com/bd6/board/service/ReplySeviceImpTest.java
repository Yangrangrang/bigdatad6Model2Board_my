package com.bd6.board.service;

import com.bd6.board.dto.PagingDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReplySeviceImpTest {
    static ReplySevice replySevice;
    @BeforeAll
    static void init() throws Exception {
        replySevice = new ReplySeviceImp();
    }

    @Test
    void list() {
    }

    @Test
    void boardDetailList() throws Exception {
        PagingDto paging = new PagingDto(1,5,"reply_no","DESC");
        System.out.println(paging);
        System.out.println(replySevice.boardDetailList(paging,1));
        System.out.println(paging);
    }

    @Test
    void modify() {
    }

    @Test
    void register() {
    }

    @Test
    void remove() {
    }
}