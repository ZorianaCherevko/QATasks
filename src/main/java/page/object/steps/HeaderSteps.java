package page.object.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.object.pages.Header;

import static page.object.pages.Header.*;

public class HeaderSteps  {


    public Header header = new Header();

    public void clickSignInButton(){
        header.signInButton.click();
    }
}
