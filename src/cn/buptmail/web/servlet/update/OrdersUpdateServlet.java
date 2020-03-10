package cn.buptmail.web.servlet.update;

import cn.buptmail.domain.Orders;
import cn.buptmail.service.OrdersService;
import cn.buptmail.service.impl.OrdersServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/10 0010 下午 10:26
 * @Notes NULL
 */
@WebServlet("/OrdersUpdateServlet")
public class OrdersUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Orders order = new Orders();
        try {
            BeanUtils.populate(order, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        OrdersService service = new OrdersServiceImpl();
        service.updateOrder(order);

        response.sendRedirect(request.getContextPath()+"/OrdersListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
