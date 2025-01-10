package praktikum.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.EnvComfig.EXPLICIT_WAIT;

public class PersonalAccountPage {

    private final WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор отображения кнопки "Выход" в личном кабинете
    private final By personalAccountLogOutButton = By.xpath(".//button[@type='button' and contains(text(), 'Выход')]");
    // Локатор отображения кнопки "Конструктор" в личном кабинете
    private final By personalAccountConstructorButton = By.xpath(".//p[contains(@class, 'AppHeader_header__linkText__3q_va') and contains(text(), 'Конструктор')]");

    @Step("Нажимаю на кнопку \"Выход\" в личном кабинете")
    public void clickPersonalAccountLogOutButton() {
        WebElement inputElement = driver.findElement(personalAccountLogOutButton);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountLogOutButton));
        inputElement.click();
    }

    @Step("Проверяю отображение кнопки \"Выход\" в личном кабинете")
    public void checkPersonalAccountLogOutButton() {
        WebElement inputElement = driver.findElement(personalAccountLogOutButton);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountLogOutButton));
        Assert.assertTrue(inputElement.isDisplayed());
    }

    @Step("Нажимаю на кнопку \"Конструктор\" в личном кабинете")
    public void clickPersonalAccountConstructorButton() {
        WebElement inputElement = driver.findElement(personalAccountConstructorButton);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountConstructorButton));
        inputElement.click();
    }

}