package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void insertData() throws SQLException, ClassNotFoundException {
        String URL = "jdbc:mysql://localhost:port/databaseName?useUnicode=true&characterEncoding=UTF-8";
        String USER = "xx";
        String PASSWORD = "xx";

        // 1 注册数据库驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2 获取链接connection
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        // 3 获取运行对象statement
        PreparedStatement preparedStatement = connection.prepareStatement("insert into test (name, sex) values (?,?)");
        // 4 通过statement对象执行sql
        preparedStatement.setString(1, "xxx");
        preparedStatement.setString(2, "yyy");
        // 5 获取返回结果
        Boolean result = preparedStatement.execute();

    }
}
