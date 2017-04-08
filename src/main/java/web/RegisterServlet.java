package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.HSQLDBConnect;
import domain.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{

	//public IUserRepository repo;
	public HSQLDBConnect repo;
	public void init(ServletConfig config){
		//repo = new DummyUserRepository();
		repo = new HSQLDBConnect();
	}
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		repo.connectHSQLDB();
		if(request.getParameter("password").equals(request.getParameter("confirmPassword"))){
			User u = retrieveUserFromRequest(request, response); 
			try {
				repo.add(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("registeredOk.jsp");
		}else{
			response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
			out.println("Passwords are not the same.");
            out.println("</br>");
            request.getRequestDispatcher("registerNewUser.jsp").include(request, response);
            out.close();
		}
		
		repo.closeConn();
		//request.getSession().setAttribute("conf", u);
		
		
	}
	
	
	private User retrieveUserFromRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		User user = new User();//new User("admin","admin",true,true);
		
		user.setUsername(request.getParameter("username"));
		
		user.setPassword(request.getParameter("password"));
		user.setPremium("0");
		user.setAdministrator("0");
		
		
		/*
		 * else{
			response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
			out.println("Passwords are not the same.");
            out.println("</br>");
            request.getRequestDispatcher("registerNewUser.jsp").include(request, response);
            out.close();
            return user;
		}
		 */
		
		return user;
		
		
		
	}
	
	boolean validatePasswords(String a, String b){
		if(a.equals(b))
			return true;
		return false;
	}
	
}
