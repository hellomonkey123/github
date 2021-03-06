package cn.itcast.request;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.UserDatabase;
import org.apache.commons.beanutils.BeanUtils;

import cn.incast.User;




/**
 * Servlet implementation class RequestDemo2
 */
@WebServlet("/servlet/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("------------获取数据方式一--------------");
		
		String valuee = request.getParameter("username");
		if(valuee!=null && !valuee.trim().equals("")) {
			System.out.println(valuee);
		}
		
		System.out.println("------------获取数据方式二--------------");
		
		Enumeration e = request.getParameterNames();
		while(e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = request.getParameter(name);
			System.out.println(name + "=" + value);
		}
		
		System.out.println("------------获取数据方式三--------------");
		
		String[] values = request.getParameterValues("username");
		for(int i=0;values!=null&&i<values.length;i++) {
			System.out.println(values[i]);
		}
		
		System.out.println("------------获取数据方式四--------------");
		
		Map<String,String[]> map = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, map);  ///用map集合数据填充bean
//			BeanUtils.copyProperties(user, formbean);  bean 的拷贝
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println(user);
		
		System.out.println("------------获取数据方式五--------------");
		
		InputStream in = request.getInputStream();
		int len = 0;
		byte buffer[] = new byte[1024];
		while((len=in.read(buffer))>=0) {
			System.out.println(len);
			System.out.println(new String(buffer,0,len));
		}
	}

	private void test1(HttpServletRequest request) {
		//获取头三种相关方法
		String headValue = request.getHeader("Accept-Encoding");
		System.out.println(headValue);
		
		System.out.println("--------------------------");
		
		Enumeration e = request.getHeaders("Accept-Encoding");
		while(e.hasMoreElements()) {
			String value = (String) e.nextElement();
			System.out.println(value);
		}
		
		System.out.println("--------------------------");
		
		e = request.getHeaderNames();
		while(e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = request.getHeader(name);
			System.out.println(name + "=" + value);
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
