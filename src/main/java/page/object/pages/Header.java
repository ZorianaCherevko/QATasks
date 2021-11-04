package page.object.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class Header {

    //public static String SIGN_IN_BUTTON = "//a[@class='login']";

    public SelenideElement signInButton = $(xpath("//a[@class='login']"));


}
