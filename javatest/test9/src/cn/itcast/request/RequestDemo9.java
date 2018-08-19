package cn.itcast.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo7
 */
@WebServlet("/servlet/RequestDemo9")
public class RequestDemo9 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String referer = request.getHeader("referer");
		
		if(referer==null||!referer.startsWith("http://localhost")) {
			
			response.sendRedirect("/test9/index.jsp");
			return;
		}
		
		String data = "�鿴ͼƬ";  //������ʾ��Щ��Ϣ�ģ����if�������������͹����˷�����
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
