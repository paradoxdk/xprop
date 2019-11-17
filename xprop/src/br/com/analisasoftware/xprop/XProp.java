package br.com.analisasoftware.xprop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Properties;
/*
 * XProp is a Java component created to transform XML tags to Properties.
 * CopyRight © 2019 David de Almeida Bezerra Junior
 * Licensed by GNU General Public License (https://www.gnu.org/licenses/gpl-3.0.txt)
 * version: 1.0
 * */
public class XProp {
	public static Properties xmlToProperties (String xml){
		//Loading variables
		Properties properties = new Properties();
		ArrayList<String> arrayListTags = new ArrayList<String>();
		String tag="";
		int tagNumber=0;
		String content="";
		String key="";
		
		boolean tagContent=false;
		
		//It walks the String xml parameter 
		for(int i=0;i<xml.length();i++) {
			//Tag init verification
			if(Character.toString(xml.charAt(i)).equals("<")) {
				tagContent=true;
				tag="";
			}else {
				//Tag ending verification
				if(Character.toString(xml.charAt(i)).equals(">")) {
					tagContent=false;
					//If the tag is a closing tag, writes in the properties variable
					if(tag.startsWith("/")) {
						if(arrayListTags.size()>0) {
							key="";
							for (int j = 0; j < arrayListTags.size(); j++) {
								if(!key.equals("")) {
									key=key+".";
								}
								
								key=key+arrayListTags.get(j);
								
								//While the key already exists increase the tagNumber
								if(properties.getProperty(key)!=null) {
									tagNumber++;
									while(properties.getProperty(key+tagNumber)!=null) {
										System.out.println(key+tagNumber);
										tagNumber++;
									}
									key=key+tagNumber;
									tagNumber=0;
								}
								
							}
							System.out.println(key);
							properties.setProperty(key, content.trim());
							arrayListTags.remove(arrayListTags.size()-1);
							tagNumber=0;
						}
					}else if((!tag.endsWith("/")) && (!tag.endsWith("?")) && (!tag.startsWith("?"))) {
						arrayListTags.add(tag.split(" ")[0].trim());
					}
					tag="";
					content="";
				}else {
					//Verify if is filling the tag name or the tag content
					if(tagContent) {
						tag=tag+Character.toString(xml.charAt(i));
					}else {
						content=content+Character.toString(xml.charAt(i));
					}
				}
			}
		}
		
		return properties;
	}
	
	//Returns the Files's content
	public static String loadFromFile(String path) {
		try {
			File file = new File(path);
			if(!file.exists()) {
				return null;
			}
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line="";
			String content="";
			while((line=bufferedReader.readLine())!=null) {
				content=content+line;
			}
			bufferedReader.close();
			
			return content;
		}catch(Exception exc) {
			exc.printStackTrace();
			return null;
		}
	}
	
	//Writes the properties in a file
	public static boolean saveToFile(String path, Properties properties) {
		try {
			FileWriter fileWriter = new FileWriter(path);
			properties.store(fileWriter, "Made by XProp");
			
			return true;
		}catch(Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}
}
