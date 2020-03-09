package cn.buptmail.dao.impl;

import cn.buptmail.dao.OrdersDAO;
import cn.buptmail.domain.Orders;
import cn.buptmail.domain.User;
import cn.buptmail.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 下午 03:53
 * @Notes NULL
 */
public class OrdersDAOImpl implements OrdersDAO {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<Orders> findAll() {
        String sql = "select * from orders";
        List<Orders> orders = template.query(sql, new BeanPropertyRowMapper<Orders>(Orders.class));
        return orders;
    }
}
