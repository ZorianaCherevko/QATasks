package page.object.tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeSuite;


import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {


    WebDriver driver;

    private static final String URL ="http://automationpractice.com/index.php";

    @BeforeSuite
    public void profileSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Configuration.startMaximized = true;
        open(URL);
    }

    //@AfterMethod
   // public void tearDown(){
       /// closeWebDriver();
    //}





}
