package page.object.tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;
import static page.object.pages.PersonalAccountPage.*;
import static page.object.user.cred.UserCred.*;
import static org.testng.Assert.assertEquals;

public class RegisterTests extends  BaseTest {

    @Test
    public void checkThatRegistrationWithValidCredentialsIsSuccessful(){
        getHeaderSteps().clickSignInButton();
        getAuthenticationPageSteps().waitVisibilityOfElement(20, getAuthenticationPageSteps().getInputEmail());
        getAuthenticationPageSteps().inputEmailAndClickCreateAccount(EMAIL);
        getCreateAccountPageSteps().waitVisibilityOfElement(20,getCreateAccountPageSteps().getInputFirstName());
        getCreateAccountPageSteps().fillInRegisterForm(FIRSTNAME,LASTNAME,PASSWORD,ADDRESS,CITY,POST_CODE,PHONE);
        getCreateAccountPageSteps().clickRegisterButton();
        getPersonalAccountPageSteps().waitForLoadPAgeComplete(30);
        assertTrue(getDriver().getCurrentUrl().contentEquals(PERSONAL_ACCOUNT_URL));

    }
}
