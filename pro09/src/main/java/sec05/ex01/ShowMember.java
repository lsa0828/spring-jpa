package sec05.ex01;

import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/show")
public class ShowMember extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
        String id ="", pwd="" ;
        Boolean isLogon=false;
        HttpSession session =  request.getSession(false);			

        if(session != null){
        	isLogon=(Boolean)session.getAttribute("isLogon");
            if(isLogon==true){ 
            	id = (String)session.getAttribute("login.id");
            	pwd = (String)session.getAttribute("login.pwd");
            	out.print("<html><body>");
            	out.print("아이디: " + id+"<br>");
            	out.print("비밀번호: " + pwd+"<br>");
            	out.print("</body></html>");
            } else{
            	response.sendRedirect("login3.html");
            }
         } else{
            response.sendRedirect("login3.html");
        }
	}

}
