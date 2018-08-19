package cn.itcast.sax;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Demo3 {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		SAXParser sp = factory.newSAXParser();
		
		XMLReader reader = sp.getXMLReader();
		
		BeanListHandle handle = new BeanListHandle();
		reader.setContentHandler(handle);
		
		reader.parse("src/exam.xml");	
		
		
		List<Book> list =  handle.getBooks();
		System.out.println(list);
			
	}
}

// 把xml文档中的每一学生封装到一个exam对象中，并把多个exam放到list中 
class BeanListHandle extends DefaultHandler{
	
	private List list = new ArrayList();	
	private String currentTag;
	private Exam exam;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		currentTag = qName;
		if(currentTag.equals("student")) {
			exam = new Exam();
		}
	}



	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		if("name".equals(currentTag)) {
			String name = new String(ch,start,length);
			exam.setName(name);
		}	
		
		if("location".equals(currentTag)) {//如果把currentTag 放前面也会造成空值异常
			String location = new String(ch,start,length);
			exam.setLocation(location);
		}	
		
		if("grade".equals(currentTag)) {
			String grade = new String(ch,start,length);
			exam.setGrade(grade);
		}	
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		
		if(qName.equals("student")) {
			list.add(exam);
			exam = null;
		};
//		currentTag = null;
	}
	
	public List getBooks() {
		return list;
	}
	
	
}