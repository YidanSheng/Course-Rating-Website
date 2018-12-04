package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginFilter
 */
 
// todo
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/login.jsp";
        String loginURI2 = request.getContextPath() + "/login.do";
        String loginURI3 = request.getContextPath() + "/register.jsp";
        boolean loggedIn = session != null && session.getAttribute("username") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI) ||request.getRequestURI().equals(loginURI2) || request.getRequestURI().equals(loginURI3) ;

        if (loggedIn || loginRequest) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
    	
    }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}