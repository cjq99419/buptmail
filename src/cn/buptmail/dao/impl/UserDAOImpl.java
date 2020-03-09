package cn.buptmail.dao.impl;

import cn.buptmail.dao.UserDAO;
import cn.buptmail.domain.User;
import cn.buptmail.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 上午 11:16
 * @Notes NULL
 */
public class UserDAOImpl implements UserDAO {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where name = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
            return user;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
