package com.bd6.board.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImpTest {
    private static UserService userService;

    @BeforeAll
    static void init() throws Exception {
        userService=new UserServiceImp();
    }

    @Test
    void signup() {
    }

    @Test
    void register() {
    }

    @Test
    void userModify() {
    }

    @Test
    void adminModify() {
    }

    @Test
    void login() {
    }

    @Test
    void list() {
    }

    @Test
    void detail() {
    }

    @Test
    void idcheck() throws Exception{
        int idCheck = userService.idcheck("user9");
        System.out.println(idCheck);
    }
}