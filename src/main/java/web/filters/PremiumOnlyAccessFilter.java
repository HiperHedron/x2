package web.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter({"/PremiumOnlyAccessFilter", "premium.jsp"})
public class PremiumOnlyAccessFilter implements Filter {
	
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		System.out.println(session.getCreationTime());

		Enumeration<String> e = session.getAttributeNames();
		while ( e.hasMoreElements() )
		{
		String key = (String)e.nextElement();
		System.out.println( key + " = " + session.getAttribute( key ));
		}
		
			if(null == session.getAttribute("username")){
				response.getWriter().print("Please log in before accessing this page.");
				
				return;
			}else if(null == session.getAttribute("ispremium") || session.getAttribute("ispremium").equals("0")){
				response.getWriter().print("You are not a Premium user.");

				return;
			}
		 
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
