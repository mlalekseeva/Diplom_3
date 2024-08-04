package elements;

import org.openqa.selenium.By;

public class ElementsLocatorsRegistratePage {
    public By nameField = By.xpath(".//fieldset[1]/div/div/input");
    public By emailField = By.xpath(".//fieldset[2]/div/div/input");
    public By passwordField = By.xpath(".//fieldset[3]/div/div/input");
    public By registrationButton = By.className("button_button__33qZ0");
    public By incorrectPasswordText = By.className("input__error");
    public By loginButton = By.className("Auth_link__1fOlj");
    public By forgotPasswordButton = By.xpath(".//a[@href='/forgot-password']");
}
