package page.object.steps;

import page.object.pages.AuthenticationPage;

public class AuthenticationPageSteps{

    public AuthenticationPage authenticationPage = new AuthenticationPage();

    public void inputEmailAndClickCreateAccount(final String keyword ){
        authenticationPage.emailInput.sendKeys(keyword);
        authenticationPage.createAccountButton.click();
    }

    public void clickForgotPassword(){
        authenticationPage.forgotYourPasswordButton.click();
    }


}