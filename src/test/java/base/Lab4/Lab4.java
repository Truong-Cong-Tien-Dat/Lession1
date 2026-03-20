package base.Lab4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class Lab4 {

    private WebDriver driver;

    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
        System.out.println(driver.findElement(By.id("finish")).getText());

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();

        FluentWait<WebDriver> wait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
        System.out.println(driver.findElement(By.id("finish")).getText());

        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        Lab4 test = new Lab4();
        test.setUp();
    }
}
