package pages;

import elements.ElementsLocatorsRegistratePage;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;

    ElementsLocatorsRegistratePage objElementsLocatorsRegistratePage = new ElementsLocatorsRegistratePage();

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String name) {
        driver.findElement(objElementsLocatorsRegistratePage.nameField).sendKeys(name);
    }

    public void setUserEmail(String email) {
        driver.findElement(objElementsLocatorsRegistratePage.emailField).sendKeys(email);
    }

    public void setUserPassword(String password) {
        driver.findElement(objElementsLocatorsRegistratePage.passwordField).sendKeys(password);
    }

    public void clickRegistrationButton() {
        driver.findElement(objElementsLocatorsRegistratePage.registrationButton).click();
    }

    public void checkIncorrectPasswordTextIsDisplayed() {
        driver.findElement(objElementsLocatorsRegistratePage.incorrectPasswordText).isDisplayed();
    }

    public void clickLoginButton() {
        driver.findElement(objElementsLocatorsRegistratePage.loginButton).click();
    }


}
