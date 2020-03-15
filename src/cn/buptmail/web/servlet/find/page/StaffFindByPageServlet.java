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
import java.util.HashMap;
import java.util.Map;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/12 0012 下午 04:35
 * @Notes NULL
 */
@WebServlet("/StaffFindByPageServlet")
public class StaffFindByPageServlet extends HttpServlet {
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

        if(map.containsKey("staff_name_condition"))
            condition.put("staff_name", map.get("staff_name_condition"));
        else if(map.containsKey("staff_name"))
            condition.put("staff_name", map.get("staff_name"));
        if(map.containsKey("position_condition"))
            condition.put("position", map.get("position_condition"));
        else if(map.containsKey("position"))
            condition.put("position", map.get("position"));

        StaffService service = new StaffServiceImpl();
        Page<Staff> page = service.findStaffByPage(currentPage, rows, condition);
        request.setAttribute("page", page);
        request.setAttribute("condition", condition);
        request.getRequestDispatcher("/list/staff-list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
