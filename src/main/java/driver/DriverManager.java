package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static class DriverHolder {
        private static final AndroidDriver DRIVER_INSTANCE = createDriver();

        private static AndroidDriver createDriver() {
            try {
                UiAutomator2Options options = new UiAutomator2Options()
                        .setUdid(ConfigReader.getInstance().getProperty("device.name"))
                        .setApp(ConfigReader.getInstance().getProperty("app"))
                        .setPlatformName("Android")
                        .setDeviceName(ConfigReader.getInstance().getProperty("device.name"))
                        .setAutomationName("UiAutomator2")
                        .setPlatformVersion(ConfigReader.getInstance().getProperty("platform.version"))
                        .setAppPackage("com.simplemobiletools.notes")
                        .setAppActivity(".activities.MainActivity");

                return new AndroidDriver(new URL(ConfigReader.getInstance().getProperty("appium.server.url")), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException("invalid URL for Appium Server", e);
            }
        }
    }

    public static AndroidDriver getDriver() {
        return DriverHolder.DRIVER_INSTANCE;
    }

    public static void quitDriver() {
        if (DriverHolder.DRIVER_INSTANCE != null) {
            DriverHolder.DRIVER_INSTANCE.quit();
        }
    }

}
