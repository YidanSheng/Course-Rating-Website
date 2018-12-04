package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;
import po.Comment;
import po.File;

/**
 * Servlet implementation class EditComment
 */
@WebServlet("/EditComment")
public class EditCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String commentid = request.getParameter("comment");
		List<Comment> comments = CommentDAO.CommentListByCommentId(Long.parseLong(commentid));
		String fileNames = "";
		for(Comment c: comments){
			for(File a: c.getFileList()){
				fileNames += a.getFileName() + ",";
			}
		}
		if(fileNames.length() == 0){
			fileNames = "";
		}
		else{
			fileNames = fileNames.substring(0,fileNames.length()-1);
		}
		
		
		request.setAttribute("commentList", comments);
		request.setAttribute("fileList", fileNames);
		
		request.getRequestDispatcher("EditComment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
