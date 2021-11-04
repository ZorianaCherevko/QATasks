package page.object.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;
import static page.object.pages.CreateAccountPage.FIRST_NAME_INPUT;
import static page.object.pages.ForgotPasswordPage.*;


public class ForgotPasswordPageSteps extends BasePageSteps{

    public ForgotPasswordPageSteps(WebDriver driver){
        super(driver);
    }

    public void inputEmailAndClickRetrievePassword(final String keyword){
        driver.findElement(By.xpath(EMAIL_INPUT)).sendKeys(keyword);
        driver.findElement(By.xpath(RETRIEVE_PASSWORD_BUTTON)).click();
    }

    public By getMessage(){
        return By.xpath(SUCCESS_MESSAGE);
    }

    public String getTextFromMessage(){
        return driver.findElement(xpath(SUCCESS_MESSAGE)).getText();

    }
}
