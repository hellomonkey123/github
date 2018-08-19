package cn.itcast.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

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
@WebServlet("/servlet/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<a href='/test9/servlet/CookieDemo2'>清除上次的缓存</a><br/>");//链接到清除
		out.println("您上次访问的时间是：");
		
		Cookie[] cookie = request.getCookies();
		for(int i=0;i<cookie.length && cookie!=null;i++) {
			if(cookie[i].getName().equals("lastAccessTime")) {
				long cookieValue = Long.parseLong(cookie[i].getValue());
				Date date = new Date(cookieValue);
				out.print(date.toLocaleString());
			}
		}
		
		Cookie cookie2 = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
		cookie2.setMaxAge(1*30*24*3600);  //有效期一个月
		cookie2.setPath("/test9");       //设置路径
		
		response.addCookie(cookie2);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
