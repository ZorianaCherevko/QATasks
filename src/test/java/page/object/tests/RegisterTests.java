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
        getAuthenticationPageSteps().inputEmail(EMAIL);
        getAuthenticationPageSteps().clickCreateAccount();
        getCreateAccountPageSteps().waitVisibilityOfElement(20,getCreateAccountPageSteps().getInputFirstName());
        getCreateAccountPageSteps().inputFirstName(FIRSTNAME);
        getCreateAccountPageSteps().inputLastName(LASTNAME);
        getCreateAccountPageSteps().inputPassword(PASSWORD);
        getCreateAccountPageSteps().inputAddress(ADDRESS);
        getCreateAccountPageSteps().inputCity(CITY);
        getCreateAccountPageSteps().inputPostCode(POST_CODE);
        getCreateAccountPageSteps().inputPhoneNumber(PHONE);
        getCreateAccountPageSteps().chooseState();
        getCreateAccountPageSteps().clickRegisterButton();
        getPersonalAccountPageSteps().waitForLoadPAgeComplete(30);
        assertTrue(getDriver().getCurrentUrl().contentEquals(PERSONAL_ACCOUNT_URL));

    }
}
