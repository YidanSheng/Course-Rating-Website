package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import po.Course;

/**
 * Servlet implementation class homepageServlet
 */
@WebServlet("/homepage.do")
public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 登录状态验证  
//		if(request.getSession().getAttribute("username") == "" || request.getSession().getAttribute("username") == null) {
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//			return;
//		}
		List<Course> courseList = CourseDAO.displayCourses();
		request.setAttribute("courseList", courseList);
		request.getRequestDispatcher("homepage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
