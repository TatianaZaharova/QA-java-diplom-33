package praktikum.pages;


import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.UserCredentials;

import java.time.Duration;

import static praktikum.EnvComfig.EXPLICIT_WAIT;

public class LoginPage {
    private final WebDriver driver;
    private final UserCredentials user;


    public LoginPage(WebDriver driver, UserCredentials user) {
        this.driver = driver;
        this.user = user;
    }



    // Локатор отображения инпута ввода email на странице логина
    private final By loginEmailInput = By.xpath(".//input[contains(@class, 'input__textfield') and @type='text' and @name='name']");
    // Локатор отображения инпута ввода пароля на странице логина
    private final By loginPasswordInput = By.xpath(".//input[contains(@class, 'text_type_main-default') and @name='Пароль']");
    // Локатор отображения кнопки регистрации на странице логина
    private final By registrationButton = By.cssSelector(".Auth_link__1fOlj[href='/register']");
    // Локатор отображения кнопки входа на странице логина
    private final By loginButton = By.xpath(".//button[contains(@class, button_button_type_primary__1O7Bx) and contains(text(), 'Войти')]");
    // Локатор отображения заголовка страницы логина
    private final By pageNameText = By.xpath(".//h2[contains(text(), 'Вход')]");
    // Локатор отображения кнопки восстановления пароля на странице логина
    private final By loginRestorePassword = By.xpath(".//a[contains(@class, 'Auth_link__1fOlj') and contains(text(), 'Восстановить пароль')]");


    @Step("Нажимаю на кнопку зарегистрироваться на странице входа")
    public void clickRegistrationButton() {
        WebElement inputElement = driver.findElement(registrationButton);
        inputElement.click();
    }

    @Step("Проверяю что отображается название страницы \"Вход\"")
    public void checkLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(pageNameText));
        Assert.assertTrue(driver.findElement(pageNameText).isDisplayed());

    }

    @Step("Ввожу данные в поле email")
    public void addLoginEmail() {
        WebElement inputElement = driver.findElement(loginEmailInput);
        inputElement.click();
        inputElement.clear();
        inputElement.sendKeys(user.getEmail());
    }

    @Step("Ввожу данные в поле password")
    public void addLoginPassword() {
        WebElement inputElement = driver.findElement(loginPasswordInput);
        inputElement.click();
        inputElement.clear();
        inputElement.sendKeys(user.getPassword());
    }

    @Step("Нажимаю на кнопку \"Войти\"")
    public void clickLoginButton() {
        WebElement inputElement = driver.findElement(loginButton);
        inputElement.click();
    }

    @Step("Нажимаю на кнопку восстановления пароля")
    public void clickRestoreButton() {
        WebElement inputElement = driver.findElement(loginRestorePassword);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(loginRestorePassword));
        inputElement.click();
    }


}