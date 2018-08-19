package xmltest;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Demo3 {

	@Test
	public void read() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/xmltest/Demo1.xml");

		NodeList list = document.getElementsByTagName("b2");
		Node node = list.item(0);
		String content = node.getTextContent();
		System.out.println(content);

	}

	@Test
	public void read1() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/xmltest/Demo1.xml");

		Node root = document.getElementsByTagName("soft").item(0);
		list(root);

	}

	private void list(Node node) {
//		if (node instanceof Element) {
			System.out.println(node.getNodeName());
//		}
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node child = list.item(0);
			list(child);
		}
	}

}
