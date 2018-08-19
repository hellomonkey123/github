package cn.itcast.response;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo6
 */
@WebServlet("/servlet/ResponseDemo6")
public class ResponseDemo6 extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
		
		test3(request, response);
	}
	///实现自动跳转功能
	private void test3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "<meta http-equiv='refresh' content='3;url=/test9/index.jsp'>恭喜您，登陆成功，浏览器将在3秒后，跳到首页。如果没有，请点<a href=''>超链接</a>";
		this.getServletContext().setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private void test2(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("refresh","3;url='/test9/index.jsp'");
		response.getWriter().write("恭喜您，登陆成功，浏览器将在3秒后，跳到首页。如果没有，请点<a href=''>超链接</a>");
	}

	private void test1(HttpServletResponse response) throws IOException {
		response.setHeader("refresh", "3");
		
		String data = new Random().nextInt(1000000)+ "";
		response.getWriter().write(data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
