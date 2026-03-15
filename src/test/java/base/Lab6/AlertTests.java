package base.Lab6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AlertPage;

public class AlertTests extends BaseTests {

    @Test
    public void testJSAlert(){

        AlertPage alertPage = homePage.clickJavaScriptAlerts();

        alertPage.clickJSAlert();

        alertPage.acceptAlert();

        String result = alertPage.getResult();

        Assertions.assertTrue(result.contains("You successfully clicked an alert"));
    }

    @Test
    public void testJSConfirm(){

        AlertPage alertPage = homePage.clickJavaScriptAlerts();

        alertPage.clickJSConfirm();

        alertPage.dismissAlert();

        String result = alertPage.getResult();

        Assertions.assertTrue(result.contains("You clicked: Cancel"));
    }

    @Test
    public void testJSPrompt(){

        AlertPage alertPage = homePage.clickJavaScriptAlerts();

        alertPage.clickJSPrompt();

        alertPage.enterTextToAlert("Hello");

        alertPage.acceptAlert();

        String result = alertPage.getResult();

        Assertions.assertTrue(result.contains("Hello"));
    }
}