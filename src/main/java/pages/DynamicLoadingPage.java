package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {

    private WebDriver driver;

    private By startButton = By.xpath("//button[contains(text(),'Start')]");
    private By loading = By.id("loading");
    private By finish = By.id("finish");

    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickStart(){
        driver.findElement(startButton).click();
    }

    public By getLoading(){
        return loading;
    }

    public String getFinishText(){
        return driver.findElement(finish).getText();
    }
}