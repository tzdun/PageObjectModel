package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//**********************************************************************************************************
//Author: Onur Baskirt
//Description: PropertyManager class reads global configurations and use them during test execution.
//**********************************************************************************************************
public class PropertyManager {

    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath;
    private static Properties properties;

    public PropertyManager(String propertyFilePath) {
        PropertyManager.propertyFilePath = propertyFilePath;
    }

    //Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyManager getInstance(String propertyFilePath) {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager(propertyFilePath);
                instance.loadData();
            }
        }
        return instance;
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
    public Properties getProperties(){
        return properties;
    }
}