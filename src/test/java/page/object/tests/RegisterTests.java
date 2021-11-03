package page.object.tests;

import org.testng.annotations.Test;
import static page.object.user.cred.UserCred.*;

public class RegisterTests extends  BaseTest {

    @Test
    public void checkRegister(){
        getHeaderSteps().clickSignInButton();
        getAuthenticationPageSteps().waitForLoadPAgeComplete(30);
        getAuthenticationPageSteps().inputEmail(IRSTNAME);
        getAuthenticationPageSteps().clickCreateAccount();
        getCreateAccountPageSteps().waitVisibilityOfElement(20,getCreateAccountPageSteps().getInputFirstName());
        getCreateAccountPageSteps().inputFirstName("Stats");
        getCreateAccountPageSteps().inputLastName("gdkjh");
        getCreateAccountPageSteps().inputPassword("dkgkdgkd");
        getCreateAccountPageSteps().inputAddress("jhkfjh");
        getCreateAccountPageSteps().inputCity("ssffs");
        getCreateAccountPageSteps().inputPostCode("fsf");
        getCreateAccountPageSteps().chooseState();
        getCreateAccountPageSteps().clickRegisterButton();

    }
}
