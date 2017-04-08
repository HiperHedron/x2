package web;

import java.io.IOException;  

import java.io.PrintWriter;

//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

//import repositories.DummyUserRepository;
//import repositories.IUserRepository;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private IUserRepository repo;
	
	/*public void init(ServletConfig config){
		repo = new DummyUserRepository();
		//repo = new UserRepoHsqldb();
	}*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        //request.getRequestDispatcher("link.html").include(request, response);  
          
        HttpSession session=request.getSession();
        if(session!=null){  
        String username=(String)session.getAttribute("username");
        String password=(String)session.getAttribute("password");
        String ispremium= (String)session.getAttribute("ispremium");  
        String isadmin= (String)session.getAttribute("isadmin");  
          
        out.print("Hello, "+username+" welcome to Profile"); 
        out.print("<br>"); 
        out.print("Are you a Premium user? : " + ispremium); 
        out.print("<br>"); 
        out.print("Are you an Admin user? : " + isadmin); 
        out.print("<br>"); 
        out.print("Your password : " + password); 
        out.print("<br>"); 
        }  
        /*else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.jsp").include(request, response);  
        }*/
        
        //out.println(us);
        
        out.println("<br>");
        out.println("<a href=\"index.jsp\">Back</a>");
        out.close();  
    }  
}  