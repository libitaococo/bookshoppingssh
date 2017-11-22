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
        // ��������������Ҫ�õ�request,response,session����
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        // ����û������URI
        String path = servletRequest.getRequestURI();
     
       // ��session��ȡ����Ա��Ϣ
      Admin existAdmin = (Admin) session.getAttribute("existAdmin");
      // ��½ҳ���������
      if(path.indexOf("/Admin/index.jsp") > -1||path.startsWith("/SecondBookShopping/Admin/images")||path.startsWith("/SecondBookShopping/Admin/styles")||path.startsWith("/SecondBookShopping/Admin/scripts")) {
            chain.doFilter(servletRequest, servletResponse);
          return;
        }
      
            //�ж����û��ȡ������Ա��Ϣ,����ת����½ҳ��
      if (existAdmin == null || "".equals(existAdmin)) {
          // ��ת����½ҳ��
           servletResponse.sendRedirect("/SecondBookShopping/Admin/index.jsp");
       } else {
             // �Ѿ���½,�����˴�����
           chain.doFilter(request, response);
       }

   }
    
     
   
   public void destroy() {
         // TODO Auto-generated method stub

    }

}
