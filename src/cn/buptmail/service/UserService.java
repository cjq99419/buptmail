package cn.buptmail.service;

import cn.buptmail.domain.User;

import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 上午 11:13
 * @Notes 用户管理的业务接口
 */
public interface UserService {
    List<User> findAll();
    User login(User user);

    void addUser(User user);

    void deleteUser(String id);
}
