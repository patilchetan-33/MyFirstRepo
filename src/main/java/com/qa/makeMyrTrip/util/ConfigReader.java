package com.qa.makeMyrTrip.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {



    public static String ReadConfigData(String key) throws IOException {
        FileInputStream fs = new FileInputStream("./src/main/resources/config.properties");
        Properties prop = new Properties();
        prop.load(fs);
        return prop.getProperty(key);
    }
}
