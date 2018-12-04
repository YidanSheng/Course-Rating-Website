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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import dao.CourseDAO;
import dao.FileDAO;
import po.Comment;
import po.Course;
import po.UploadDetail;

/**
 * Servlet implementation class CourseServlet
 */

@WebServlet("/downloadfile")
public class DownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("filename");	
		response.setContentType(getServletContext().getMimeType(filename));
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		//Get the path of the file
		String applicationPath =  "/Users/shengyidan/Desktop/Course_Clip/uploadfile/"+filename; 
		
		//Read file
		InputStream in = new FileInputStream(applicationPath);
		OutputStream out = response.getOutputStream();
		
		//Write file
		int b;
		while((b=in.read())!= -1)
		{
			out.write(b);
		}
		
		in.close();
		out.close();	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
