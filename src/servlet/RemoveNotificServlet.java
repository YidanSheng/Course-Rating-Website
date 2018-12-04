package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NotificationDAO;

/**
 * Servlet implementation class RemoveNotificServlet
 */
@WebServlet("/remove.do")
public class RemoveNotificServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveNotificServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("You arrive this remove servlet!");
		Long userid = Long.parseLong(request.getParameter("userID"));
		Long courseid = Long.parseLong(request.getParameter("courseID"));
		System.out.println("result: " + userid + ", " + courseid);
		
		NotificationDAO.RemoveRecord(userid, courseid);
		
		// redirect to course detail page
		String url = "course.do?id=" + courseid;
		response.setContentType("text/html; charset=gb2312");
		response.sendRedirect(url);
		return;
	}

}
