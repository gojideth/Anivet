package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LanguageManager {

    public static Properties generateLanguageProperties(String fileOfLanguage) throws IOException {
        Properties properties = new Properties();
        InputStream input  = new FileInputStream(fileOfLanguage);
        properties.load(input);
        return properties;
    }

    public static void saveLanguageProperties(Properties properties, String fileLanguage) throws IOException, IOException {
        FileOutputStream output = new FileOutputStream(fileLanguage);
        properties.store(output, null);
        output.close();
    }
}
