package base.Lab3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class DemoQAForm {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");

        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Smith");
        driver.findElement(By.id("userEmail")).sendKeys("john@email.com");

        driver.findElement(By.xpath("//label[text()='Male']")).click();

        driver.findElement(By.id("userNumber")).sendKeys("1234567890");

        driver.findElement(By.id("currentAddress")).sendKeys("Vietnam");

        driver.findElement(By.id("submit")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.quit();
    }
}