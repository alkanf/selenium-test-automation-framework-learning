package day2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {
Properties propObj = new Properties(); //Java inbuilt class
//Location of file and .load with properties object
FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
propObj.load(file);
//Reading data from properties file
String url = propObj.getProperty("appurl");
System.out.println(url);
//Reading keys from properties file
Set<String> keys = propObj.stringPropertyNames();
for(String key : keys) {
	System.out.println(key);
}
Set<Object> keys2 = propObj.keySet();
System.out.println(keys2); //Call as object if there are multiple data types
//Reading all values from properties file
Collection<Object> values = propObj.values();
System.out.println(values);

file.close();
		
		
		
		
		
	}

}
