package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import dao.TeachDAO;
import po.Course;
import po.Teach;

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("inf", null);
		Boolean uniqueName = CourseDAO.checkUniqueByName(Long.parseLong(request.getParameter("id")),request.getParameter("name"));
		Boolean uniqueNumber = CourseDAO.checkUniqueByNumber(Long.parseLong(request.getParameter("id")), Long.parseLong(request.getParameter("number")));
		if(!uniqueName || ! uniqueNumber) {
			System.out.println("not unique");
			request.setAttribute("inf", "Course name and number should be unique");
			Course course = new Course();
			course.setId(Long.parseLong(request.getParameter("id")));
			course.setName(request.getParameter("name"));
			course.setNumber(Long.parseLong(request.getParameter("number")));
			course.setTrack(request.getParameter("track"));
			course.setDescription(request.getParameter("description"));
			course.setCommentNum(0);
			request.setAttribute("course", course);
			Long courseId = Long.parseLong(request.getParameter("id"));
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
//				System.out.println(professorNameList.get(i) + "   " + professorLinkList.get(i));
				professorList.add(teach);
			}
			request.setAttribute("professorList", professorList);
			request.getRequestDispatcher("courseEdit.jsp").forward(request, response);
			return;
		}
		String[] professoresName = request.getParameterValues("professorName");
		String[] professoresLink = request.getParameterValues("professorLink");
		System.out.println(professoresName);
		// 获取到前台的属性，赋值到新对象，执行update
		Course course = new Course();
		course.setId(Long.parseLong(request.getParameter("id")));
		course.setName(request.getParameter("name"));
		course.setDescription(request.getParameter("description"));
		course.setTrack(request.getParameter("track"));
		course.setNumber(Long.parseLong(request.getParameter("number")));
		CourseDAO.EditCourse(course);
		// update teach
		// 封装成po
		if(professoresName != null && professoresLink != null) {
			TeachDAO.clear(Long.parseLong(request.getParameter("id"))); 
			for(int i = 0; i < professoresName.length; i++) {
//				System.out.println(professoresName[i]+"   "+professoresLink[i]);
				if(professoresName[i] != null && professoresLink[i] != null) {
					TeachDAO.add(course.getId(), professoresName[i], professoresLink[i]);
				}
			}	
		}else {
			TeachDAO.clear(Long.parseLong(request.getParameter("id")));
		}
		
		List<Course> courseList = CourseDAO.displayCourses();
		request.setAttribute("courseList", courseList);
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
