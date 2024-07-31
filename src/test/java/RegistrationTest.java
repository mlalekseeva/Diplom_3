import elements.ElementsLocatorsRegistratePage;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static driver.WebDriverCreator.createWebDriver;
import static utils.Utils.randomString;

public class RegistrationTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = createWebDriver();
    }

    @Test
    public void createRegistrationSuccessTest() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        fillInNewUserName(objRegistrationPage);
        fillInNewUserEmail(objRegistrationPage);
        fillInNewUserCorrectPassword(objRegistrationPage);
        clickButtonToGetRegistration(objRegistrationPage);
        checkIfRegistrationIsSuccessful(objLoginPage);

    }

    @Test
    public void createRegistrationErrorTest() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        fillInNewUserName(objRegistrationPage);
        fillInNewUserEmail(objRegistrationPage);
        fillInNewUserIncorrectPassword(objRegistrationPage);
        clickButtonToGetRegistration(objRegistrationPage);
        checkIfRegistrationNotSuccessful(objRegistrationPage);

    }

    @Step("Ввести имя нового пользователя")
    public void fillInNewUserName(RegistrationPage objRegistrationPage) {
        objRegistrationPage.setUserName(randomString(10));
    }

    @Step("Ввести email нового пользователя")
    public void fillInNewUserEmail(RegistrationPage objRegistrationPage) {
        objRegistrationPage.setUserEmail(randomString(6) + "yandex.ru");
    }

    @Step("Ввести пароль нового пользователя")
    public void fillInNewUserCorrectPassword(RegistrationPage objRegistrationPage) {
        objRegistrationPage.setUserPassword(randomString(6));
    }

    @Step("Ввести неотвечающий требованиям пароль нового пользователя")
    public void fillInNewUserIncorrectPassword(RegistrationPage objRegistrationPage) {
        objRegistrationPage.setUserPassword(randomString(5));
    }

    @Step("Нажать на кнопку зарегестрироваться")
    public void clickButtonToGetRegistration(RegistrationPage objRegistrationPage) {
        objRegistrationPage.clickRegistrationButton();
    }

    @Step("Проверить, что регистрация прошла успешно")
    public void checkIfRegistrationIsSuccessful(LoginPage objLoginPage) {
        objLoginPage.checkLoginButtonIsDisplayed();
    }

    @Step("Проверить, что регистрация не прошла успешно")
    public void checkIfRegistrationNotSuccessful(RegistrationPage objRegistrationPage) {
        objRegistrationPage.checkIncorrectPasswordTextIsDisplayed();
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
