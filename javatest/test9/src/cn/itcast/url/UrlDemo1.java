package cn.itcast.url;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UrlDemo1
 */
@WebServlet("/servlet/UrlDemo1")
public class UrlDemo1 extends HttpServlet {
	
	//web 中地址的表达
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//以下写地址的情况
		//1
		request.getRequestDispatcher("/form.html").forward(request, response);
		
		//2
		response.sendRedirect("/test9/form.html");
		
		//3
		this.getServletContext().getRealPath("/form.html");
		
		//4
		this.getServletContext().getResourceAsStream("/public/foot.jsp");
		
		//5
		/*
		 <a href="/test9/form.html">hfkdsj</a>
		 <form action="/test9/servlet/RequestDemo4" method="post">
		 
		 C:\\  获取硬盘上的资源地址使用  \
		 * */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
