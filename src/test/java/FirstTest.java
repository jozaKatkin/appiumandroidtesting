import org.junit.jupiter.api.Test;
import pages.TestPage;
import utils.ILogger;

public class FirstTest extends BaseTest implements ILogger {

    @Test
    public void firstTest() {
        TestPage testPage = new TestPage(driver);
        log().info("App is successfully started");
    }

}
