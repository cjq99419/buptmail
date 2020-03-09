package cn.buptmail.web.Servlet;

import cn.buptmail.domain.Orders;
import cn.buptmail.service.OrdersService;
import cn.buptmail.service.impl.OrdersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 下午 04:03
 * @Notes NULL
 */
@WebServlet("/OrdersListServlet")
public class OrdersListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrdersService service = new OrdersServiceImpl();
        List<Orders> orders = service.findAll();
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/orderslist.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
