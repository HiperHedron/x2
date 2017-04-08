package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter({"/SetPremiumServlet", "adminBlock.jsp"})
public class UserIsNotAdminFilter implements Filter {
	
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		/*HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
			if(null == session.getAttribute("isadmin") || session.getAttribute("isadmin").toString().equals("0")){
				response.getWriter().print("You don't have neccessary privileges...");

				return;
			}else{
				
			}
		
		chain.doFilter(request, response);*/
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		//System.out.println(session.getAttribute("isadmin").toString());
		//System.out.println(session.getAttribute("isadmin"));
			if(null == session.getAttribute("isadmin")){
				response.getWriter().print("You don't have neccessary privileges...");

				return;
			}else if(!session.getAttribute("isadmin").equals("1") ){
				response.getWriter().print("You don't have neccessary privileges...");

				return;
			}
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
