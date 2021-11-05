package page.object.steps;
import page.object.pages.Header;


public class HeaderSteps  {


    public Header header = new Header();

    public void clickSignInButton(){
        header.signInButton.click();
    }
}
