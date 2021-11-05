package page.object.steps;

import org.openqa.selenium.By;
import page.object.pages.AuthenticationPage;

import static com.codeborne.selenide.Selenide.page;


public class AuthenticationPageSteps{

    public AuthenticationPage authenticationPage = page(AuthenticationPage.class);

    public void inputEmailAndClickCreateAccount(final String keyword ){
        authenticationPage.emailInput.sendKeys(keyword);
        authenticationPage.createAccountButton.click();
    }

    //public By getInputEmail(){
        //return By.xpath(String.valueOf(authenticationPage.emailInput));
    //}

    public void clickForgotPassword(){
        authenticationPage.forgotYourPasswordButton.click();
    }


}