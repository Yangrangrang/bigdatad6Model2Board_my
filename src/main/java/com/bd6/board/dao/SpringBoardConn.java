package com.bd6.board.dao;

import java.sql.*;
import java.sql.SQLException;

public class SpringBoardConn {
    // 싱글톤 패턴으로 db접속
    // 첫번째로 해야하는건 static으로 된 private 를 만들어야함

    private static Connection conn;
    private static String url = "jdbc:mysql://172.30.1.64:3306/SPRING_BOARD"; //jdbc통신
    private static String user = "root";
    private static String pw = "root";

    public  static Connection getConn() throws Exception {
        if (conn==null || conn.isClosed()){
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pw);
        }
        return conn;
    }

    // last_insert_id() 는 오토인트리먼트로 마지막으로 저장된 Id를 반환
    public static int getLastInsertId() throws SQLException {
        int id = 0;
        String sql = "SELECT LAST_INSERT_ID() as id";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            id = rs.getInt("id");
        }
        return id;  // 저장된 내역이 없으면 0 (null로 할 필요가 없음)
    }


}
