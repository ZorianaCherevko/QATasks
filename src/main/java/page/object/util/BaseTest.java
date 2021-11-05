package page.object.util;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    private static final String URL ="http://automationpractice.com/index.php";

    @BeforeMethod
    public void profileSetUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        open(URL);
    }

    @AfterMethod
    public void tearDown(){
        closeWebDriver();
    }





}
