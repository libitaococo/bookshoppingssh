package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookShopping.model.Admin;



public class LoginFilter implements Filter {

	 public void init(FilterConfig filterConfig) throws ServletException {
         // TODO Auto-generated method stub
        }

     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
     
       // 从session里取管理员信息
      Admin existAdmin = (Admin) session.getAttribute("existAdmin");
      // 登陆页面无需过滤
      if(path.indexOf("/Admin/index.jsp") > -1||path.startsWith("/SecondBookShopping/Admin/images")||path.startsWith("/SecondBookShopping/Admin/styles")||path.startsWith("/SecondBookShopping/Admin/scripts")) {
            chain.doFilter(servletRequest, servletResponse);
          return;
        }
      
            //判断如果没有取到管理员信息,就跳转到登陆页面
      if (existAdmin == null || "".equals(existAdmin)) {
          // 跳转到登陆页面
           servletResponse.sendRedirect("/SecondBookShopping/Admin/index.jsp");
       } else {
             // 已经登陆,继续此次请求
           chain.doFilter(request, response);
       }

   }
    
     
   
   public void destroy() {
         // TODO Auto-generated method stub

    }

}
