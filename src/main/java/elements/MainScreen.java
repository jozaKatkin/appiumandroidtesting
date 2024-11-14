package elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@resource-id=\"org.wikipedia.alpha:id/view_list_card_list\"]//android.widget.FrameLayout")
    private List<WebElement> newsList;

    public MainScreen(AppiumDriver driver) {
        super(driver);
    }

    public String clickOnFirstArticleAndReturnText() {
        int firstArticleIndex = 0;
        WebElement firstArticle = newsList.get(firstArticleIndex);
        String firstArticleText = waiter.waitForElementToBeVisible300Millis(firstArticle)
                .getText();
        waiter.waitForElementToBeClickable300Millis(firstArticle)
                .click();
        return firstArticleText;
    }
}
