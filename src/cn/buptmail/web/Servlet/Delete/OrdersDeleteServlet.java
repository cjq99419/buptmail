package cn.buptmail.web.Servlet.Delete;

import cn.buptmail.service.OrdersService;
import cn.buptmail.service.impl.OrdersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/10 0010 下午 06:25
 * @Notes NULL
 */
@WebServlet("/OrdersDeleteServlet")
public class OrdersDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        OrdersService service = new OrdersServiceImpl();
        service.deleteOrder(id);
        response.sendRedirect(request.getContextPath()+"/OrdersListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
