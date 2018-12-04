package servlet;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*

注册是从注册界面得到username和password，再通过dao层中registe()来向数据库添加一条用户

*/

import dao.UserDAO;
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet{
@Override


protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
this.doPost(req, resp);   // automatically jump -- avoid error 405
}
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  req.setCharacterEncoding("utf-8");
  String username=req.getParameter("username");//get username from register page
  String password=req.getParameter("password");//get password from register page
  String email=req.getParameter("email");////get email from register page
  String registerRes = UserDAO.register(username, password,email);      // insert to db     
  if("Register success" == registerRes) {
	  // Register successfully
	  System.out.println("Register successfully");
	  req.getRequestDispatcher("login.jsp").forward(req, resp); //forward to login.jsp
  }else {
	  // return error message to request
	  req.setAttribute("message", registerRes); 
	  req.getRequestDispatcher("register.jsp").forward(req, resp);
  }
  
}
}

