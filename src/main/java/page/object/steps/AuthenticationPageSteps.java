package page.object.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static page.object.pages.AuthenticationPage.*;

public class AuthenticationPageSteps extends  BasePageSteps{

    public AuthenticationPageSteps(WebDriver driver){
        super(driver);
    }

    public void inputEmailAndClickCreateAccount(final String keyword ){
        driver.findElement(By.xpath(EMAIL_INPUT)).sendKeys(keyword);
        driver.findElement(By.xpath(CREATE_ACCOUNT_BUTTON)).click();
    }

    public By getInputEmail(){
        return By.xpath(EMAIL_INPUT);
    }



    public void clickForgotPassword(){
        driver.findElement(By.xpath(FORGOT_YOUR_PASSWORD_BUTTON)).click();
    }


}