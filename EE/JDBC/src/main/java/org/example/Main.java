package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
    public static void main(String[] args) {
        // 1.获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        // 2.根据id获取JdbcTemplate对象
        JdbcTemplate jt = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        // 3.CRUD
        jt.update("insert into account(name,money) values(?,?)", "ye", 5000);
    }
}
