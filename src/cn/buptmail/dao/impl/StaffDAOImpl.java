package cn.buptmail.dao.impl;

import cn.buptmail.dao.StaffDAO;
import cn.buptmail.domain.Staff;
import cn.buptmail.domain.User;
import cn.buptmail.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 下午 04:34
 * @Notes NULL
 */
public class StaffDAOImpl implements StaffDAO {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Staff> findAll(){
        String sql = "select * from staff";
        List<Staff> staffs = template.query(sql, new BeanPropertyRowMapper<Staff>(Staff.class));
        return staffs;
    }

}

