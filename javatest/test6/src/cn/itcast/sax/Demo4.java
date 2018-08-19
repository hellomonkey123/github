package cn.itcast.sax;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Demo4 {
	
	
	public static void main(String[] args) throws DocumentException {
		
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File("src/exam.xml"));
			
		String value = document.selectSingleNode("//name").getText();
		System.out.println(value);
	}

}
