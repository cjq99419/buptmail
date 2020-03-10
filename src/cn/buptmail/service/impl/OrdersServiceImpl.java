package cn.buptmail.service.impl;

import cn.buptmail.dao.OrdersDAO;
import cn.buptmail.dao.impl.OrdersDAOImpl;
import cn.buptmail.domain.Orders;
import cn.buptmail.service.OrdersService;

import java.util.Date;
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

    @Override
    public void addOrder(Orders orders) {
        orders.setDate(new Date());
        orders.setPrice(orders.getWeight() * 3);
        orders.setStatus("0");
        orders.setLocation(orders.getSender_address());
        dao.add(orders);
    }

    @Override
    public void deleteOrder(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public void updateOrder(Orders orders) {
        if(orders.getDate() == null)
            orders.setDate(new Date());
        orders.setPrice(orders.getWeight() * 3);
        if(orders.getStatus() == null)
        orders.setStatus("0");
        if(orders.getLocation() == null)
        orders.setLocation(orders.getSender_address());
        dao.update(orders);
    }

    @Override
    public Orders findOrdersById(String id) {
        return dao.findOrdersById(Integer.parseInt(id));
    }
}
