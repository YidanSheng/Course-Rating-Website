package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;
import dao.CourseDAO;
import dao.UserDAO;
import po.Comment;
import po.Course;
import po.User;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/track.do")
public class TrackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String trackname = request.getParameter("name");
		log(trackname);
		List<Course> courseListbyTrack = new ArrayList<>();
		if(trackname.equals("ALL")){
			courseListbyTrack = CourseDAO.displayCourses();
		}
		else{
			courseListbyTrack = CourseDAO.displayCoursebyTrack(trackname);	
		}
			
		if(courseListbyTrack.size() > 0){
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			JSONObject courseList = new JSONObject();
			for(int i = 0; i < courseListbyTrack.size(); i++){
				JSONObject course = new JSONObject(courseListbyTrack.get(i));
				String key = "course" + i;
				courseList.put(key, course);
			}
			PrintWriter out = response.getWriter();	
			out.print(courseList);
			out.flush();		
			out.close();

		}
		else{
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");	
			PrintWriter out = response.getWriter();	
			JSONObject result = new JSONObject("{'course0':'notfound'}");
			out.print(result);		
			out.flush();		
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
