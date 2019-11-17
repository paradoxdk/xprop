package br.com.analisasoftware.xprop;

import java.util.Properties;

public class Test {
	public static void main(String args[]) {
		String xml="";
		if(args.length>0) {
			String content = XProp.loadFromFile(args[0]);
			if(content!=null) {
				xml=content;
			}else {
				xml=args[0];
			}
		}else {
			xml="<customer ver=\"1\">"
					+ "<id>1</id>"
					+ "<name> David de Almeida Bezerra Junior</name>"
					+ "<address>"
						+ "<place>"
							+ "Fleet Street"
						+ "</place>"
						+ "<number>"
							+ "9"
						+ "</number>"
						+ "<neightborhood>"
							+ "Brooklyn"
						+ "</neightborhood>"
					+ "</address>"
					+ "<telephone>"
						+ "+000000000000"
					+ "</telephone>"
					+ "<telephone>"
						+ "+111111111111"
					+ "</telephone>"
				+ "</customer>";
		}
		Properties properties = XProp.xmlToProperties(xml);
		System.out.println(properties);
		if(args.length>1) {
			XProp.saveToFile(args[1], properties);
		}
	}
}
