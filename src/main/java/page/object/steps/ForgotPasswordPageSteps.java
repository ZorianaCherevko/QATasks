package page.object.steps;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import page.object.pages.ForgotPasswordPage;

public class ForgotPasswordPageSteps{

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
