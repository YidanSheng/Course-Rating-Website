package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import dao.UserDAO;
import po.Course;
import po.User;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	@Override


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user =  UserDAO.checkLogin(username, password);

		if (user!=null) { // check successfully
			req.getSession().setAttribute("username", username);
			req.getSession().setAttribute("userid", user.getUserId());
			req.getSession().setAttribute("role", user.getRole());
			req.setAttribute("user", user);
			if(user.getRole() == 1) {
				System.out.println("Administrator login");
				req.getRequestDispatcher("/manage.do").forward(req, resp);
			}else {
				System.out.println("Normal user login");
				req.getRequestDispatcher("/homepage.do").forward(req, resp);
			}
		} else { // check failed
			req.setAttribute("inf", "Username or password doesn't match our record, please enter again.");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}

	}
}
