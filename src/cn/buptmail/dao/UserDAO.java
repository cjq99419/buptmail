package cn.buptmail.dao;

import cn.buptmail.domain.User;
import cn.buptmail.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 上午 11:15
 * @Notes 用户操作DAO
 */
public interface UserDAO {

    List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password);

    User findUserByTelAndPassword(String tel, String password);

    void add(User user);

    void delete(int id);

    void update(User user);

    User findUserById(int id);
}
