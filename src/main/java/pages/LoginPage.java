package pages;

import elements.ElementsLocatorsLoginPage;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    ElementsLocatorsLoginPage objElementsLocatorsLoginPage = new ElementsLocatorsLoginPage();
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkLoginButtonIsDisplayed() {
        driver.findElement(objElementsLocatorsLoginPage.loginButton).isDisplayed();
    }

    public void setUserEmail(String email) {
        driver.findElement(objElementsLocatorsLoginPage.emailField).sendKeys(email);
    }

    public void setUserPassword(String password) {
        driver.findElement(objElementsLocatorsLoginPage.passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(objElementsLocatorsLoginPage.loginButton).click();
    }

}
