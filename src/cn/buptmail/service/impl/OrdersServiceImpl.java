package cn.buptmail.service.impl;

import cn.buptmail.dao.OrdersDAO;
import cn.buptmail.dao.impl.OrdersDAOImpl;
import cn.buptmail.domain.Orders;
import cn.buptmail.domain.Page;
import cn.buptmail.domain.Staff;
import cn.buptmail.service.OrdersService;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Override
    public void deleteSelectedOrders(String[] ids) {
        for(String id : ids){
            deleteOrder(id);
        }
    }

    @Override
    public Page<Orders> findOrdersByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        Page<Orders> page = new Page<>();
        page.setCurrentPage(currentPage);
        page.setRows(rows);
        int totalCount = dao.findTotalCount(condition);
        page.setTotalCount(totalCount);
        if(totalCount == 0) return null;
        int start = (currentPage - 1) * rows;
        List<Orders> list = dao.findOrdersByPage(start, rows, condition);
        page.setList(list);
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        page.setTotalPage(totalPage);
        return page;
    }
}
