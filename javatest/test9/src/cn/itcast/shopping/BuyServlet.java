package cn.itcast.shopping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;


@WebServlet("/servlet/BuyServlet")
public class BuyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		Book book = (Book) Db.getAll().get(id);
		
		HttpSession session = request.getSession();
		
		//从session得到用户用于保存所有书的集合
		List list = (List) session.getAttribute("list");
		if(list==null) {
			list = new ArrayList();
			session.setAttribute("list",list);
		}
		list.add(book);
		
		String url = response.encodeURL(request.getContextPath() + "/servlet/ListCartServlet");
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
