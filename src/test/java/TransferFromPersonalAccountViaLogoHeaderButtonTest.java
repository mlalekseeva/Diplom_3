import API.UserSteps;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalAccountPage;

import java.util.concurrent.TimeUnit;

import static driver.WebDriverCreator.createWebDriver;
import static org.hamcrest.CoreMatchers.equalTo;
import static utils.Utils.randomString;

public class TransferFromPersonalAccountViaLogoHeaderButtonTest {

    private WebDriver driver;

    private User userCreate;

    UserSteps userSteps = new UserSteps();

    private String name = randomString(20);
    private String email = randomString(10) + "@yandex.ru";
    private String password = randomString(6);
    private String token;

    @Before
    public void setUp() {
        driver = createWebDriver();
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        userCreate = new User()
                .withEmail(email)
                .withPassword(password)
                .withName(name);

        Response responseCreate = userSteps.sendPostRequestAuthRegister(userCreate);
        token = responseCreate.path("accessToken").toString();

    }

    @Test
    public void transferViaLogoHeaderButton() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(driver);
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        loginUser(objMainPage, objLoginPage);
        transferToPersonalAccount(objMainPage);
        transferToConstructorViaLogo(objPersonalAccountPage);
        checkConstructorIsOpen(objMainPage);

    }

    @Step("Подговка тестовых данных: пользователь залогинен на сайте")
    public void loginUser(MainPage objMainPage, LoginPage objLoginPage) {
        objMainPage.clickPersonalAccountButton();
        objLoginPage.setUserEmail(email);
        objLoginPage.setUserPassword(password);
        objLoginPage.clickLoginButton();
    }

    @Step("Перейти в личный кабинет с главной страницы")
    public void transferToPersonalAccount(MainPage objMainPage) {
        objMainPage.clickPersonalAccountButton();
    }

    @Step("Перейти в конструктор через кнопку Конструктор")
    public void transferToConstructorViaLogo(PersonalAccountPage objPersonalAccountPage) {
        objPersonalAccountPage.clickLogoHeaderButton();
    }

    @Step("Проверить, что открыт конструктор")
    public void checkConstructorIsOpen(MainPage objMainPage) {
        objMainPage.checkCreateBurgerTextIsDisplayed();
    }

    @After
    public void tearDown() {
        driver.quit();
        Response responseDelete = userSteps.sendDeleteRequestAuthUser(token);
        responseDelete.then().body("success", equalTo(true)).and().body("message", equalTo("User successfully removed"));
    }
}
