package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import utils.ILogger;
import utils.Waiter;

import java.time.Duration;
import java.util.Collections;

public abstract class BaseScreen implements ILogger {
    protected AppiumDriver driver;
    protected Waiter waiter;

    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter(driver);
    }

    public void scrollUp(int maxNumberOfScrolls) {
        for (int i = 0; i < maxNumberOfScrolls; i++) {
            Dimension screenSize = driver.manage().window().getSize();
            int startX = screenSize.getWidth() / 2;
            int startY = (int) (screenSize.getHeight() * 0.8);
            int endY = (int) (screenSize.getHeight() * 0.2);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), startX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(swipe));
        }
    }
}
