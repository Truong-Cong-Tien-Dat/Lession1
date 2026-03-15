package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By formLoginLink = By.linkText("Form Authentication");
    private By javascriptAlertsLink = By.linkText("JavaScript Alerts");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication(){
        driver.findElement(formLoginLink).click();
        return new LoginPage(driver);
    }

    public AlertPage clickJavaScriptAlerts(){
        driver.findElement(javascriptAlertsLink).click();
        return new AlertPage(driver);
    }
}