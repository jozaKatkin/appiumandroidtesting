package elements;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticleScreen extends BaseScreen {

    //    @iOSXCUITFindBy(xpath = "")
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"org.wikipedia.alpha:id/view_news_fullscreen_story_text\"]")
    private WebElement articleText;

    public ArticleScreen(AppiumDriver driver) {
        super(driver);
    }

    public String getArticleText() {
        return waiter.waitForElementToBeVisible300Millis(articleText)
                .getText();
    }
}
