package com.bd6.board.dto;

import lombok.*;

import java.util.Date;

//@Getter // java문서에는 없는데 class 컴파일 하면서 Getter 메서드 생성
//@Setter
//@ToString
//@EqualsAndHashCode
//@RequiredArgsConstructor

@Data   // getter Setter ToString까지 다 해줌 (위 5개 자동 생성)
@AllArgsConstructor
@NoArgsConstructor
public class EmpDto {

    private int empno;
    private String ename;
    private String job;
    private Date hiredate;

}

