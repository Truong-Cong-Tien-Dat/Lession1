package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {

    private WebDriver driver;

    private By buttonJSAlert = By.xpath("//button[contains(text(),'Click for JS Alert')]");
    private By buttonJSConfirm = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
    private By buttonJSPrompt = By.xpath("//button[contains(text(),'Click for JS Prompt')]");
    private By result = By.id("result");

    public AlertPage(WebDriver driver){
        this.driver = driver;
    }

    // ===== JS ALERT =====
    public void clickJSAlert(){
        driver.findElement(buttonJSAlert).click();
    }

    // ===== JS CONFIRM =====
    public void clickJSConfirm(){
        driver.findElement(buttonJSConfirm).click();
    }

    // ===== JS PROMPT =====
    public void clickJSPrompt(){
        driver.findElement(buttonJSPrompt).click();
    }

    // ===== ALERT ACTION =====
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void enterTextToAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    // ===== RESULT TEXT =====
    public String getResult(){
        return driver.findElement(result).getText();
    }
}