package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductScreen extends BaseScreen {

    @iOSXCUITFindBy(xpath = "")
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.joom:id/purchase_bar_large_button\"]")
    private WebElement buyProductButton;

    public ProductScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnButtonBuyProduct() {
        waiter.waitForElementToBeClickable(buyProductButton, 500)
                .click();
    }
}
