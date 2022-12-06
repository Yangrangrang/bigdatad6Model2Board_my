package com.bd6.board.dao;

import com.bd6.board.dto.UserDto;
import org.junit.jupiter.api.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImpTest {
    static UserDao userDao = null;

    @BeforeEach // 모든 Test 마다 처음에 실행
    void setUp() throws Exception {
    }
    @BeforeAll  // Test시작 전
    static void init() throws Exception {
        userDao = new UserDaoImp();
    }

    @AfterEach  // 모든 Test마다 끝에 실행
    void tearDown() throws Exception {
    }
    @AfterAll   // Test 완료 후
    static void end() throws Exception{
        System.out.println("삭제: " + userDao.deleteById("gkssk100")); // 등록과 동시에 삭제가 되면 실패할
    }
// Test간에 순서가 없기 때문에 userDao가 객체로 만들어지기 전에 findAll()을 호출하면 오류가 발생
//    @Test
//    void setObj(){
//        try {
//            userDao = new UserDaoImp();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
    @Test
    void findAll() throws Exception {
        System.out.println(userDao.findAll());
    }

    @Test
    void findById() throws Exception {
        System.out.println(userDao.findById("user1"));
    }

//    @Test
//    void deleteById() throws Exception {
//        userDao.deleteById("gkssk100");
//    }

    @Test
    void updateById() throws Exception {
        UserDto user = new UserDto();
        user.setUserId("user1");
        user.setName("양한나");
        user.setPw("1234");
        user.setPhone("010-2334-2345");
        user.setEmail("dksad@naver.com");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirth(sdf.parse("1992-09-17"));

        System.out.println(userDao.updateById(user));
        System.out.println(userDao.findById("user1"));
    }

    @Test
    void insert() throws Exception {
        UserDto user = new UserDto();
        user.setUserId("gkssk100");
        user.setName("양한나");
        user.setPw("1234");
        user.setPhone("010-4330-2302");
        user.setEmail("gkssk2329@gmail.com");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirth(sdf.parse("1992-09-17"));
        System.out.println(userDao.insert(user));
        System.out.println(userDao.findById("gkssk100"));
    }

    @Test
    void findByUserIDdAndPw() throws Exception {
        System.out.println(userDao.findByUserIdAndPw("awriter","1234"));
    }
}