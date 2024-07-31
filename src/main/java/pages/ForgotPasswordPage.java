package pages;

import elements.ElementsLocatorsForgotPasswordPage;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;

    ElementsLocatorsForgotPasswordPage objElementsLocatorsForgotPasswordPage = new ElementsLocatorsForgotPasswordPage();

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginPage() {
        driver.findElement(objElementsLocatorsForgotPasswordPage.loginButton).click();
    }


}
