package cn.buptmail.web.Servlet;

import cn.buptmail.domain.Staff;
import cn.buptmail.service.StaffService;
import cn.buptmail.service.impl.StaffServiceImpl;

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
 * @date 2020/3/9 0009 下午 04:42
 * @Notes NULL
 */
@WebServlet("/StaffListServlet")
public class StaffListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StaffService service = new StaffServiceImpl();
        List<Staff> staffs = service.findAll();
        request.setAttribute("staffs", staffs);
        request.getRequestDispatcher("/stafflist.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
