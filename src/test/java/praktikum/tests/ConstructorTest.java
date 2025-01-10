package praktikum.tests;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.DriverRule;
import praktikum.UserCredentials;
import praktikum.pages.LoginPage;
import praktikum.pages.MainPage;



public class ConstructorTest {

    @Rule
    public DriverRule factory = new DriverRule();


    @Test
    @DisplayName("Работа анимации при переходе в раздел конструктора \"Начинки\" ")
    public void fillingsNavigation() {
        WebDriver driver = factory.getDriver();
        UserCredentials user = UserCredentials.random(driver);
        user.createUser(user);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver, user);
        mainPage.open();
        mainPage.checkAnimationAfterClickOnFillings();
        mainPage.clickLoginButton();
        loginPage.addLoginEmail();
        loginPage.addLoginPassword();
        loginPage.clickLoginButton();
        mainPage.checkAnimationAfterClickOnFillings();
        user.deleteUser();
    }

    @Test
    @DisplayName("Работа анимации при переходе в раздел конструктора \"Соусы\" ")
    public void saucesNavigation() {
        WebDriver driver = factory.getDriver();
        UserCredentials user = UserCredentials.random(driver);
        user.createUser(user);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver, user);
        mainPage.open();
        mainPage.checkAnimationAfterClickOnSauces();
        mainPage.clickLoginButton();
        loginPage.addLoginEmail();
        loginPage.addLoginPassword();
        loginPage.clickLoginButton();
        mainPage.checkAnimationAfterClickOnSauces();
        user.deleteUser();
    }

    @Test
    @DisplayName("Работа анимации при переходе в раздел конструктора \"Булки\"")
    public void bunsNavigation() {
        WebDriver driver = factory.getDriver();
        UserCredentials user = UserCredentials.random(driver);
        user.createUser(user);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver, user);
        mainPage.open();
        mainPage.checkAnimationAfterClickOnBuns();
        mainPage.clickLoginButton();
        loginPage.addLoginEmail();
        loginPage.addLoginPassword();
        loginPage.clickLoginButton();
        mainPage.checkAnimationAfterClickOnBuns();
        user.deleteUser();
    }



}