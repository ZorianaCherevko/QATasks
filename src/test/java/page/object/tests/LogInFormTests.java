package page.object.tests;

import org.testng.annotations.Test;
import page.object.steps.*;
import page.object.util.BaseTest;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import static page.object.pages.ForgotPasswordPage.EXPECTED_SUCCESS_MESSAGE;
import static page.object.pages.PersonalAccountPage.PERSONAL_ACCOUNT_URL;
import static page.object.user.cred.UserCred.*;


public class LogInFormTests extends BaseTest {

    public HeaderSteps getHeaderSteps = new HeaderSteps();
    public AuthenticationPageSteps getAuthenticationPageSteps = new AuthenticationPageSteps();
    public CreateAccountPageSteps  getCreateAccountPageSteps = new CreateAccountPageSteps();
    public ForgotPasswordPageSteps getForgotPasswordPageSteps = new ForgotPasswordPageSteps();

    @Test
    public void checkThatRegistrationWithValidCredentialsIsSuccessful(){
        getHeaderSteps.clickSignInButton();
        getAuthenticationPageSteps.inputEmailAndClickCreateAccount(EMAIL);
        getCreateAccountPageSteps.fillInRegisterForm(FIRSTNAME,LASTNAME,PASSWORD,ADDRESS,CITY,POST_CODE,PHONE);
        getCreateAccountPageSteps.clickRegisterButton();
        assertEquals(getWebDriver().getCurrentUrl(),PERSONAL_ACCOUNT_URL);
    }

    @Test
    public void checkThatRetrievePasswordIsSuccessful(){
        getHeaderSteps.clickSignInButton();
        getAuthenticationPageSteps.clickForgotPassword();
        getForgotPasswordPageSteps.inputEmailAndClickRetrievePassword(REGISTERED_EMAIL);
        assertTrue(getForgotPasswordPageSteps.getTextFromMessage().contains(EXPECTED_SUCCESS_MESSAGE));
    }
}
