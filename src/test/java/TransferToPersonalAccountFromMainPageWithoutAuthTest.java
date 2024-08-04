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

import java.util.concurrent.TimeUnit;

import static driver.WebDriverCreator.createWebDriver;
import static org.hamcrest.CoreMatchers.equalTo;
import static utils.Utils.randomString;

public class TransferToPersonalAccountFromMainPageWithoutAuthTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = createWebDriver();

    }

    @Test
    public void transferToPersonalAccountWithoutAuth() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        transferToPersonalAccount(objMainPage);
        checkLoginPageIsOpen(objLoginPage);
    }

    @Step("Перейти в личный кабинет с главной страницы")
    public void transferToPersonalAccount(MainPage objMainPage) {
        objMainPage.clickPersonalAccountButton();
    }

    @Step("Проверить, что открыта страница входа")
    public void checkLoginPageIsOpen(LoginPage objLoginPage) {
        objLoginPage.checkLoginButtonIsDisplayed();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
