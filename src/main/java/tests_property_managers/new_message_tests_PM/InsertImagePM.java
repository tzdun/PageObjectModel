package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

import java.io.File;
import java.io.IOException;

public class InsertImagePM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/insertImage";
    private String relativeImagePath;
    private String canonicalImagePath;
    private String insertImageAssert;

    public InsertImagePM() {
        super(propertyFilePath);
        relativeImagePath = getProperties().getProperty("relativeImagePath");
        insertImageAssert = getProperties().getProperty("insertImageAssert");
    }

    public static String getPropertyFilePath() {
        return propertyFilePath;
    }

    public String getInsertImageAssert() {
        return insertImageAssert;
    }

    public void setCanonicalImagePath(String relativePathToImage) throws IOException {
        String canonicalPathToImage = new File(relativePathToImage).getCanonicalPath();
        this.canonicalImagePath = canonicalPathToImage;
    }

    public String getCanonicalImagePath() {
        try {
            setCanonicalImagePath(this.relativeImagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return canonicalImagePath;
    }
}