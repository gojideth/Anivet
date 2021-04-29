package utilities;

import java.io.IOException;
import java.util.Properties;

public class LanguageController {
    public String fileName;
    public static String language = "undefined";
    public static Properties propertiesLanguage;

    public LanguageController(String fileName) {
        this.fileName=fileName;
    }

    public void loadLanguage() throws IOException {
        Properties handlerProperties = LanguageManager.generateLanguageProperties(fileName);
        language = handlerProperties.getProperty("Language");
        propertiesLanguage = LanguageManager.generateLanguageProperties(language);
    }

    public void saveLanguage() throws IOException {
        Properties handlerProperties = LanguageManager.generateLanguageProperties(fileName);
        handlerProperties.setProperty("Language", language);
        LanguageManager.saveLanguageProperties(handlerProperties, fileName);
    }


}
