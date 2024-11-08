package pages;

import io.appium.java_client.android.AndroidDriver;

public abstract class BasePage {
    protected AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }
}
