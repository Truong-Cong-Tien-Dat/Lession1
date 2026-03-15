package base.Lab3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lab3 {

    private WebDriver driver;

    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        driver.get("https://the-internet.herokuapp.com/login");

        // ===== ID =====
        WebElement userNameElement = driver.findElement(By.id("username"));
        userNameElement.sendKeys("tomsmith");

        // ===== NAME =====
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("SuperSecretPassword!");

        // ===== getAttribute =====
        System.out.println("Attribute name: " +
                userNameElement.getAttribute("name"));

        // ===== XPATH =====
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        // ===== Submit =====
        loginButton.submit();

        driver.navigate().back();

        // ===== tagName =====
        List<WebElement> inputList = driver.findElements(By.tagName("input"));
        System.out.println("Total input elements: " + inputList.size());

        // Loop 1
        for(WebElement element : inputList){
            System.out.println("Element: " + element.getAttribute("name"));
        }

        // Loop 2
        for(int i=0;i<inputList.size();i++){
            System.out.println("Element: " + inputList.get(i).getAttribute("name"));
        }

        // ===== className =====
        WebElement button = driver.findElement(By.className("radius"));

        // ===== cssSelector =====
        WebElement usernameCss = driver.findElement(By.cssSelector("#username"));

        // ===== linkText =====
        driver.findElement(By.linkText("Elemental Selenium")).click();

        driver.navigate().back();

        // ===== partialLinkText =====
        driver.findElement(By.partialLinkText("Elemental")).click();

        driver.navigate().back();

        // ===== getText =====
        System.out.println("Button text: " + button.getText());

        // ===== getTagName =====
        System.out.println("Tag name: " + usernameCss.getTagName());

        // ===== getSize =====
        System.out.println("Size: " + usernameCss.getSize());

        // ===== getCssValue =====
        System.out.println("Color: " + usernameCss.getCssValue("color"));

        // ===== isDisplayed =====
        System.out.println("Displayed: " + usernameCss.isDisplayed());

        // ===== isEnabled =====
        System.out.println("Enabled: " + usernameCss.isEnabled());

        // ===== clear =====
        usernameCss.clear();

        // ===== isSelected =====
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        System.out.println("Checkbox selected: " + checkbox.isSelected());

        // ===== isElementPresent =====
        boolean isPresent = driver.findElements(By.id("username")).size() > 0;
        System.out.println("Username element present: " + isPresent);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.quit();
    }

    public static void main(String[] args){
        Lab3 test = new Lab3();
        test.setUp();
    }
}