package com.automation.utilities;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    //whenever you call this class (ConfigurationReader) =>  static block will be executed
    //ConfigurationReader class ==> we need this class to load and to use configuration file
    //to get configuration.properties => call getProperty method
    private static Properties configFile;

    static {
        try {
            //location of properties file
            String path = System.getProperty("user.dir")+"/configuration.properties";
            //get that file as a stream
            FileInputStream input = new FileInputStream(path);
            //create object of Properties class
            configFile = new Properties();
            //load properties file into Properties object
            configFile.load(input);
            //close the input stream at the end
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }
}
