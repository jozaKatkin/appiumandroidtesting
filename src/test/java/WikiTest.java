import elements.Alert;
import elements.ArticleScreen;
import elements.MainScreen;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ILogger;

public class WikiTest extends BaseTest implements ILogger {

    @BeforeEach
    public void doPreconditions() {
        Alert incorretAppVersionAlert = new Alert(driver);
        incorretAppVersionAlert.clickOkButtonIfPresent();
        Alert notificationsAlert = new Alert(driver);
        notificationsAlert.clickAllowButtonIfPresent();
    }

    @Test
    public void firstTest() {
        MainScreen mainScreen = new MainScreen(driver);
        String actualArticleText = mainScreen.clickOnFirstArticleAndReturnText();
        ArticleScreen articleScreen = new ArticleScreen(driver);
        String expectedArticleText = articleScreen.getArticleText();
        Assert.assertTrue("Article texts are different", expectedArticleText.contains(actualArticleText));
    }
}
