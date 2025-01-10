package praktikum;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.pages.MainPage;

import java.time.Duration;

import static praktikum.EnvComfig.EXPLICIT_WAIT;

public class UserCredentials extends Credentials {
    private String name;
    private String email;
    private String password;
    private final WebDriver driver;

    public UserCredentials(String name, String email, String password, WebDriver driver) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.driver = driver;
    }


    private String accessToken;


    public static UserCredentials random(WebDriver driver) {
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        return new UserCredentials(name, email, password, driver);
    }

    @Step("Получаю accessToken после успешной авторизации")
    public void fetchAuthTokenFromLocalStorage() {
        MainPage mainPage = new MainPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(mainPage.getBunSelector(), 2));

        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
    }

    @Step("Удаляю пользователя")
    public void deleteUser() {
        if (accessToken != null) {
            spec()
                    .header("Authorization", accessToken)
                    .when()
                    .delete("/auth/user")
                    .then().log().all();
        }
    }

    @Step("Создаю пользователя")
    public void createUser(UserCredentials user) {
        spec()
                .body(user)
                .when()
                .post("/auth/register")
                .then().log().all();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}