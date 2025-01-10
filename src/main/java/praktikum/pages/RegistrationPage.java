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

public class RegistrationPage {
    private final WebDriver driver;
    private final UserCredentials user;

    public RegistrationPage(WebDriver driver, UserCredentials user) {
        this.driver = driver;
        this.user = user;
    }

    // Локатор отображения инпута ввода имени на странице регистрации
    private final By registrationNameInput = By.xpath(".//fieldset[contains(@class, 'Auth_fieldset__1QzWN mb-6')][1]//input[@type='text' and @name='name']");
    // Локатор отображения инпута ввода email на странице регистрации
    private final By registrationEmailInput = By.xpath(".//fieldset[contains(@class, 'Auth_fieldset__1QzWN mb-6')][2]//input[@type='text' and @name='name']");
    // Локатор отображения инпута ввода пароля на странице регистрации
    private final By registrationPasswordInput = By.xpath(".//fieldset[contains(@class, 'Auth_fieldset__1QzWN mb-6')][3]//input[@type='password' and @name='Пароль']");
    // Локатор отображения кнопки регистрации на странице регистрации
    private final By registrationButton = By.xpath(".//button[contains(@class, 'button_button_type_primary__1O7Bx') and contains(text(), 'Зарегистрироваться')]");
    // Локатор отображения ошибки некорректного пароля
    private final By errorFailedPassword = By.xpath(".//p[contains(@class, input__error) and contains(text(), 'Некорректный пароль')]");
    // Локатор для кнопки "Войти" на странице регистрации
    private final By registrationLoginButton = By.cssSelector(".Auth_link__1fOlj");


    @Step("Ввожу имя в поле \"Имя\"")
    public void addRegistrationName() {
        WebElement inputElement = driver.findElement(registrationNameInput);
        inputElement.click();
        inputElement.clear();
        inputElement.sendKeys(user.getName());
    }
    @Step("Ввожу адрес электронной почты в поле \"email\"")
    public void addRegistrationEmail() {
        WebElement inputElement = driver.findElement(registrationEmailInput);
        inputElement.click();
        inputElement.clear();
        inputElement.sendKeys(user.getEmail());
    }

    @Step("Ввожу пароль в поле \"Пароль\"")
    public void addRegistrationPassword() {
        WebElement inputElement = driver.findElement(registrationPasswordInput);
        inputElement.click();
        inputElement.clear();
        inputElement.sendKeys(user.getPassword());
    }

    @Step("Нажимаю на кнопку \"Зарегистрироваться\"")
    public void clickRegistrationButton() {
        WebElement inputElement = driver.findElement(registrationButton);
        inputElement.click();
    }

    @Step("Проверяю отображение ошибки валидации пароля")
    public void checkPasswordValidation() {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(errorFailedPassword));
        Assert.assertTrue(driver.findElement(errorFailedPassword).isDisplayed());
    }

    @Step("Нажимаю на кнопку \"Войти\" на странице регистрации")
    public void clickRegistrationLoginButton() {
        WebElement inputElement = driver.findElement(registrationLoginButton);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(registrationLoginButton));
        inputElement.click();
    }

}