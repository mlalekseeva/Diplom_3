package pages;

import elements.ElementsLocatorsPersonalAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalAccountPage {
    private WebDriver driver;
    ElementsLocatorsPersonalAccountPage objElementsLocatorsPersonalAccountPage = new ElementsLocatorsPersonalAccountPage();

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkLogoutButtonIsDisplayed() {
        driver.findElement(objElementsLocatorsPersonalAccountPage.logoutButton).isDisplayed();
    }

    public void checkInformationTextIsDisplayed() {
        WebElement element = driver.findElement(objElementsLocatorsPersonalAccountPage.informationText);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickLogoutButton() {
        driver.findElement(objElementsLocatorsPersonalAccountPage.logoutButton).click();
    }

    public void clickConstructorHeaderButton() {
        driver.findElement(objElementsLocatorsPersonalAccountPage.constructorHeaderButton).click();
    }

    public void clickLogoHeaderButton() {
        driver.findElement(objElementsLocatorsPersonalAccountPage.logoHeaderButton).click();
    }
}
