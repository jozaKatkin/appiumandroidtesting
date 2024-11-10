package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigReader;
import utils.Waiter;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static class DriverHolder {
        private static final AndroidDriver DRIVER_INSTANCE = createDriver();
        private static Waiter waiter;

        private static AndroidDriver createDriver() {
            try {
                UiAutomator2Options options = new UiAutomator2Options()
                        .setUdid(ConfigReader.get("device.name"))
                        .setApp(ConfigReader.get("app"))
                        .setPlatformName("Android")
                        .setDeviceName(ConfigReader.get("device.name"))
                        .setAutomationName("UiAutomator2")
                        .setPlatformVersion(ConfigReader.get("platform.version"))
                        .setAppPackage(ConfigReader.get("package"))
                        .setAppActivity(ConfigReader.get("activity"));

                AndroidDriver driver = new AndroidDriver(new URL(ConfigReader.get("appium.server.url")), options);

                waiter = new Waiter(driver);
                waiter.setImplicitWait(5);

                return driver;
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
