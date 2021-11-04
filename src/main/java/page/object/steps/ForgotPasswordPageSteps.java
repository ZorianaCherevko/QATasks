package page.object.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.object.pages.ForgotPasswordPage;

import static org.openqa.selenium.By.xpath;
import static page.object.pages.ForgotPasswordPage.*;


public class ForgotPasswordPageSteps extends BasePageSteps{

    public ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    public void inputEmailAndClickRetrievePassword(final String keyword){
        forgotPasswordPage.emailInput.sendKeys(keyword);
        forgotPasswordPage.retrievePasswordButton.click();
    }

    public By getMessage(){
        return By.xpath(String.valueOf(forgotPasswordPage.message));
    }

    public String getTextFromMessage(){
        return forgotPasswordPage.message.getText();

    }
}
