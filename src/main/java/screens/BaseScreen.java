package screens;

import io.appium.java_client.android.AndroidDriver;
import utils.Waiter;

public abstract class BaseScreen {
    protected AndroidDriver driver;
    protected Waiter waiter;

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter(driver);
    }
}
