package cn.buptmail.service;

import cn.buptmail.domain.Orders;

import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 下午 03:56
 * @Notes NULL
 */
public interface OrdersService {
    public List<Orders> findAll();

    void addOrder(Orders orders);

    void deleteOrder(String id);
}
