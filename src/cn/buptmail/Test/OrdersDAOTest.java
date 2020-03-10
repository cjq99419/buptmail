package cn.buptmail.Test;

import cn.buptmail.dao.OrdersDAO;
import cn.buptmail.dao.impl.OrdersDAOImpl;
import cn.buptmail.domain.Orders;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 下午 03:58
 * @Notes NULL
 */
public class OrdersDAOTest {
    @Test
    public void findAllTest(){
        OrdersDAO ordersDAO = new OrdersDAOImpl();
        List<Orders> orders = ordersDAO.findAll();
        System.out.println(orders.get(0).getRecipient_name());
    }


}
