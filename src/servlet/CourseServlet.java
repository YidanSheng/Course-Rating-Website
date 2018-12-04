package servlet;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseDAO;
import dao.FileDAO;
import dao.SubscribeDAO;
import po.Comment;
import po.Course;
import po.UploadDetail;

/**
 * Servlet implementation class CourseServlet
 */

@WebServlet("/course.do")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false); 
		long course_id = Long.parseLong(request.getParameter("id"));
		Course course = CourseDAO.getCourseDetail(course_id);
		Long userid = Long.parseLong(session.getAttribute("userid").toString());
		boolean subscribeState = SubscribeDAO.recordExists(course_id, userid);//ÅÐ¶ÏÊÇ·ñ¶©ÔÄ¹ý
		List<String[]> professorList = CourseDAO.getProfessorList(course_id);
		List<Comment> comments = CourseDAO.getCommentsList(Long.parseLong(request.getParameter("id")));
	
		if(course == null || comments == null) {
			request.getRequestDispatcher("ERROR.jsp").forward(request, response);
		}
		if(subscribeState) {
			request.setAttribute("subState", "Unsubscribe");
		}else {
			request.setAttribute("subState", "Subscribe");
		}
		request.setAttribute("username", request.getSession().getAttribute("username"));
		request.setAttribute("userid", request.getSession().getAttribute("userid"));
		request.setAttribute("course", course);
		request.setAttribute("professorList", professorList);
		request.setAttribute("commentList", comments);
		
		//request.setAttribute("uploadedFiles", fileList);
		
		request.getRequestDispatcher("courseDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
