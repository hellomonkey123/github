package cn.itcast.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo1
 */
@WebServlet("/servlet/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getRequestURI());  //资源名 /test9/servlet/RequestDemo1
		System.out.println(request.getRequestURL());  //完整URL http://localhost:8080/test9/servlet/RequestDemo1
		
		System.out.println(request.getQueryString());//返回请求行中的参数
		
		System.out.println(request.getRemoteAddr());//除了IP地址还有host，port
		System.out.println(request.getRemotePort());
		//getLocalAddr 返回web服务器IP地址；getLocalName主机名；getMethod获得客户机请求方式
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
