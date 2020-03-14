package cn.buptmail.dao;

import cn.buptmail.domain.Orders;

import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 下午 03:52
 * @Notes NULL
 */

public interface OrdersDAO {
    List<Orders> findAll();

    void add(Orders orders);

    void delete(int id);

    void update(Orders order);

    Orders findOrdersById(int id);
}
