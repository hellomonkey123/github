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
		
		System.out.println("------------��ȡ���ݷ�ʽһ--------------");
		
		String valuee = request.getParameter("username");
		if(valuee!=null && !valuee.trim().equals("")) {
			System.out.println(valuee);
		}
		
		System.out.println("------------��ȡ���ݷ�ʽ��--------------");
		
		Enumeration e = request.getParameterNames();
		while(e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = request.getParameter(name);
			System.out.println(name + "=" + value);
		}
		
		System.out.println("------------��ȡ���ݷ�ʽ��--------------");
		
		String[] values = request.getParameterValues("username");
		for(int i=0;values!=null&&i<values.length;i++) {
			System.out.println(values[i]);
		}
		
		System.out.println("------------��ȡ���ݷ�ʽ��--------------");
		
		Map<String,String[]> map = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, map);  ///��map�����������bean
//			BeanUtils.copyProperties(user, formbean);  bean �Ŀ���
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println(user);
		
		System.out.println("------------��ȡ���ݷ�ʽ��--------------");
		
		InputStream in = request.getInputStream();
		int len = 0;
		byte buffer[] = new byte[1024];
		while((len=in.read(buffer))>=0) {
			System.out.println(len);
			System.out.println(new String(buffer,0,len));
		}
	}

	private void test1(HttpServletRequest request) {
		//��ȡͷ������ط���
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