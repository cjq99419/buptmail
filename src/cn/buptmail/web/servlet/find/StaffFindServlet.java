package cn.buptmail.web.servlet.find;

import cn.buptmail.domain.Staff;
import cn.buptmail.service.StaffService;
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
@WebServlet("/StaffFindServlet")
public class StaffFindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        StaffService service = new StaffServiceImpl();
        Staff staff = service.findStaffById(id);

        request.setAttribute("currentPage", request.getParameter("currentPage"));
        request.setAttribute("rows", request.getParameter("rows"));
        request.setAttribute("staff_name_condition", request.getParameter("staff_name_condition"));
        request.setAttribute("position_condition", request.getParameter("position_condition"));
        request.setAttribute("staff", staff);
        request.getRequestDispatcher("/update/staff-update.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
