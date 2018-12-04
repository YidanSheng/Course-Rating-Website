package servlet;
//written by Tianrou

import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SubscribeDAO;

/**
 * Servlet implementation class Subscribe
 */
@WebServlet("/subscribe.do")
public class SubscribeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubscribeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//fetch userid and username from HTTP Session
		boolean subState = false;
	    HttpSession session = request.getSession(false); 
	    String data_courseid = "";
	    if(request.getParameter("dataid") == null || request.getParameter("dataid").isEmpty()) {
	    	data_courseid = "";
	    }else {
	    	data_courseid = request.getParameter("dataid").trim();
	    }
		if(session != null){
			String username = (String) session.getAttribute("username");
			Long userid = Long.parseLong(session.getAttribute("userid").toString());
			Long courseid = Long.parseLong(data_courseid);
			subState = SubscribeDAO.recordExists(courseid, userid);
			if(subState) {
				subState = !SubscribeDAO.unsubscribe(userid, courseid);
			}else {
				subState = SubscribeDAO.subscribe(username, userid, courseid);
			}
			JSONObject data = new JSONObject();
			data.put("state", subState);
			PrintWriter out = response.getWriter();	
			out.print(data);
			out.flush();		
			out.close();
		}else{
			request.setAttribute("inf", "You need to log in first!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
