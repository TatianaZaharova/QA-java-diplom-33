package praktikum.tests;


import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.DriverRule;
import praktikum.UserCredentials;
import praktikum.pages.LoginPage;
import praktikum.pages.MainPage;
import praktikum.pages.PersonalAccountPage;

public class PersonalAccountTest {

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    @DisplayName("Переход в личный кабинет пользователя")
    public void successOpenPersonalAccountPage() {
        WebDriver driver = factory.getDriver();
        UserCredentials user = UserCredentials.random(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver, user);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        user.createUser(user);
        mainPage.open();
        mainPage.clickPersonalAccountButton();
        loginPage.addLoginEmail();
        loginPage.addLoginPassword();
        loginPage.clickLoginButton();
        user.fetchAuthTokenFromLocalStorage();
        mainPage.clickPersonalAccountButton();
        personalAccountPage.checkPersonalAccountLogOutButton();
        user.deleteUser();
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    public void successOpenConstructorFromPersonalAccount() {
        WebDriver driver = factory.getDriver();
        UserCredentials user = UserCredentials.random(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver, user);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        user.createUser(user);
        mainPage.open();
        mainPage.clickPersonalAccountButton();
        loginPage.addLoginEmail();
        loginPage.addLoginPassword();
        loginPage.clickLoginButton();
        user.fetchAuthTokenFromLocalStorage();
        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickPersonalAccountConstructorButton();
        mainPage.checkBunSelector();
        user.fetchAuthTokenFromLocalStorage();
        user.deleteUser();
    }

    @Test
    @DisplayName("Выход из аккаунта в личном кабинете")
    public void successLogOutFromPersonalAccount() {
        WebDriver driver = factory.getDriver();
        UserCredentials user = UserCredentials.random(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver, user);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        user.createUser(user);
        mainPage.open();
        mainPage.clickPersonalAccountButton();
        loginPage.addLoginEmail();
        loginPage.addLoginPassword();
        loginPage.clickLoginButton();
        user.fetchAuthTokenFromLocalStorage();
        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickPersonalAccountLogOutButton();
        loginPage.checkLoginPage();
        user.deleteUser();
    }



}