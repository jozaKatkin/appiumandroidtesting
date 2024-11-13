package utils;

import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotListener implements AfterEachCallback, TestExecutionExceptionHandler, ILogger {

    private final AppiumDriver driver = DriverManager.getDriver();

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        takeScreenshot(context.getDisplayName());
        throw throwable;
    }

    @Override
    public void afterEach(ExtensionContext context) {
        log().info("Finished: " + context.getDisplayName());
    }

    private void takeScreenshot(String testName) {

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("src", "screenshots", testName + ".png");

        try {
            Files.createDirectories(destination.getParent());
            Files.copy(screenshot.toPath(), destination);
            log().info("Screenshot taken: " + destination);
        } catch (IOException e) {
            log().error("Unable to take screenshot: " + destination, e);
        }
    }
}
