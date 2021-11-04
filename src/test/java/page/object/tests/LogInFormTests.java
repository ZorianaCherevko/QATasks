package page.object.tests;

import org.testng.annotations.Test;
import page.object.steps.*;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertTrue;
import static page.object.pages.ForgotPasswordPage.EXPECTED_SUCCESS_MESSAGE;
import static page.object.pages.PersonalAccountPage.*;
import static page.object.user.cred.UserCred.*;
import static org.testng.Assert.assertEquals;

public class LogInFormTests extends  BaseTest {

    public HeaderSteps getHeaderSteps = new HeaderSteps();
    public AuthenticationPageSteps getAuthenticationPageSteps = new AuthenticationPageSteps();
    public CreateAccountPageSteps  getCreateAccountPageSteps = new CreateAccountPageSteps();
    public ForgotPasswordPageSteps getForgotPasswordPageSteps = new ForgotPasswordPageSteps();
    public PersonalAccountPageSteps getPersonalAccountPageSteps = new PersonalAccountPageSteps();


    @Test
    public void checkThatRegistrationWithValidCredentialsIsSuccessful(){
        getHeaderSteps.clickSignInButton();
        getAuthenticationPageSteps.inputEmailAndClickCreateAccount(EMAIL);
        getCreateAccountPageSteps.fillInRegisterForm(FIRSTNAME,LASTNAME,PASSWORD,ADDRESS,CITY,POST_CODE,PHONE);
        getCreateAccountPageSteps.clickRegisterButton();
        //assertTrue(getDriver().getCurrentUrl().contentEquals(PERSONAL_ACCOUNT_URL));

    }

    @Test
    public void checkThatRetrievePasswordIsSuccessful(){
        getHeaderSteps.clickSignInButton();
        getAuthenticationPageSteps.clickForgotPassword();
        getForgotPasswordPageSteps.inputEmailAndClickRetrievePassword(EMAIL);
        assertTrue(getForgotPasswordPageSteps.getTextFromMessage().contains(EXPECTED_SUCCESS_MESSAGE));

    }
}
