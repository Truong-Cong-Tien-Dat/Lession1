package base.Lab3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class FormyProject {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Smith");
        driver.findElement(By.id("job-title")).sendKeys("Tester");

        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-1")).click();

        driver.findElement(By.id("datepicker")).sendKeys("03/15/2026");

        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.quit();
    }
}