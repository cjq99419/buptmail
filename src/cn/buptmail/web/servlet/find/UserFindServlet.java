package cn.buptmail.web.servlet.find;

import cn.buptmail.domain.Staff;
import cn.buptmail.domain.User;
import cn.buptmail.service.StaffService;
import cn.buptmail.service.UserService;
import cn.buptmail.service.impl.StaffServiceImpl;
import cn.buptmail.service.impl.UserServiceImpl;

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
@WebServlet("/UserFindServlet")
public class UserFindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/update/user-update.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
