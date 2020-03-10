package cn.buptmail.web.servlet.find;

import cn.buptmail.domain.Orders;
import cn.buptmail.domain.Staff;
import cn.buptmail.service.OrdersService;
import cn.buptmail.service.StaffService;
import cn.buptmail.service.impl.OrdersServiceImpl;
import cn.buptmail.service.impl.StaffServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/10 0010 下午 09:57
 * @Notes NULL
 */
@WebServlet("/OrdersFindServlet")
public class OrdersFindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        OrdersService service = new OrdersServiceImpl();
        Orders orders = service.findOrdersById(id);
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/update/orders-update.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
