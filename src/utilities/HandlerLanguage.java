package utilities;

import java.io.IOException;
import java.util.Properties;

public class HandlerLanguage {
    public String fileName;
    public static String language = "undefined";
    public static Properties languageProperties;

    public HandlerLanguage(String fileName){
        this.fileName = fileName;
    }

    public void loadLanguage() throws IOException {
        Properties handlerproperties = MyUtilities.generateProperties(fileName);
        language = handlerproperties.getProperty("Language");

        languageProperties = MyUtilities.generateProperties(language);
    }

    public void saveLanguage() throws IOException{
        Properties handlerproperties = MyUtilities.generateProperties(fileName);
        handlerproperties.setProperty("Language", language);
        MyUtilities.saveProperties( handlerproperties, fileName);
    }
}
