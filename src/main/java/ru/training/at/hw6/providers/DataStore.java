package ru.training.at.hw6.providers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataStore {

    protected static Properties PROPERTIES;

    static {
        try (FileInputStream fileInputStream = new FileInputStream(
                "src/test/resources/JdiData.properties")) {
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}

