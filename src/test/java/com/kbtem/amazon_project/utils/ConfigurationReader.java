package com.kbtem.amazon_project.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {

        try {
            FileInputStream file = new FileInputStream("src/test/java/com/kbtem/configuration.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException("Configuration reader couldn't find the file.", e);
        }


    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
