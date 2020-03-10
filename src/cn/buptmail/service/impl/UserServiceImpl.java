package cn.buptmail.service.impl;

import cn.buptmail.dao.UserDAO;
import cn.buptmail.dao.impl.UserDAOImpl;
import cn.buptmail.domain.User;
import cn.buptmail.service.UserService;

import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 上午 11:14
 * @Notes NULL
 */
public class UserServiceImpl implements UserService {
    private UserDAO dao = new UserDAOImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getName(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }
}
