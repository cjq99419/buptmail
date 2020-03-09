package cn.buptmail.service.impl;

import cn.buptmail.dao.OrdersDAO;
import cn.buptmail.dao.impl.OrdersDAOImpl;
import cn.buptmail.domain.Orders;
import cn.buptmail.service.OrdersService;

import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 下午 03:57
 * @Notes NULL
 */
public class OrdersServiceImpl implements OrdersService {
    private OrdersDAO dao = new OrdersDAOImpl();

    @Override
    public List<Orders> findAll() {
        return dao.findAll();
    }
}
