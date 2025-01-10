package praktikum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.DriverRule;
import praktikum.UserCredentials;
import praktikum.pages.LoginPage;
import praktikum.pages.MainPage;
import praktikum.pages.RegistrationPage;

public class RegistrationTest {



    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    @DisplayName("Проверка успешной регистрации пользователя")
    public void successRegistration() {
        WebDriver driver = factory.getDriver();
        UserCredentials user = UserCredentials.random(driver);
        var mainPage = new MainPage(driver);
        var loginPage = new LoginPage(driver, user);
        var registrationPage = new RegistrationPage(driver, user);
        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.clickRegistrationButton();
        registrationPage.addRegistrationName();
        registrationPage.addRegistrationEmail();
        registrationPage.addRegistrationPassword();
        registrationPage.clickRegistrationButton();
        loginPage.checkLoginPage();
        loginPage.addLoginEmail();
        loginPage.addLoginPassword();
        loginPage.clickLoginButton();
        user.fetchAuthTokenFromLocalStorage();
        user.deleteUser();
    }

    @Test
    @DisplayName("Проверка ошибки регистрации, если пароль содержит менее 6-ти символов")
    public void failedRegistrationWithShortPass() {
        WebDriver driver = factory.getDriver();
        UserCredentials user = UserCredentials.random(driver);
        user.setPassword("12345");
        var mainPage = new MainPage(driver);
        var loginPage = new LoginPage(driver, user);
        var registrationPage = new RegistrationPage(driver, user);
        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.clickRegistrationButton();
        registrationPage.addRegistrationName();
        registrationPage.addRegistrationEmail();
        registrationPage.addRegistrationPassword();
        registrationPage.clickRegistrationButton();
        registrationPage.checkPasswordValidation();
    }
}