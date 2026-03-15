package base.Lab2;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;

    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
//        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(375, 812));
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.quit();
    }

    public static void main(String[] args){
        BaseTests test = new BaseTests();
        test.setUp();
    }
}