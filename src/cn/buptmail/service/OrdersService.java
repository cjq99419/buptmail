package cn.buptmail.service;

import cn.buptmail.domain.Orders;
import cn.buptmail.domain.Page;
import cn.buptmail.domain.Staff;

import java.util.List;
import java.util.Map;

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

    void updateOrder(Orders orders);

    Orders findOrdersById(String id);

    void deleteSelectedOrders(String[] ids);

    Page<Orders> findOrdersByPage(String _currentPage, String _rows, Map<String, String[]> condition);
}
