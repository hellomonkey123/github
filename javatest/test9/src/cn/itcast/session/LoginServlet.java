package cn.itcast.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		
		List<User> list = Db.getAll();
		for(User user : list) {
			if(user.getUsername().equals(username)&&user.getPassword().equals(password)) {
				request.getSession().setAttribute("user", user);
				response.sendRedirect("/test9/index.jsp");
				return;
			}
			
		}
		out.write("用户名或者密码不对！！");
		
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
	public static List list= new ArrayList();
	static {
		list.add(new User("aaa","123"));
		list.add(new User("bbb","123"));
		list.add(new User("ccc","123"));
	}
	
	public static List getAll() {
		return list;
		
	}
	
}



