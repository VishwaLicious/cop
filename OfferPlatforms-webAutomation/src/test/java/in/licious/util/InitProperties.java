package in.licious.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class InitProperties {

	public static Properties initPropertis(String ... propertiesFileNamesWithoutExtension){
		Properties property=new Properties();
		
		try {
			for(String fileName:propertiesFileNamesWithoutExtension){	
				
			// This is the file path for Windows OS	
			//property.load(new FileReader(System.getProperty("user.dir")+"\\config\\"+fileName+".properties"));
			
			// This is the filepath for MAC OS
			property.load(new FileReader(System.getProperty("user.dir")+"/config/config.properties"));
			
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return property;
	}
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
	}
}
