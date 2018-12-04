package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.CourseDAO;
import dao.TeachDAO;
import po.Course;




/**
 * Servlet implementation class CourseServlet
 */

@WebServlet("/addCourse.do")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] professoresName = request.getParameterValues("professorName");
		String[] professoresLink = request.getParameterValues("professorLink");
		
		Course course = new Course();
		course.setName(request.getParameter("name"));
		course.setNumber(Long.parseLong(request.getParameter("number")));
		course.setTrack(request.getParameter("track"));
		course.setDescription(request.getParameter("description"));
		course.setCommentNum(0);
		Boolean uniqueName = CourseDAO.checkUniqueByName(course.getId(),course.getName());
		Boolean uniqueNumber = CourseDAO.checkUniqueByNumber(course.getId(), course.getNumber());
		if(!uniqueName || ! uniqueNumber) {
			request.setAttribute("inf", "Course name and number should be unique");
			request.getRequestDispatcher("courseAdd.jsp").forward(request, response);
			return;
		}
		int newCourseId = CourseDAO.addCourse(course);
		if(professoresName != null && professoresLink != null) {
			Long courseId = CourseDAO.searchByNameAndNumber(course.getName(), course.getNumber()).getId();
			for(int i = 0; i < professoresLink.length; i ++) {
				if(professoresName[i] != null && professoresLink[i] != null) {
					TeachDAO.add(courseId, professoresName[i], professoresLink[i]);
				}
			}
		}
		
		List<Course> courseList = CourseDAO.displayCourses();
		request.setAttribute("courseList", courseList);
		request.setAttribute("newCourseId", newCourseId);
		request.getRequestDispatcher("manage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
