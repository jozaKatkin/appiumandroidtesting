package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader implements ILogger {
    private final Properties properties;

    private ConfigReader() {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            log().error(e.getMessage());
        }
    }

    private static class Holder {
        private static final ConfigReader INSTANCE = new ConfigReader();
    }

    public static ConfigReader getInstance() {
        return Holder.INSTANCE;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String get(String key) {
        return getInstance().getProperty(key);
    }

    public static String getPlatformName() {
        return System.getenv("PLATFORM_NAME") != null ?
                System.getenv("PLATFORM_NAME") : "Android"; // Default to Android
    }
}
