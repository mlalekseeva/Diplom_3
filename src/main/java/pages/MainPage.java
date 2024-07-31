package pages;

import elements.ElementsLocatorsMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    ElementsLocatorsMainPage objElementsLocatorsMainPage = new ElementsLocatorsMainPage();

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginToPersonalAccountButton() {
        driver.findElement(objElementsLocatorsMainPage.loginToPersonalAccountButton).click();
    }

    public void checkCreateOrderButtonIsDisplayed() {
        driver.findElement(objElementsLocatorsMainPage.createOrderButton).isDisplayed();
    }

    public void clickPersonalAccountButton() {
        driver.findElement(objElementsLocatorsMainPage.personalAccountButton).click();
    }

    public void checkCreateBurgerTextIsDisplayed() {
        driver.findElement(objElementsLocatorsMainPage.createBurgerText).isDisplayed();
    }

    public boolean checkBunSectionIsSelected() {
        return driver.findElement(objElementsLocatorsMainPage.bunSectionSelected).isDisplayed();
    }

    public boolean checkBunSectionIsUnselected() {
        return driver.findElement(objElementsLocatorsMainPage.bunSectionUnselected).isDisplayed();
    }

    public void goToBunSection() {
        driver.findElement(objElementsLocatorsMainPage.bunSectionUnselected).click();
    }

    public boolean checkSauceSectionIsSelected() {
        return driver.findElement(objElementsLocatorsMainPage.sauceSectionSelected).isDisplayed();
    }

    public boolean checkSauceSectionIsUnselected() {
        return driver.findElement(objElementsLocatorsMainPage.sauceSectionUnselected).isDisplayed();
    }

    public void goToSauceSection() {
        driver.findElement(objElementsLocatorsMainPage.sauceSectionUnselected).click();
    }

    public boolean checkFillingSectionIsSelected() {
        return driver.findElement(objElementsLocatorsMainPage.fillingSectionSelected).isDisplayed();
    }

    public boolean checkFillingSectionIsUnselected() {
        return driver.findElement(objElementsLocatorsMainPage.fillingSectionUnselected).isDisplayed();
    }

    public void goToFillingSection() {
        driver.findElement(objElementsLocatorsMainPage.fillingSectionUnselected).click();
    }







}
