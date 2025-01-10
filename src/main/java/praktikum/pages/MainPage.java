package praktikum.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvComfig;

import java.time.Duration;

import static praktikum.EnvComfig.EXPLICIT_WAIT;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор отображения кнопки входа на главной странице
    private final By loginButton = By.xpath(".//button[contains(text(),'Войти в аккаунт')]");
    // Локатор отображения кнопки оформления заказа на главной странице
    private final By orderButton = By.xpath(".//button[contains(@class, button_button_size_large__G21Vg) and contains(text(), 'Оформить заказ')]");
    // Локатор отображения кнопки "Личный кабинет" на главной странице
    private final By personalAccountButton = By.xpath(".//p[contains(@class, 'AppHeader_header__linkText__3q_va') and text()='Личный Кабинет']");
    // Локатор отображения неактивного элемента конструктора "Начинки"
    private final By noActiveElementFillings = By.cssSelector(".tab_tab__1SPyG:nth-child(3)");
    // Локатор отображения неактивного элемента конструктора "Соусы"
    private final By noActiveElementSauces = By.cssSelector(".tab_tab__1SPyG:nth-child(2)");
    // Локатор отображения неактивного элемента конструктора "Булки"
    private final By noActiveElementBuns = By.cssSelector(".tab_tab__1SPyG:nth-child(1)");
    // Локатор отображения первой начинки в списке начинок
    private final By firstFilling = By.cssSelector(".BurgerIngredient_ingredient__1TVf6:nth-child(1) img[alt='Мясо бессмертных моллюсков Protostomia']");
    // Локатор отображения первого соуса в списке соусов
    private final By firstSauces = By.cssSelector(".BurgerIngredient_ingredient__1TVf6:nth-child(1) img[alt='Соус Spicy-X']");
    // Локатор отображения первой булки в списке булок
    private final By firstBuns = By.cssSelector(".BurgerIngredient_ingredient__1TVf6:nth-child(1) img[alt='Флюоресцентная булка R2-D3']");



    // Геттеры используется в классе UserCredentials
    public By getBunSelector() {
        return bunSelector;
    }

    // Локатор отображения булок на главной странице
    private final By bunSelector = By.cssSelector("a[class^='BurgerIngredient']");

    @Step("Открываю веб страницу")
    public void open() {
        driver.get(EnvComfig.BASE_URL);
    }

    @Step("Нажимаю на кнопку \"Войти в аккаунт\"")
    public void clickLoginButton() {
        WebElement inputElement = driver.findElement(loginButton);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        inputElement.click();
    }

    @Step("Проверяю отображение кнопки \"Оформить заказ\"")
    public void checkOrderButton() {
        WebElement inputElement = driver.findElement(orderButton);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        Assert.assertTrue(inputElement.isDisplayed());
    }

    @Step("Нажимаю на кнопку \"Личный Кабинет\"")
    public void clickPersonalAccountButton() {
        WebElement inputElement = driver.findElement(personalAccountButton);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountButton));
        inputElement.click();
    }

    @Step("Проверяю отображение булок на главной странице")
    public void checkBunSelector() {
        WebElement inputElement = driver.findElement(bunSelector);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(bunSelector));
        Assert.assertTrue(inputElement.isDisplayed());
    }

@Step("Проверяю срабатывание анимации при нажатии на кнопку \"Начинки\"")
public void checkAnimationAfterClickOnFillings() {
    WebElement inputElement = driver.findElement(noActiveElementFillings);
    new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
            .until(ExpectedConditions.visibilityOfElementLocated(noActiveElementFillings));
    inputElement.click();
    new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
            .until(ExpectedConditions.attributeContains(noActiveElementFillings, "class", "current"));
    new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
            .until(driver -> {
                return driver.findElement(firstFilling).getRect().y < 298;
            });
}

@Step("Проверяю срабатывание анимации при нажатии на кнопку \"Соусы\"")
public void checkAnimationAfterClickOnSauces() {
    WebElement inputElement = driver.findElement(noActiveElementSauces);
    new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
            .until(ExpectedConditions.visibilityOfElementLocated(noActiveElementSauces));
    inputElement.click();
    new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
            .until(ExpectedConditions.attributeContains(noActiveElementSauces, "class", "current"));
    new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
            .until(driver -> {
                return driver.findElement(firstSauces).getRect().y < 298;
            });
}

@Step("Проверяю срабатываение анимации при нажатии на кнопку \"Булки\"")
public void checkAnimationAfterClickOnBuns() {
    WebElement bunsElement = driver.findElement(noActiveElementBuns);
    WebElement saucesElement = driver.findElement(noActiveElementSauces);
    new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
            .until(ExpectedConditions.visibilityOfElementLocated(noActiveElementSauces));
    // Сначала нажимаем на "Соусы" т.к. по умолчанию "Булки" уже выбраны
    saucesElement.click();
    new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
            .until(driver -> {
                return driver.findElement(firstSauces).getRect().y < 298;
            });
    new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
            .until(ExpectedConditions.elementToBeClickable(bunsElement));
    bunsElement.click();
    new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
            .until(ExpectedConditions.attributeContains(noActiveElementBuns, "class", "current"));
    new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
            .until(driver -> {
                return driver.findElement(firstBuns).getRect().y < 298;
            });
}


}