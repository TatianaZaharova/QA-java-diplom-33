package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.EnvComfig.EXPLICIT_WAIT;

public class RestorePasswordPage {
    private final WebDriver driver;

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор отображения кнопки "Войти" на странице восстановления пароля
    private final By restoreLoginButton = By.cssSelector(".Auth_link__1fOlj");

    @Step("Нажимаю на кнопку \"Войти\" на странице восстановления пароля")
    public void clickRestoreLoginButton() {
        WebElement inputElement = driver.findElement(restoreLoginButton);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(restoreLoginButton));
        inputElement.click();
    }
}