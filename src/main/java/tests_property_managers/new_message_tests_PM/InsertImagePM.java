package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

import java.io.File;
import java.io.IOException;

public class InsertImagePM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/insertImage.properties";
    private String relativePathToImage;
    private String canonicalPathToImage;
    private String insertImageAssert;

    public InsertImagePM() {
        super(propertyFilePath);
        relativePathToImage = getProperties().getProperty("relativePathToImage");
        insertImageAssert = getProperties().getProperty("insertImageAssert");
    }

    public static String getPropertyFilePath() {
        return propertyFilePath;
    }

    public String getInsertImageAssert() {
        return insertImageAssert;
    }

    public void setCanonicalPathToImage(String relativePathToImage) throws IOException {
        String canonicalPathToImage = new File(relativePathToImage).getCanonicalPath();
        this.canonicalPathToImage = canonicalPathToImage;
    }

    public String getCanonicalPathToImage(){
        try {
            setCanonicalPathToImage(this.relativePathToImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return canonicalPathToImage;
    }
}