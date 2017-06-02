package reader.xml.file;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MyXMLReader2DOM4J {
	@SuppressWarnings("unchecked")
	public static void main(String arge[]) {
		try {
			File f = new File(MyXMLReader2DOM4J.class.getResource("data.xml")
					.getPath());
			SAXReader reader = new SAXReader();
			Document doc = reader.read(f);
			Element root = doc.getRootElement();
			Element foo;
			for (Iterator<Element> i = root.elementIterator("VALUE"); i.hasNext();) {
				foo = (Element) i.next();
				System.out.print("车牌号码:" + foo.elementText("NO"));
				System.out.println("车主地址:" + foo.elementText("ADDR"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}