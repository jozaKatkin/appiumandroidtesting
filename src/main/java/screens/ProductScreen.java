package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductScreen extends BaseScreen {

    @FindBy(xpath = "")
    private WebElement productName;

    public ProductScreen(AndroidDriver driver) {
        super(driver);
    }


}
