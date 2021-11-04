package page.object.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class AuthenticationPage {

    //public static String EMAIL_INPUT = "//input[@id='email_create']";
    //public static String CREATE_ACCOUNT_BUTTON="//button[@id='SubmitCreate']";
    //public static String FORGOT_YOUR_PASSWORD_BUTTON = "//a[@title='Recover your forgotten password']";
    public SelenideElement emailInput = $(xpath("//input[@id='email_create']"));
    public SelenideElement createAccountButton = $(xpath("//button[@id='SubmitCreate']"));
    public SelenideElement forgotYourPasswordButton = $(xpath("//a[@title='Recover your forgotten password']"));


}
