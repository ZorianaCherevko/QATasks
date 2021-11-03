package page.object.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static page.object.pages.AuthenticationPage.*;

public class AuthenticationPageSteps extends  BasePageSteps{

    public AuthenticationPageSteps(WebDriver driver){
        super(driver);
    }

    public void inputEmail(final String keyword){
        driver.findElement(By.xpath(EMAIL_INPUT)).sendKeys(keyword);
    }

    public void clickCreateAccount(){
        driver.findElement(By.xpath(CREATE_ACCOUNT_BUTTON)).click();
    }


}
