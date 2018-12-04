package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import dao.CommentDAO;
import dao.CourseDAO;
import dao.FileDAO;
import po.Comment;
import po.Course;

/**
 * Servlet implementation class CourseServlet
 */

@WebServlet("/addcomment.do")
@MultipartConfig
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		req.setCharacterEncoding("utf-8");		
		//String applicationPath = getServletContext().getRealPath("");
		String applicationPath =  "/Users/shengyidan/Desktop/Course_Clip/"; 
		String UPLOAD_DIR = "uploadfile";
		
		
		// constructs path of the directory to save uploaded file		
		String uploadFilePath = applicationPath + UPLOAD_DIR; 
		log(uploadFilePath);
		
		// creates upload folder if it does not exists
		File uploadFolder = new File(uploadFilePath);
		if (!uploadFolder.exists()) {
			uploadFolder.mkdirs();
		}	
				
		//get comment text, courseid, coursename from comment form		
		String content = req.getParameter("contentText");
		Long courseid = Long.parseLong(req.getParameter("courseId"));
		String coursename = req.getParameter("courseName");		
		
		//get current date
		String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	    String createtime = sdf.format(cal.getTime());
	    
	    //fetch userid and username from HTTP Session
	    HttpSession session = req.getSession(false); 
		if(session != null){
			String username = (String) session.getAttribute("username");
			Long userid = Long.parseLong(session.getAttribute("userid").toString());
			int commentid = CommentDAO.AddComment(courseid, userid, content, username, createtime, coursename);
			//upload files
			String filename = req.getPart("fileName").getSubmittedFileName();
			if( filename !=""){
				for(Part filePart: req.getParts()){
					if(filePart.getSubmittedFileName() != null){
						OutputStream out = null;
					    InputStream filecontent = null;	    
				        out = new FileOutputStream(new File(uploadFilePath + File.separator
				                + filePart.getSubmittedFileName()));
				        filecontent = filePart.getInputStream();
				        int read = 0;
				        final byte[] bytes = new byte[1024];
				        while ((read = filecontent.read(bytes)) != -1) {
				            out.write(bytes, 0, read);
				        }	 
				        CommentDAO.AddCommentFile(filePart.getSubmittedFileName(), createtime, commentid);				        		      
					}
					
				}
			}
			//redirect to course detail page
			String url = "course.do?id=" + courseid;
			resp.setContentType("text/html; charset=gb2312");
			resp.sendRedirect(url);
			return;
		}
		else{
			req.setAttribute("inf", "You need to log in before post your comment!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}			
	}
}
