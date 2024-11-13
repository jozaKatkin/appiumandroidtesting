package elements;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductScreen extends BaseScreen {

    //    @iOSXCUITFindBy(xpath = "")
    @FindBy(xpath = "//android.view.View[@resource-id=\"com.joom:id/product_info_title\"]")
    private WebElement productName;

    //    @iOSXCUITFindBy(xpath = "")
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.joom:id/purchase_bar_large_button\"]")
    private WebElement buyProductButton;

    public ProductScreen(AppiumDriver driver) {
        super(driver);
    }

    public String getProductName() {
        waiter.waitForElementToBeVisible(productName, 300);
        return productName.getText();
    }

    public void clickOnButtonBuyProduct() {
        waiter.waitForElementToBeClickable300Millis(buyProductButton, 500)
                .click();
    }
}
