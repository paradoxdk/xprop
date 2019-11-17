# xprop
Transform XML content to Properties in Java.

Add the xprop.jar to your project and import the br.com.analisasoftware.xprop.XProp class.
Calling the method XProp.xmlToProperties, you can get a Properties variable with the result of the XML's convertion.
Ex.: 

public class Test {
  public static void main(String args[]){
    Properties properties = XProp.xmlToProperties("<customer><id>1</id><name>David</name></customer>");
    System.out.println(properties);
  }
}

The result:

{customer.id=1, customer.name=David, customer=}

You can also convert from a XML file.

Ex.:
public class Test {
  public static void main(String args[]){
    Properties properties = XProp.xmlToProperties(XProp.loadFromFile("/home/david/xmlFile.xml"));
    System.out.println(properties);
  }
}

You can save the result to a Properties file.

Ex.:
public class Test {
  public static void main(String args[]){
    Properties properties = XProp.xmlToProperties(XProp.loadFromFile("/home/david/xmlFile.xml"));
    XProp.saveToFile("/home/david/propertiesFile.properties", properties);
  }
}



You can run the JAR file on prompt, converting a XML file to a Properties file.
Ex.:

C:>java -jar xprop.jar "C:\xmlFile.xml" "C:\propertiesFile.properties"

Thank you for using and you are welcome to help the project.
