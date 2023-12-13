package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class FunctionsManageFile {
    /**
            * Read the properties file
     * @param propertiesFileName properties file name
     * @return properties
     */
    public Properties readPropertiesFile(String propertiesFileName) {
        Properties prop = new Properties();

        FileInputStream inputVar = null;
        try {
            inputVar = new FileInputStream(
                    new File(getClass().getClassLoader().getResource(propertiesFileName).toURI()));
        } catch (FileNotFoundException | URISyntaxException e) {
            FunctionsLogger.exceptionLog(e);
        }
        try {
            assert inputVar != null;
            prop.load(inputVar);
        } catch (IOException e) {
            FunctionsLogger.exceptionLog(e);
        }
        return prop;
    }
}
