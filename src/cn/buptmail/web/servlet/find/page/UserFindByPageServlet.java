package cn.buptmail.web.servlet.find.page;

import cn.buptmail.domain.Page;
import cn.buptmail.domain.User;
import cn.buptmail.service.UserService;
import cn.buptmail.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/12 0012 下午 04:35
 * @Notes NULL
 */
@WebServlet("/UserFindByPageServlet")
public class UserFindByPageServlet extends HttpServlet {
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

        if(map.containsKey("name_condition"))
            condition.put("name", map.get("name_condition"));
        else if(map.containsKey("name"))
            condition.put("name", map.get("name"));
        if(map.containsKey("tel_condition"))
            condition.put("tel", map.get("tel_condition"));
        else if(map.containsKey("tel"))
            condition.put("tel", map.get("tel"));

        UserService service = new UserServiceImpl();
        Page<User> page = service.findUserByPage(currentPage, rows, condition);

        if(page != null && page.getTotalPage() < Integer.parseInt(currentPage)) {
            current_page[0] = currentPage;
            condition.put("currentPage", current_page);
            int currentPg = Integer.parseInt(currentPage) - 1;
            page = service.findUserByPage(String.valueOf(currentPg), rows, condition);
        }
        request.setAttribute("page", page);
        request.setAttribute("condition", condition);
        request.getRequestDispatcher("/list/user-list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
