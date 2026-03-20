package base.Lab5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class BaseTests {
    protected WebDriver driver;
    protected HomePage homePage;
    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
