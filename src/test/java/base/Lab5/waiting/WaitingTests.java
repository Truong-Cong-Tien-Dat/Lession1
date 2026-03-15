package base.Lab5.waiting;

import base.Lab5.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DynamicLoadingPage;

import java.time.Duration;

public class WaitingTests extends BaseTests {

    @Test
    public void testDynamicLoading(){

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        DynamicLoadingPage page = new DynamicLoadingPage(driver);

        page.clickStart();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(page.getLoading()));

        String text = page.getFinishText();

        Assertions.assertEquals("Hello World!", text);
    }
}