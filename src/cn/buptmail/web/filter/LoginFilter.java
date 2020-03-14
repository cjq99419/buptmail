package cn.buptmail.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/14 0014 下午 11:38
 * @Notes NULL
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();
        if(uri.contains("/user-login.jsp") || uri.contains("/LoginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/CheckCodeServlet")){
            chain.doFilter(req, resp);
        }else{
            Object user = request.getSession().getAttribute("username");
            if(user != null){
                chain.doFilter(request, resp);
            }else{
                request.setAttribute("login_msg", "请先登陆");
                request.getRequestDispatcher("/user-login.jsp").forward(request, resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {
    }

}
