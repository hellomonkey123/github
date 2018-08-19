package cn.itcast.sax;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Demo6 {
	
	public static void main(String[] args) throws DocumentException {
		
		String username = "aaa";
		String password = "123";
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/users.xml"));
		
		Node node = document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
		if(node==null) {
			System.out.println("error username or password!");
		}else {
			System.out.println("successfully loading!");
		}
	}

}
