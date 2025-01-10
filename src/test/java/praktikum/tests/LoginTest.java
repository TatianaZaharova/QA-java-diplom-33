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
import praktikum.pages.RestorePasswordPage;

public class LoginTest {

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    @DisplayName("Успешный вход по кнопке «Войти в аккаунт» на главной странице")
    public void successLoginFromMainLoginButton() {
        WebDriver driver = factory.getDriver();
        UserCredentials user = UserCredentials.random(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver, user);
        mainPage.open();
        mainPage.clickLoginButton();
        user.createUser(user);
        loginPage.addLoginEmail();
        loginPage.addLoginPassword();
        loginPage.clickLoginButton();
        mainPage.checkOrderButton();
        user.fetchAuthTokenFromLocalStorage();
        user.deleteUser();
    }

    @Test
    @DisplayName("Успешный вход по кнопке \"Личный Кабинет\" на главной странице")
    public void successLoginFromPersonalAccountButton() {
        WebDriver driver = factory.getDriver();
        UserCredentials user = UserCredentials.random(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver, user);
        user.createUser(user);
        mainPage.open();
        mainPage.clickPersonalAccountButton();
        loginPage.addLoginEmail();
        loginPage.addLoginPassword();
        loginPage.clickLoginButton();
        mainPage.checkOrderButton();
        user.fetchAuthTokenFromLocalStorage();
        user.deleteUser();
    }

    @Test
    @DisplayName("Успешный вход по кнопке \"Войти\" на странице регистрации")
    public void successLoginFromRegistrationLoginButton() {
        WebDriver driver = factory.getDriver();
        UserCredentials user = UserCredentials.random(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver, user);
        RegistrationPage registrationPage = new RegistrationPage(driver, user);
        user.createUser(user);
        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.clickRegistrationButton();
        registrationPage.clickRegistrationLoginButton();
        loginPage.addLoginEmail();
        loginPage.addLoginPassword();
        loginPage.clickLoginButton();
        mainPage.checkOrderButton();
        user.fetchAuthTokenFromLocalStorage();
        user.deleteUser();
    }

    @Test
    @DisplayName("Успешный вход по кнопке \"Войти\" на странице восстановления пароля")
    public void successLoginFromRestorePage() {
        WebDriver driver = factory.getDriver();
        UserCredentials user = UserCredentials.random(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver, user);
        RestorePasswordPage restorePasswordPage = new RestorePasswordPage(driver);
        user.createUser(user);
        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.clickRestoreButton();
        restorePasswordPage.clickRestoreLoginButton();
        loginPage.addLoginEmail();
        loginPage.addLoginPassword();
        loginPage.clickLoginButton();
        mainPage.checkOrderButton();
        user.fetchAuthTokenFromLocalStorage();
        user.deleteUser();
    }

}