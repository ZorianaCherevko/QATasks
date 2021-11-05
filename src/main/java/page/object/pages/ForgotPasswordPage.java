package page.object.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class ForgotPasswordPage {

    public static String EXPECTED_SUCCESS_MESSAGE = "A confirmation email has been sent to your address";

    public SelenideElement emailInput = $(xpath("//input[@id='email']"));
    public SelenideElement retrievePasswordButton = $(xpath("//p//button[@type='submit']"));
    public SelenideElement message = $(xpath("//p[@class='alert alert-success']"));






}
