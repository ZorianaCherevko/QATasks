package page.object.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.object.pages.CreateAccountPage;

import static page.object.pages.CreateAccountPage.*;

public class CreateAccountPageSteps extends BasePageSteps {

    public CreateAccountPage createAccountPage = new CreateAccountPage();

    public void fillInRegisterForm(final String fname,final String lname,final String password,
                                   final String address, final String city,final int pcode, final int phone){
        createAccountPage.firstNameInput.sendKeys(fname);
        createAccountPage.lastNameInput.sendKeys(lname);
        createAccountPage.passwordInput.sendKeys(password);
        createAccountPage.addressInput.sendKeys(address);
        createAccountPage.cityInput.sendKeys(city);
        createAccountPage.postCodeInput.sendKeys(String.valueOf(pcode));
        createAccountPage.phoneInput.sendKeys(String.valueOf(phone));
        createAccountPage.stateSelector.click();
        createAccountPage.stateOption.click();
    }

    public By getInputFirstName(){
        return By.xpath(String.valueOf(createAccountPage.firstNameInput));
    }

    public void clickRegisterButton(){
        createAccountPage.registerButton.click();
    }


}
