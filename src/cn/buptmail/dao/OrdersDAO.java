package cn.buptmail.dao;

import cn.buptmail.domain.Orders;
import cn.buptmail.domain.User;

import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 下午 03:52
 * @Notes NULL
 */

public interface OrdersDAO {
    public List<Orders> findAll();
}
