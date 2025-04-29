package com.selenium.hybrid.genericrepo;

import java.io.FileInputStream;
import java.util.Properties;

public class FileHandler {

	 public String getDataFromPropertiesFile(String key) throws Exception {
	        FileInputStream fs = new FileInputStream(Paths.filePath);
	        Properties p = new Properties();
	        p.load(fs);
	        return p.getProperty(key);
	   }
}
