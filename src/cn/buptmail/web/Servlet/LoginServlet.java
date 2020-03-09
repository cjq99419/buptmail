package cn.buptmail.web.Servlet;

import cn.buptmail.domain.User;
import cn.buptmail.service.UserService;
import cn.buptmail.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/7 0007 下午 09:21
 * @Notes NULL
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        HttpSession session = request.getSession();
        String checkCodeSession = (String) session.getAttribute("checkCodeSession");
        session.removeAttribute("checkCodeSession");

        UserService service = new UserServiceImpl();
        User login = service.login(new User(username, password));
        if(checkCodeSession != null && checkCodeSession.equalsIgnoreCase(checkCode)){
            if(login != null){
                session.setAttribute("user", username);
                //response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else{
                request.setAttribute("login_error", "用户名或密码错误");
                request.getRequestDispatcher("/userlogin.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("cc_error", "验证码错误");
            request.getRequestDispatcher("/userlogin.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
