package cn.buptmail.web.servlet.find.page;

import cn.buptmail.domain.Page;
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
 * @date 2020/3/12 0012 下午 04:35
 * @Notes NULL
 */
@WebServlet("/StaffFindByPageServlet")
public class StaffFindByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if(currentPage == null || "".equals(currentPage) || (Integer.parseInt(currentPage) <= 0)){
            currentPage = "1";
        }
        if(rows == null || "".equals(rows)){
            rows = "10";
        }

        StaffService service = new StaffServiceImpl();
        Page<Staff> page = service.findStaffByPage(currentPage, rows);
        request.setAttribute("page", page);
        System.out.println(page.toString());
        System.out.println(currentPage);
        request.getRequestDispatcher("/list/staff-list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}