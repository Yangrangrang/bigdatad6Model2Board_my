package com.bd6.board.dao;

import com.bd6.board.dto.UserDto;

public interface UserDao extends CRUD<UserDto,String> {
    // Dao의 이름을 정할때 "_"예약어 필드를 의미 ㄴ user_id
    // db의 필드명을 java에 연합할 떄 꼭 난타표기법으로 바꿔서 작성한다.
    UserDto findByUserIdAndPw(String userId, String pw) throws Exception;  // 로그인
}
