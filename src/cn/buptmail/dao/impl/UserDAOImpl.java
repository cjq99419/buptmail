package cn.buptmail.dao.impl;

import cn.buptmail.dao.UserDAO;
import cn.buptmail.domain.Staff;
import cn.buptmail.domain.User;
import cn.buptmail.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

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

    @Override
    public User findUserByTelAndPassword(String tel, String password) {
        try {
            String sql = "select * from user where tel = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), tel, password);
            return user;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null, ?, ?, ?, ?)";
        template.update(sql, user.getName(), user.getPassword(), user.getTel(), user.getEmail());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id=?";
        template.update(sql, id);
    }

    @Override
    public void update(User user) {
        String sql = "update user set name=?, password=?, tel=?, email=? where id=?";
        template.update(sql, user.getName(), user.getPassword(), user.getTel(), user.getEmail(), user.getId());
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
}

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from user where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<>();
        for(String key : keySet){
            String value = condition.get(key)[0];
            if("currentPage".equals(key) || "rows".equals(key) || "uid".equals(key) || "id".equals(key)) continue;
            if(value != null && !"".equals(value)){
                sb.append(" and " + key + " like ?");
                params.add('%' + value + '%') ;
            }
        }
        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<User> findUserByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for(String key : keySet){
            String value = condition.get(key)[0];
            if("currentPage".equals(key) || "rows".equals(key) || "uid".equals(key) || "id".equals(key)) continue;
            if(value != null && !"".equals(value)){
                sb.append(" and " + key + " like ?");
                params.add('%' + value + '%') ;
            }
        }

        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);
        return template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }
}
