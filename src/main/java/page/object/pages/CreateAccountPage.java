package page.object.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class CreateAccountPage {

    public SelenideElement firstNameInput = $(xpath("//input[@name='customer_firstname']"));
    public SelenideElement lastNameInput = $(xpath("//input[@name='customer_lastname']"));
    public SelenideElement passwordInput = $(xpath("//input[@id='passwd']"));
    public SelenideElement addressInput = $(xpath("//input[@id='address1']"));
    public SelenideElement cityInput = $(xpath("//input[@id='city']"));
    public SelenideElement postCodeInput = $(xpath("//input[@id='postcode']"));
    public SelenideElement phoneInput = $(xpath("//input[@id='phone_mobile']"));
    public SelenideElement registerButton = $(xpath("//button[@id='submitAccount']"));
    public SelenideElement stateSelector = $(xpath("//select[@name='id_state']"));
    public SelenideElement stateOption = $(xpath("//select[@name='id_state']/option[text() = 'California']"));



}
