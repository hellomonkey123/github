package cn.itcast.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.chart.PieChart.Data;

/**
 * Servlet implementation class CookieDemo1
 */
@WebServlet("/servlet/CookieDemo4")
public class CookieDemo4 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//根据用户带过来的id，显示相应商品的详细信息
		String id = request.getParameter("id");
		Book book = (Book) Db.getAll().get(id);	
		out.write(book.getId() + "<br/>");
		out.write(book.getAuthor() + "<br/>");
		out.write(book.getName() + "<br/>");
		out.write(book.getDescription() + "<br/>");
		
		//构建cookie，回写给浏览器
		String cookieValue = buildCookie(id,request);
		Cookie cookie = new Cookie("bookHistory", cookieValue);
		cookie.setMaxAge(1*30*24*3600);
		cookie.setPath("/test9");
		response.addCookie(cookie);
		
	}

	private String buildCookie(String id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String bookHistory = null;
		Cookie[] cookies = request.getCookies();
		for(int i=0;i<cookies.length && cookies!=null;i++)
			if(cookies[i].getName().equals("bookHistory")) {
				bookHistory = cookies[i].getValue();
			}
		//带回为空
		if(bookHistory==null) {
			return id;
		}
		
		LinkedList<String> list = new LinkedList(Arrays.asList(bookHistory.split("#")));
		
		if(list.contains(id)) {
			list.remove(id);
		}else {
			if(list.size()>3) {
				list.removeLast();
			}
		}
		list.addFirst(id);
		
		StringBuffer buffer = new StringBuffer();
		for(String bid:list) {
			buffer.append(bid + "#");
		}
		
		return buffer.deleteCharAt(buffer.length()-1).toString();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
