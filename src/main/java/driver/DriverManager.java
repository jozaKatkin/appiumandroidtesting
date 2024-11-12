package driver;

import io.appium.java_client.AppiumDriver;
import utils.ConfigReader;
import utils.Waiter;

public class DriverManager {

    private static class DriverHolder {
        private static final AppiumDriver DRIVER_INSTANCE = createDriver();
        private static Waiter waiter;

        private static AppiumDriver createDriver() {
            DriverFactory factory;
            String platform = ConfigReader.getPlatformName();

            switch (platform.toLowerCase()) {
                case "ios":
                    factory = new IOSDriverFactory();
                    break;
                case "android":
                default:
                    factory = new AndroidDriverFactory();
                    break;
            }
            AppiumDriver driver = factory.createDriver();

            waiter = new Waiter(driver);
            waiter.setImplicitWait(5);

            return driver;
        }
    }

    public static AppiumDriver getDriver() {
        return DriverHolder.DRIVER_INSTANCE;
    }

    public static void quitDriver() {
        if (DriverHolder.DRIVER_INSTANCE != null) {
            DriverHolder.DRIVER_INSTANCE.quit();
        }
    }
}
