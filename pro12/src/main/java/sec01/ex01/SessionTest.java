package sec01.ex01;

import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/sess")
public class SessionTest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		session.setAttribute("name", "이순신");
		pw.println("<html><body>");
		pw.println("<h1>세션에 이름을 바인딩합니다.<h1>");
		pw.println("<a href='/pro12/test01/session1.jsp'>첫 번째 페이지로 이동하기</a>");
		pw.println("</body></html>");
	}

}
