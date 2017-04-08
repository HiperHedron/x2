package web;

import java.io.IOException;  

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import domain.HSQLDBConnect;
import domain.User;

//import repositories.DummyUserRepository;
//import repositories.IUserRepository;

@WebServlet("/ShowProfilesServlet")
public class ShowProfilesServlet extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//public DummyUserRepository repo;
	public HSQLDBConnect repo;
	public void init(ServletConfig config){
		//repo = new DummyUserRepository();
		repo = new HSQLDBConnect();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException {  
		repo.connectHSQLDB();
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
       
          
        //HttpSession session=request.getSession();
        try {
			if(repo.getSize()!=0){  
      
				for(User u : repo.getRows()/*DummyUserRepository.getDb()*/){
					out.println(u.getUsername() + " | " + u.isPremium());
					out.println("<br>");
				}
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        /*else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.jsp").include(request, response);  
        }*/
        
        //out.println(us);
        
        out.println("<br>");
        out.println("<a href=\"index.jsp\">Back</a>");
        out.close();  
        repo.closeConn();
    }  
}  