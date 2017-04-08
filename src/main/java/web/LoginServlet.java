package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.HSQLDBConnect;
//import repositories.IUserRepository;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//public IUserRepository repo;
	public HSQLDBConnect repo;// = new HSQLDBConnect();
	
	public void init(ServletConfig config){
		//repo = new DummyUserRepository();
		repo = new HSQLDBConnect();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		repo.connectHSQLDB();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        
        //DummyUserRepository repo = new DummyUserRepository();
        	//User u = new User();
        	//new User("Lunatyk","123", true, true)
/*        try {
			if(null == repo.getUserByUsername("Lunatyk")){
				u.setUsername("Lunatyk");
				u.setPassword("123");
				u.setPremium("1");
				u.setAdministrator("1");
			repo.add(u);
			System.out.println("Lynatyk added.");
			try {
				hsqlRepo.insertTestRows();
				hsqlRepo.getRows();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
        	
        try {
			if(repo.getSize()!=0 && null != repo.getUserByUsername(username)){
			    if(pass.equals((repo.getUserByUsername(username)).getPassword())){
			    	System.out.println("login ok");
			    	out.println("<a href=\"ProfileServlet\">Profile</a>");
			    	out.println("<br>");
			    	out.print("Welcome, "+username);  
			        HttpSession session=request.getSession();
			        request.getSession().setAttribute("conf", username);
			        session.setAttribute("username",username);
			        session.setAttribute("password",pass);
			        session.setAttribute("ispremium",(repo.getUserByUsername(username)).isPremium());
			        session.setAttribute("isadmin",(repo.getUserByUsername(username)).isAdministrator());
			    	out.println("<br>");

			        out.println("<a href=\"index.jsp\">Back</a>");
			    }else{
			    	out.println("Username or password incorrect...");
			        out.println("</br>");
			        //request.getRequestDispatcher("login.jsp").include(request, response);
			    }
			}else{
				//response.setContentType("text/html;charset=UTF-8");
			    //PrintWriter out = response.getWriter();
				out.println("Username or password incorrect...");
			    out.println("</br>");
			    //request.getRequestDispatcher("login.jsp").include(request, response);
			    //out.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       
        out.close();
        repo.closeConn();
       
    }  
	
	
}
