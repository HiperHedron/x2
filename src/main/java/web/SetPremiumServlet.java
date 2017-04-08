package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.HSQLDBConnect;



@WebServlet("/SetPremiumServlet")
public class SetPremiumServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
//public IUserRepository repo;
	public HSQLDBConnect repo;
	
	public void init(ServletConfig config){
		//repo = new DummyUserRepository();
		repo = new HSQLDBConnect();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		repo.connectHSQLDB();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("adminBlock.html").include(request, response);
		
		String username = request.getParameter("targetUsername");
		
		try {
			repo.setPremiumPrivilege(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			(repo.getUserByUsername(username)).setPremium("1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		out.print("Target User set to Premium: " + username); 
		out.close();
		repo.closeConn();
	}

	
}
