# xprop
Transform XML content to Properties in Java.

Add the xprop.jar to your project and import the br.com.analisasoftware.xprop.XProp class.
Calling the method XProp.xmlToProperties, you can get a Properties variable with the result of the XML's convertion.
Ex.: 

public class Test {<br/>
  public static void main(String args[]){<br/>
    Properties properties = XProp.xmlToProperties("&lt;customer&gt;&lt;id&gt;1&lt;/id&gt;&lt;name&gt;David&lt;/name&gt;&lt;/customer&gt;");
<br/>    System.out.println(properties);<br/>
  }<br/>
}<br/>

The result:

{customer.id=1, customer.name=David, customer=}

You can also convert from a XML file.

Ex.:
public class Test {<br/>
  public static void main(String args[]){
<br/>    Properties properties = XProp.xmlToProperties(XProp.loadFromFile("/home/david/xmlFile.xml"));
<br/>    System.out.println(properties);
  }<br/>
}
<br/>
You can save the result to a Properties file.

Ex.:
public class Test {<br/>
  public static void main(String args[]){
<br/>    Properties properties = XProp.xmlToProperties(XProp.loadFromFile("/home/david/xmlFile.xml"));
<br/>    XProp.saveToFile("/home/david/propertiesFile.properties", properties);
  }<br/>
}<br/>



You can run the JAR file on prompt, converting a XML file to a Properties file.
Ex.:

C:>java -jar xprop.jar "C:\xmlFile.xml" "C:\propertiesFile.properties"

Thank you for using and you are welcome to help the project.
