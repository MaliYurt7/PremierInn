package com.premierinn.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/** reads the properties file from configuration.properties
 *
 *
 *
 */
public class ConfigurationReader {

    private static Properties properties;

    static {

        try {
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("gordun mu");

        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

}