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
		System.out.println(request.getRequestURI());  //��Դ�� /test9/servlet/RequestDemo1
		System.out.println(request.getRequestURL());  //����URL http://localhost:8080/test9/servlet/RequestDemo1
		
		System.out.println(request.getQueryString());//�����������еĲ���
		
		System.out.println(request.getRemoteAddr());//����IP��ַ����host��port
		System.out.println(request.getRemotePort());
		//getLocalAddr ����web������IP��ַ��getLocalName��������getMethod��ÿͻ�������ʽ
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}