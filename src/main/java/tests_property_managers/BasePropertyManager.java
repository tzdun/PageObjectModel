package tests_property_managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//**********************************************************************************************************
//Author: Onur Baskirt
//Description: BasePropertyManager class reads global configurations and use them during test execution.
//**********************************************************************************************************
public class BasePropertyManager {

    private static String propertyFilePath;
    private Properties properties;

    public BasePropertyManager(String propertyFilePath) {
        BasePropertyManager.propertyFilePath = propertyFilePath;
        loadProperties();
    }

    public BasePropertyManager loadProperties() {
        loadData();
        return this;
    }

    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        properties = new Properties();

        //Read configuration.properties file
        try {
            properties.load(new FileInputStream(propertyFilePath));
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }

    }

    //Get properties
    public Properties getProperties() {
        return properties;
    }
}