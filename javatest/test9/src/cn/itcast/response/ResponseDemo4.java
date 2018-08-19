package cn.itcast.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo4
 */
@WebServlet("/servlet/ResponseDemo4")
public class ResponseDemo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = this.getServletContext().getRealPath("/download/花姐姐.jpg");
		String file = path.substring(path.lastIndexOf("\\")+1);
		
		//中文文件名的下载 URLEncoder.encode(file,"UTF-8"
		response.setHeader("content-disposition", "attachment;file="+URLEncoder.encode(file,"UTF-8"));
		
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(path);
			int len = 0;
			byte buffer[] = new byte[1024];
			out = response.getOutputStream();
			while((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} finally {
			if(in != null) {
				try {
					in.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(out != null) {
				try {
					out.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
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
