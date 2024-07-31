package elements;

import org.openqa.selenium.By;

public class ElementsLocatorsMainPage {

    public By personalAccountButton = By.xpath(".//a[@href='/account']/p[text()='Личный Кабинет']");
    public By loginToPersonalAccountButton = By.className("button_button__33qZ0");
    public By createOrderButton = By.xpath(".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button");
    public By createBurgerText = By.xpath(".//h1[@class='text text_type_main-large mb-5 mt-10']");
    public By sauceSectionUnselected = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    public By sauceSectionSelected = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    public By bunSectionSelected = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    public By bunSectionUnselected = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    public By fillingSectionUnselected = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    public By fillingSectionSelected = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

}
