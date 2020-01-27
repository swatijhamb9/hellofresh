package com.hellofresh.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
/**
 * @author swajhamb
 * This class has methods to read from property file
 *
 */
public class ConfigDataProvider {
	Properties pro;

	public ConfigDataProvider() {

		try {
			File src = new File("./Config/config.properties");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to read config file : " + e.getMessage());
		}

	}

	public String getDataFromConfig(String key) {
		return pro.getProperty(key);

	}

}
