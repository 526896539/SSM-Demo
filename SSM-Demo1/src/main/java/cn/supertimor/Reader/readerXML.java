package cn.supertimor.Reader;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;




public class readerXML {
	
	public static void main(String[] args) throws ConfigurationException{ 
		String localPath = "Setting/setting.properties";
			PropertiesSetting(localPath);
	    }  
	
	public static  void PropertiesSetting(String localPath) throws ConfigurationException {
		String  valueString = localPath;
	       Configuration config = new PropertiesConfiguration(valueString);  
	       String name = config.getString("name");  
	       System.out.println("name:" + name);
	}
}
	

