import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		
		String username=req.getParameter("username");
		String userpass=req.getParameter("userpass");
		LoginValidate lv=new LoginValidate();
		if(lv.validate(username,userpass))
		{
			RequestDispatcher rd=req.getRequestDispatcher("welcomeServlet");
			rd.forward(req, resp);
			//out.print("success");
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
			//out.print("login failed");
		}
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
	}

	
}
