package page.object.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.object.pages.AuthenticationPage;

import static page.object.pages.AuthenticationPage.*;

public class AuthenticationPageSteps extends  BasePageSteps{

    public AuthenticationPage authenticationPage = new AuthenticationPage();

    public void inputEmailAndClickCreateAccount(final String keyword ){
        authenticationPage.emailInput.sendKeys(keyword);
        authenticationPage.createAccountButton.click();
    }

    public By getInputEmail(){
        return By.xpath(String.valueOf(authenticationPage.emailInput));
    }

    public void clickForgotPassword(){
        authenticationPage.forgotYourPasswordButton.click();
    }


}