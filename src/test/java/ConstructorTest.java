import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static driver.WebDriverCreator.createWebDriver;
import static org.hamcrest.CoreMatchers.equalTo;

public class ConstructorTest {

    private WebDriver driver;


    @Before
    public void setUp() {
        driver = createWebDriver();

    }

    @Test
    public void transferBetweenSections() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(driver);
        checkOriginalConstructorState(objMainPage);
        checkConstructorStateAfterTransferToSauceSection(objMainPage);
        checkConstructorStateAfterTransferToFillingSection(objMainPage);
        checkConstructorStateAfterTransferToBunSection(objMainPage);

    }

    @Step("Проверка исходного состояния конструктора при открытии главной страницы: выбран раздел Булки, не выбраны разделы Соусы и Начинки")
    public void checkOriginalConstructorState(MainPage objMainPage) {
        Assert.assertTrue(objMainPage.checkBunSectionIsSelected());
        Assert.assertTrue(objMainPage.checkSauceSectionIsUnselected());
        Assert.assertTrue(objMainPage.checkFillingSectionIsUnselected());
    }

    @Step("Проверить состояние конструктора после перехода на раздел Соусы")
    public void checkConstructorStateAfterTransferToSauceSection(MainPage objMainPage) {
        objMainPage.goToSauceSection();
        Assert.assertTrue(objMainPage.checkBunSectionIsUnselected());
        Assert.assertTrue(objMainPage.checkSauceSectionIsSelected());
        Assert.assertTrue(objMainPage.checkFillingSectionIsUnselected());
    }

    @Step("Проверить состояние конструктора после перехода на раздел Соусы")
    public void checkConstructorStateAfterTransferToFillingSection(MainPage objMainPage) {
        objMainPage.goToFillingSection();
        Assert.assertTrue(objMainPage.checkBunSectionIsUnselected());
        Assert.assertTrue(objMainPage.checkSauceSectionIsUnselected());
        Assert.assertTrue(objMainPage.checkFillingSectionIsSelected());
    }

    @Step("Проверить состояние конструктора после перехода на раздел Соусы")
    public void checkConstructorStateAfterTransferToBunSection(MainPage objMainPage) {
        objMainPage.goToBunSection();
        Assert.assertTrue(objMainPage.checkBunSectionIsSelected());
        Assert.assertTrue(objMainPage.checkSauceSectionIsUnselected());
        Assert.assertTrue(objMainPage.checkFillingSectionIsUnselected());
    }

    @After
    public void tearDown() {
        driver.quit();

    }

}
