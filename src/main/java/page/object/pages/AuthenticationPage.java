package page.object.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class AuthenticationPage {

    public SelenideElement emailInput = $(xpath("//input[@id='email_create']")).shouldBe(Condition.visible);
    public SelenideElement createAccountButton = $(xpath("//button[@id='SubmitCreate']"));
    public SelenideElement forgotYourPasswordButton = $(xpath("//a[@title='Recover your forgotten password']"));


}
