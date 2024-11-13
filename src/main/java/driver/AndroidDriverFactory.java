package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverFactory implements DriverFactory {

    public AppiumDriver createDriver() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(ConfigReader.get("device.name"))
                .setApp(ConfigReader.get("android.app"))
                .setPlatformName("Android")
                .setDeviceName(ConfigReader.get("device.name"))
                .setAutomationName("UiAutomator2")
                .setPlatformVersion(ConfigReader.get("platform.version"))
                .setAppPackage(ConfigReader.get("package"))
                .setAppActivity(ConfigReader.get("activity"));

        try {
            return new AndroidDriver(new URL(ConfigReader.get("appium.server.url")), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("invalid URL for Appium Server", e);
        }
    }
}
