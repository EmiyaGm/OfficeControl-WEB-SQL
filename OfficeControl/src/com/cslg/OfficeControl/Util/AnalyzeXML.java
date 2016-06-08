package com.cslg.OfficeControl.Util;

import java.io.File;
import java.util.List;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class AnalyzeXML {

	@SuppressWarnings("unchecked")
	public String analyze(String name,String filePath) {
		// dom4J的方式解析xml文件
		SAXReader reader = new SAXReader();
		File file = new File(filePath);
		Document document;
		try {
			document = reader.read(file);
			// 获得xml文档中的根元素
			Element rootElement = document.getRootElement();
			List<Element> elements = rootElement.elements();
			@SuppressWarnings("unused")
			List<Element> elements2 = elements.get(0).elements();
			// 用来存放模块对象中的属性值，类似Map，只是K、V都必须是String类型
			Properties properties = new Properties();
			for (Element e : elements) {
				properties.setProperty(e.getName(), e.getText());
			}
			return properties.getProperty(name);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
