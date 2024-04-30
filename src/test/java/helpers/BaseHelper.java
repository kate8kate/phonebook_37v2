package helpers;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseHelper {
    WebDriver driver;

    static Logger logger = LoggerFactory.getLogger(BaseHelper.class);

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    // find elemnt / elements

    protected WebElement findElementBase(By by) {
        logger.info("Locator: findElement: " + by.toString());
        return driver.findElement(by);
    }

    protected List<WebElement> findElementsBase(By by) {
        logger.info("Locator: findElements: " + by.toString());
        return driver.findElements(by);
    }

    protected void clickBase(By by) {
        findElementBase(by).click();
    }

    protected void clickBaseByElement(WebElement element) {
        element.click();
    }

    //-------------------------------------------

    // text

    protected String getTextBaseByLocator(By by) {
        String text = findElementBase(by).getText().trim();
        logger.info("get text from element: " + text);
        return text;
    }

    protected String getTextBaseByElement(WebElement el) {
        return el.getText().trim();
    }

    protected void typeText(String text, By by) {
        WebElement element = findElementBase(by);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    //-------------------------

    // alerts -----------

    public String getTextAlert() {
        Alert alert = driver.switchTo().alert();
        return alert.getText().trim();
    }

    public void clickOkAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // ------------
    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String takeScreenshot() {
        logger.info("start screenshot");
        File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen" + System.currentTimeMillis()
                +".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshot.getPath();
    }
}
