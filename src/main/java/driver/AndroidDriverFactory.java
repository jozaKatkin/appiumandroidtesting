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
                .setApp(ConfigReader.get("app"))
                .setPlatformName("Android")
                .setDeviceName(ConfigReader.get("device.name"))
                .setAutomationName("UiAutomator2")
                .setPlatformVersion(ConfigReader.get("platform.version"))
                .setAppPackage(ConfigReader.get("package"))
                .setAppActivity(ConfigReader.get("activity"));

        // options for remote run
//        options.setCapability("username", ConfigReader.get("lt.username"));
//        options.setCapability("accessKey", ConfigReader.get("lt.accessKey"));
//        options.setCapability("build", ConfigReader.get("lt.build"));
//        options.setCapability("name", ConfigReader.get("lt.test.name"));

        try {
//            return new AndroidDriver(new URL(ConfigReader.get("lt.url")), options);
            return new AndroidDriver(new URL(ConfigReader.get("appium.server.url")), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("invalid URL for Appium Server", e);
        }
    }
}
