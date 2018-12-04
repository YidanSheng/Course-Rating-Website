package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Array;

import dao.CourseDAO;
import dao.TeachDAO;
import po.Course;
import po.Teach;




/**
 * Servlet implementation class CourseServlet
 */

@WebServlet("/editCourse.do")
public class EditCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long courseId = Long.parseLong(request.getParameter("id"));
		Course course = CourseDAO.getCourseDetail(courseId);
		// 获取professor列表
		List<String> professorNameList = TeachDAO.getCourseTeachName(courseId);
		List<String> professorLinkList = TeachDAO.getCourseTeachLink(courseId);
		List<Integer> professorTeachIdList = TeachDAO.getCourseTeachId(courseId);
		// 获取professor list
		// 封装成po 
		List<Teach> professorList = new ArrayList<Teach>();
		for(int i = 0; i < professorNameList.size(); i ++) {
			Teach teach = new Teach();
			teach.setCourseId(courseId);
			teach.setTeachId(professorTeachIdList.get(i));
			teach.setProfessorName(professorNameList.get(i));
			teach.setProfessorLink(professorLinkList.get(i));
//			System.out.println(professorNameList.get(i) + "   " + professorLinkList.get(i));
			professorList.add(teach);
		}
		request.setAttribute("course", course);
		request.setAttribute("courseId", courseId);
		request.setAttribute("professorList", professorList);
		request.getRequestDispatcher("courseEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
