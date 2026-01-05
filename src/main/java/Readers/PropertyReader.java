package Readers;

import Logs.LogUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;
import java.util.Properties;

public class PropertyReader {

    public static Properties props = new Properties();

    static {
        try {
            // load all .properties files in src/main/resources
            Collection<File> files = FileUtils.listFiles(new File("src/main/resources"), new String[]{"properties"}, true);
            for (File f : files) {
                try {
                    props.load(FileUtils.openInputStream(f));
                } catch (Exception e) {
                    System.out.println("Error loading properties file: " + e.getMessage());
                }
            }
            // also merge system properties
            props.putAll(System.getProperties());
        } catch (Exception e) {
            LogUtils.error("Error loading properties: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        try {
            return props.getProperty(key);
        } catch (Exception e) {
            LogUtils.error("Error retrieving property '" + key + "': " + e.getMessage());
            return null;
        }
    }
}
