package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.CommentDAO;

/**
 * Servlet implementation class ChangeFileInputServlet
 */
@WebServlet("/editcomment.do")
@MultipartConfig
public class ChangeCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String commentid = request.getParameter("id");
		String commentcontent = request.getParameter("commentcontent");
		String inputfilename = request.getParameter("inputname");
		HttpSession session = request.getSession(false); 
		Long userid = Long.parseLong(session.getAttribute("userid").toString());
		
		System.out.println(commentid);
		System.out.println(commentcontent);
		System.out.println(inputfilename.length());
		String filename = request.getPart("fileName").getSubmittedFileName();
		System.out.println(filename.length());
		String applicationPath =  "/Users/shengyidan/Desktop/Course_Clip/"; 
		String UPLOAD_DIR = "uploadfile";	
		String uploadFilePath = applicationPath + UPLOAD_DIR; 
		//get current date
		String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	    String createtime = sdf.format(cal.getTime());
	    CommentDAO.UpdateComment(Long.parseLong(commentid), commentcontent);
	    
		if(filename !="" && inputfilename.length() != 0){		
			CommentDAO.DeleteFile(Long.parseLong(commentid));			
			for(Part filePart: request.getParts()){
				if(filePart.getSubmittedFileName() != null){
					//System.out.println(filePart.getSubmittedFileName());					
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
			        CommentDAO.AddCommentFile(filePart.getSubmittedFileName(), createtime, Integer.parseInt(commentid));				        		        		      
				}				
			}
			System.out.println("1");
			System.out.println(inputfilename.length());
			System.out.println(commentcontent.length());
			System.out.println(filename.length());
		}
		else if((inputfilename.length() == 0)&& (commentcontent.length() == 0)){
			System.out.println("2");
			System.out.println(inputfilename.length());
			System.out.println(commentcontent.length());
			System.out.println(filename.length());
			CommentDAO.DeleteFile(Long.parseLong(commentid));
			CommentDAO.DeleteComment(Long.parseLong(commentid));
		}
		else if((inputfilename.length() == 0)&& (commentcontent.length() != 0)){
			System.out.println("3");
			System.out.println(inputfilename.length());
			System.out.println(commentcontent.length());
			System.out.println(filename.length());
			CommentDAO.DeleteFile(Long.parseLong(commentid));
		}
		else{
			System.out.println("4");
			System.out.println(inputfilename.length());
			System.out.println(commentcontent.length());
			System.out.println(filename.length());
		}

		String url = "userinfo.do?id=" + userid;
		response.setContentType("text/html; charset=gb2312");
		response.sendRedirect(url);
		return;
	}

}
