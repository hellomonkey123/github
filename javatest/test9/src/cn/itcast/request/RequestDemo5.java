package cn.itcast.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//����ת�����Լ�ʹ��request���������ݴ���ת����Դ
@WebServlet("/servlet/RequestDemo5")
public class RequestDemo5 extends HttpServlet {
	
	//MVC  (M model javabean; V view jsp;  C controller servlet) important!!!
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String data = "aaaaaa";
		request.setAttribute("data", data);
		
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
