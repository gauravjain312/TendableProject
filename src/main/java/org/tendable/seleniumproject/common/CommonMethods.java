package org.tendable.seleniumproject.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Class for Common methods
public class CommonMethods {

    // Get property value from properties file
    private String getProperty(String fileName, String key) {
        String value = null;
        try {
            Properties prop = new Properties();
            InputStream input = new FileInputStream(fileName);
            prop.load(input);
            value = prop.getProperty(key);
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return value;
    }

    // Get value from env.properties file
    public String getEnvPropertyValue(String key) {
        return getProperty("src/main/resources/env.properties", key);
    }

    // Get value from data.properties file
    public String getDataPropertyValue(String key) {
        return getProperty("src/test/resources/data.properties", key);
    }
}