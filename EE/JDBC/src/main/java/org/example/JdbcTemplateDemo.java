package org.example;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class JdbcTemplateDemo extends JdbcDaoSupport {
//    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(
                new DriverManagerDataSource("jdbc:mysql://localhost:3306/db_salary",
                        "root", "1234"));
        JdbcTemplateDemo jdbcTemplateDemo = new JdbcTemplateDemo(jdbcTemplate);

        List<Emp> info = jdbcTemplateDemo.getInfo();
        for (Emp emp : info) {
            System.out.println(emp);
        }
    }

    public JdbcTemplateDemo(JdbcTemplate jdbcTemplate) {
        setJdbcTemplate(jdbcTemplate);
    }

    public List<Emp> getInfo() {
        List<Emp> query = getJdbcTemplate().query(
                "select * from tb_employee", new BeanPropertyRowMapper<>(Emp.class));
        return query;
    }
}
