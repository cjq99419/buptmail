package cn.buptmail.service;

import cn.buptmail.domain.Page;
import cn.buptmail.domain.Staff;
import cn.buptmail.domain.User;

import java.util.List;
import java.util.Map;

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

    void updateUser(User user);

    User findUserById(String id);

    void deleteSelectedUser(String[] ids);

    Page<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition);
}
