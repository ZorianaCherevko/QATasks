package page.object.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class Header {


    public SelenideElement signInButton = $(xpath("//a[@class='login']"));


}
