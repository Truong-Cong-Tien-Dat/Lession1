package base.Lab5.login;

import base.Lab5.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTests extends BaseTests {

    @Test
    @DisplayName("TC01 - Login successfully")
    public void testLoginSuccessful(){

        LoginPage loginPage = homePage.clickFormAuthentication();

        loginPage.setUserName("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");

        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

        String alertText = secureAreaPage.getAlertText();

        Assertions.assertTrue(alertText.contains("You logged into a secure area!"));
    }

    @Test
    @DisplayName("TC02 - Wrong password")
    public void testWrongPassword(){

        LoginPage loginPage = homePage.clickFormAuthentication();

        loginPage.setUserName("tomsmith");
        loginPage.setPassword("wrongpassword");

        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

        String alertText = secureAreaPage.getAlertText();

        Assertions.assertTrue(alertText.contains("Your password is invalid!"));
    }

    @Test
    @DisplayName("TC03 - Wrong username")
    public void testWrongUsername(){

        LoginPage loginPage = homePage.clickFormAuthentication();

        loginPage.setUserName("wronguser");
        loginPage.setPassword("SuperSecretPassword!");

        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

        String alertText = secureAreaPage.getAlertText();

        Assertions.assertTrue(alertText.contains("Your username is invalid!"));
    }

    @Test
    @DisplayName("TC04 - Empty username and password")
    public void testEmptyLogin(){

        LoginPage loginPage = homePage.clickFormAuthentication();

        loginPage.setUserName("");
        loginPage.setPassword("");

        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

        String alertText = secureAreaPage.getAlertText();

        Assertions.assertTrue(alertText.contains("Your username is invalid!"));
    }
}