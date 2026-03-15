package base.Lab3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class SauceDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.quit();
    }
}