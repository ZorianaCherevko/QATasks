package page.object.tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeSuite;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {


    public static final String URL ="http://automationpractice.com/index.php";

    @BeforeSuite
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
