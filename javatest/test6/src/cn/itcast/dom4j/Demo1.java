package cn.itcast.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;


public class Demo1 {

	@Test
	public void read() throws Exception {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/exam.xml"));
		
		Element root = document.getRootElement();
		Element stu = (Element) root.elements("student").get(0);//0表示不同子类的序列
		String value = stu.element("location").getText();
		System.out.println(value);
	}
	
	@Test
	public void readatt() throws Exception {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/exam.xml"));
		
		Element root = document.getRootElement();
		Element stu = (Element) root.elements("student").get(2);//0表示不同子类的序列
		String value = stu.element("name").attribute("fu").getStringValue();
		System.out.println(value);
	}
	
	@Test //添加售价
	public void add() throws Exception {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/exam.xml"));
		
		Element root = document.getRootElement().element("student");
		root.addElement("location").setText("dalian");
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("gb2312");
		
		XMLWriter writer =  new XMLWriter(new FileOutputStream("src/exam.xml"),format);
		writer.write(document);  //UTF-8
		writer.close();
		
	}
	
	@Test //指定位置添加售价
	public void add2() throws Exception {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/exam.xml"));
		
		Element root = document.getRootElement().element("student");
		List list = root.elements();
		
		Element location = DocumentHelper.createElement("location");
		location.setText("xian");
		
		list.add(5,location);
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("gb2312");
		
		XMLWriter writer =  new XMLWriter(new FileOutputStream("src/exam.xml"),format);
		writer.write(document);  //UTF-8
		writer.close();
		
	}
	@Test
	public void delete() throws Exception {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/exam.xml"));
		
		Element root = document.getRootElement().element("student").element("location");
		root.getParent().remove(root);
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("gb2312");
		
		XMLWriter writer =  new XMLWriter(new FileOutputStream("src/exam.xml"),format);
		writer.write(document);  //UTF-8
		writer.close();
		
	}
	
	@Test
	public void update() throws Exception {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/exam.xml"));
		
		Element root = document.getRootElement().elements("student").get(0);
		root.elements("location").get(3).setText("46");
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("gb2312");
		
		XMLWriter writer =  new XMLWriter(new FileOutputStream("src/exam.xml"),format);
		writer.write(document);  //UTF-8
		writer.close();
		
	}
}
