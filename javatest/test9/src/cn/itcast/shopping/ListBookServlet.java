package cn.itcast.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ListBookServlet
 */
@WebServlet("/servlet/ListBookServlet")
public class ListBookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("网站商品列表：<br/>");
		
		request.getSession();
		Map<String, Book> map = Db.getAll();
		for(Map.Entry<String, Book> entry : map.entrySet()) {
			Book book = entry.getValue();
			String url = response.encodeURL(request.getContextPath() + "/servlet/BuyServlet?id="+book.getId());
			out.print(book.getName() + "<a href='"+url+"'target='_blank'>购买</a><br/>");
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
			map.put("1", new Book("1","javaweb开发","老张","一本好书"));
			map.put("2", new Book("2","spring开发","老倪","一本好书"));
			map.put("3", new Book("3","python开发","老李","一本好书"));
			map.put("4", new Book("4","hoodp开发","老王","一本好书"));
			map.put("5", new Book("5","c++开发","老刘","一本好书"));
			map.put("6", new Book("6","c#开发","老夏","一本好书"));
			map.put("7", new Book("7","jsp开发","老何","一本好书"));
		}

		public static Map getAll() {
			// TODO Auto-generated method stub
			return map;
		}
	}

	class Book implements Serializable{
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
