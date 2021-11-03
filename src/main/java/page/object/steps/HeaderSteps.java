package page.object.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static page.object.pages.Header.*;

public class HeaderSteps extends BasePageSteps  {

    public HeaderSteps(WebDriver driver){
        super(driver);
    }

    public void clickSignInButton(){
        driver.findElement(By.xpath(SIGN_IN_BUTTON)).click();
    }
}
