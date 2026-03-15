package base.Lab3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class TestPagesForm {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("123456");

        driver.findElement(By.name("comments")).clear();
        driver.findElement(By.name("comments")).sendKeys("Testing Selenium");

        driver.findElement(By.xpath("//input[@value='cb1']")).click();

        driver.findElement(By.xpath("//input[@value='rd1']")).click();

        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.quit();
    }
}