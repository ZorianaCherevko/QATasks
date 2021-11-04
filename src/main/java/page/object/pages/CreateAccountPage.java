package page.object.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class CreateAccountPage {

    //public static String FIRST_NAME_INPUT = "//input[@name='customer_firstname']";
    //public static String LAST_NAME_INPUT = "//input[@name='customer_lastname']";
    //public static String PASSWORD_INPUT = "//input[@id='passwd']";
    //public static String ADDRESS_INPUT = "//input[@id='address1']";
    //public static String CITY_INPUT = "//input[@id='city']";
    //public static String POST_CODE_INPUT = "//input[@id='postcode']";
    //public static String PHONE_INPUT = "//input[@id='phone_mobile']";
    //public static String REGISTER_BUTTON = "//button[@id='submitAccount']";
    //public static String STATE_SELECTOR = "//select[@name='id_state']";
    //public static String STATE_OPTION = "//select[@name='id_state']/option[text() = 'California']";

    public SelenideElement firstNameInput = $(xpath("//input[@name='customer_firstname']")).shouldBe(Condition.visible);
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
