import elements.Alert;
import elements.MainScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ILogger;

public class WikiTest extends BaseTest implements ILogger {

    @BeforeEach
    public void doPreconditions() {
        Alert alert = new Alert(driver);
        alert.clickOkButton();
    }

    @Test
    public void firstTest() {
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.scrollUp(3);
    }
}
