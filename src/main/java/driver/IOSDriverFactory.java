package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSDriverFactory implements DriverFactory {
    public AppiumDriver createDriver() {
        XCUITestOptions options = new XCUITestOptions()
                .setUdid(ConfigReader.get("device.name"))
                .setApp(ConfigReader.get("app"))
                .setPlatformName("iOS")
                .setDeviceName(ConfigReader.get("device.name"))
                .setAutomationName("XCUITest")
                .setPlatformVersion(ConfigReader.get("platform.version"));

        // options for remote run
//        options.setCapability("username", ConfigReader.get("lt.username"));
//        options.setCapability("accessKey", ConfigReader.get("lt.accessKey"));
//        options.setCapability("build", ConfigReader.get("lt.build"));
//        options.setCapability("name", ConfigReader.get("lt.test.name"));

        try {
            return new IOSDriver(new URL(ConfigReader.get("lt.url")), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL for Appium Server", e);
        }
    }
}
