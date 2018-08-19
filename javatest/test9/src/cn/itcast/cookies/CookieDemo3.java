package cn.itcast.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

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
@WebServlet("/servlet/CookieDemo3")
public class CookieDemo3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		//1.�����վ������Ʒ
		out.write("��Ʒ�б���<br/>");
		Map<String, Book> map = Db.getAll();
		for(Map.Entry<String, Book> entry : map.entrySet()) {
			Book book = entry.getValue();
			out.print("<a href='/test9/servlet/CookieDemo4?id="+book.getId()+"' target='_blank'>"+book.getName()+"</a><br/>");
		}
		
		//2.��ʾ�û�������������Ʒ
		out.println("<br/>���������������Ʒ��<br/>");
		Cookie cookies[] = request.getCookies();
		for(int i=0;i<cookies.length && cookies!=null;i++)
			if(cookies[i].getName().equals("bookHistory")) {
				String ids[] = cookies[i].getValue().split("#");
				for(String id:ids) {
					Book book = (Book) Db.getAll().get(id);
					out.println(book.getName() + "<br/>");
				}
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


class Db{
	private static Map<String, Book> map = new LinkedHashMap();
	
	static{
		map.put("1", new Book("1","javaweb����","����","һ������"));
		map.put("2", new Book("2","spring����","����","һ������"));
		map.put("3", new Book("3","python����","����","һ������"));
		map.put("4", new Book("4","hoodp����","����","һ������"));
		map.put("5", new Book("5","c++����","����","һ������"));
		map.put("6", new Book("6","c#����","����","һ������"));
		map.put("7", new Book("7","jsp����","�Ϻ�","һ������"));
	}

	public static Map getAll() {
		// TODO Auto-generated method stub
		return map;
	}
}

class Book{
	private String id;
	private String name;
	private String author;
	private String description;
	
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String id, String name, String author, String description) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}