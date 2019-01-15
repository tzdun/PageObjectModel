package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

import java.io.File;
import java.io.IOException;

public class InsertImagePropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/tests_properties/new_message_properties/insertImage";
    private String relativeImagePath;
    private String canonicalImagePath;
    private String insertImageAssert;

    public InsertImagePropertyManager() {
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