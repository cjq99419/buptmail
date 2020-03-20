package cn.buptmail.service.impl;

import cn.buptmail.dao.UserDAO;
import cn.buptmail.dao.impl.UserDAOImpl;
import cn.buptmail.domain.Orders;
import cn.buptmail.domain.Page;
import cn.buptmail.domain.Staff;
import cn.buptmail.domain.User;
import cn.buptmail.service.UserService;

import java.util.List;
import java.util.Map;

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
        //System.out.println(user.getName());
        if(user.getName() != null){
            return dao.findUserByUsernameAndPassword(user.getName(), user.getPassword());
        }else{
            return dao.findUserByTelAndPassword(user.getTel(), user.getPassword());
        }
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void deleteSelectedUser(String[] ids) {
        for(String id : ids){
            deleteUser(id);
        }
    }

    @Override
    public Page<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        Page<User> page = new Page<>();
        page.setCurrentPage(currentPage);
        page.setRows(rows);
        int totalCount = dao.findTotalCount(condition);
        page.setTotalCount(totalCount);
        if(totalCount == 0) return null;
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findUserByPage(start, rows, condition);
        page.setList(list);
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        page.setTotalPage(totalPage);
        return page;
    }
}
