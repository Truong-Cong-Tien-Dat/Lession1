package base.Lab3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class SeleniumEasyForm {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");

        driver.findElement(By.name("first_name")).sendKeys("John");
        driver.findElement(By.name("last_name")).sendKeys("Smith");
        driver.findElement(By.name("email")).sendKeys("john@email.com");
        driver.findElement(By.name("phone")).sendKeys("123456789");

        driver.findElement(By.name("address")).sendKeys("Vietnam");
        driver.findElement(By.name("city")).sendKeys("Hanoi");

        driver.findElement(By.name("zip")).sendKeys("10000");

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.quit();
    }
}