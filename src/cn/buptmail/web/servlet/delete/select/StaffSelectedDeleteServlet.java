package cn.buptmail.web.servlet.delete.select;

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
 * @date 2020/3/12 0012 下午 03:43
 * @Notes NULL
 */
@WebServlet("/StaffSelectedDeleteServlet")
public class StaffSelectedDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("sid");
        StaffService service = new StaffServiceImpl();
        service.deleteSelectedUser(ids);
        request.getRequestDispatcher("/StaffFindByPageServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
