package cn.buptmail.dao.impl;

import cn.buptmail.dao.OrdersDAO;
import cn.buptmail.domain.Orders;
import cn.buptmail.domain.Staff;
import cn.buptmail.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

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
        return template.query(sql, new BeanPropertyRowMapper<Orders>(Orders.class));
    }

    @Override
    public void add(Orders orders) {
        Date date = new Date();
        String sql = "insert into orders values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, orders.getSender_name(), orders.getSender_tel(), orders.getSender_address(),
                orders.getRecipient_name(), orders.getRecipient_tel(), orders.getRecipient_address(),
                orders.getType(), orders.getPrice(), orders.getMode_payment(), orders.getWeight(),
                orders.getStatus(), orders.getDate(), orders.getLocation());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from orders where id=?";
        template.update(sql, id);
    }


    
    @Override
    public void update(Orders orders) {
        String sql = "update orders set sender_name=?, sender_tel=?, sender_address=?, " +
                "recipient_name=?, recipient_tel=?, recipient_address=?, " +
                "type=?, price=?, mode_payment=?, weight=?, " +
                "status=?, date=?, location=? where id=?";
        template.update(sql, orders.getSender_name(), orders.getSender_tel(), orders.getSender_address(),
                orders.getRecipient_name(), orders.getRecipient_tel(), orders.getRecipient_address(),
                orders.getType(), orders.getPrice(), orders.getMode_payment(), orders.getWeight(),
                orders.getStatus(), orders.getDate(), orders.getLocation(), orders.getId());
    }

    @Override
    public Orders findOrdersById(int id) {
        String sql = "select * from orders where id=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Orders>(Orders.class), id);
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from orders where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<>();
        for(String key : keySet){
            String value = condition.get(key)[0];
            if("currentPage".equals(key) || "rows".equals(key) || "oid".equals(key) || "id".equals(key)) continue;
            if(value != null && !"".equals(value)){
                sb.append(" and " + key + " like ?");
                params.add('%' + value + '%') ;
            }
        }
        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<Orders> findOrdersByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from orders where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for(String key : keySet){
            String value = condition.get(key)[0];
            if("currentPage".equals(key) || "rows".equals(key) || "sid".equals(key) || "id".equals(key)) continue;
            if(value != null && !"".equals(value)){
                sb.append(" and " + key + " like ?");
                params.add('%' + value + '%') ;
            }
        }

        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);
        return template.query(sb.toString(), new BeanPropertyRowMapper<Orders>(Orders.class), params.toArray());
    }
}
