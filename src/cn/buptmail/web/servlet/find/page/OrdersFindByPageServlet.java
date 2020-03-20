package cn.buptmail.web.servlet.find.page;

import cn.buptmail.domain.Orders;
import cn.buptmail.domain.Page;
import cn.buptmail.service.OrdersService;
import cn.buptmail.service.impl.OrdersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/15 0015 下午 05:23
 * @Notes NULL
 */
@WebServlet("/OrdersFindByPageServlet")
public class OrdersFindByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if(currentPage == null || "".equals(currentPage) || (Integer.parseInt(currentPage) <= 0)){
            currentPage = "1";
        }
        if(rows == null || "".equals(rows)){
            rows = "10";
        }
        String[] current_page = new String[1];
        String[] row = new String[1];
        current_page[0] = currentPage;
        row[0] = rows;
        Map<String, String[]> map = request.getParameterMap();
        Map<String, String[]> condition = new HashMap<>();
        condition.put("currentPage", current_page);
        condition.put("rows", row);

        if(map.containsKey("sender_name_condition"))
            condition.put("sender_name", map.get("sender_name_condition"));
        else if(map.containsKey("sender_name"))
            condition.put("sender_name", map.get("sender_name"));
        if(map.containsKey("recipient_name_condition"))
            condition.put("recipient_name", map.get("recipient_name_condition"));
        else if(map.containsKey("recipient_name"))
            condition.put("recipient_name", map.get("recipient_name"));
        
        OrdersService service = new OrdersServiceImpl();
        Page<Orders> page = service.findOrdersByPage(currentPage, rows, condition);

        if(page != null && page.getTotalPage() < Integer.parseInt(currentPage)) {
            current_page[0] = currentPage;
            condition.put("currentPage", current_page);
            int currentPg = Integer.parseInt(currentPage) - 1;
            page = service.findOrdersByPage(String.valueOf(currentPg), rows, condition);
        }
        request.setAttribute("page", page);
        request.setAttribute("condition", condition);
        request.getRequestDispatcher("/list/orders-list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
