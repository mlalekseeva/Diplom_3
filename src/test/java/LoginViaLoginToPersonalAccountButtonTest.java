import API.UserSteps;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

import static driver.WebDriverCreator.createWebDriver;
import static org.hamcrest.CoreMatchers.equalTo;
import static utils.Utils.randomString;

public class LoginViaLoginToPersonalAccountButtonTest {
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
    public void loginViaLoginToPersonalAccountButton() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        clickStartRegistrationOnMainPage(objMainPage);
        fillInUserEmail(objLoginPage);
        fillInUserPassword(objLoginPage);
        clickFinishLoginButtonOnLoginPage(objLoginPage);
        checkUserIsLoggedIn(objMainPage, objPersonalAccountPage);
    }

    @Step("Нажать на кнопку входа на главной странице")
    public void clickStartRegistrationOnMainPage(MainPage objMainPage) {
        objMainPage.clickLoginToPersonalAccountButton();
    }

    @Step("Заполнить поле email")
    public void fillInUserEmail(LoginPage objLoginPage) {
        objLoginPage.setUserEmail(email);
    }

    @Step("Заполнить поле password")
    public void fillInUserPassword(LoginPage objLoginPage) {
        objLoginPage.setUserPassword(email);
    }

    @Step("Нажать на кнопку входа на странице входа")
    public void clickFinishLoginButtonOnLoginPage(LoginPage objLoginPage) {
        objLoginPage.clickLoginButton();
    }

    @Step("Проверить, что пользователь вошел в систему")
    public void checkUserIsLoggedIn(MainPage objMainPage, PersonalAccountPage objPersonalAccountPage) {
        objMainPage.clickPersonalAccountButton();
        objPersonalAccountPage.checkLogoutButtonIsDisplayed();
    }

    @After
    public void tearDown() {
        driver.quit();
        Response responseDelete = userSteps.sendDeleteRequestAuthUser(token);
        responseDelete.then().body("success", equalTo(true)).and().body("message", equalTo("User successfully removed"));
    }
}
