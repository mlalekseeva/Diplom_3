package elements;

import org.openqa.selenium.By;

public class ElementsLocatorsLoginPage {

    public By emailField = By.xpath(".//input[@name = 'name']");
    public By passwordField = By.xpath(".//input[@name = 'Пароль']");
    public By loginButton = By.className("button_button__33qZ0");
    public By startRegistrationButton = By.xpath(".//p[@class='undefined text text_type_main-default text_color_inactive mb-4']/a[text()='Зарегистрироваться']");


}
