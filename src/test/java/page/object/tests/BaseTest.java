package page.object.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import page.object.pages.AuthenticationPage;
import page.object.pages.Header;
import page.object.steps.AuthenticationPageSteps;
import page.object.steps.CreateAccountPageSteps;
import page.object.steps.HeaderSteps;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {

    private WebDriver driver;
    private static final String URL ="http://automationpractice.com/index.php";

    @BeforeTest
    public void profileSetUp(){

        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public HeaderSteps getHeaderSteps(){
        return new HeaderSteps(getDriver());
    }

    public AuthenticationPageSteps getAuthenticationPageSteps(){
        return new AuthenticationPageSteps(getDriver());
    }

    public CreateAccountPageSteps getCreateAccountPageSteps(){
        return new CreateAccountPageSteps(getDriver());
    }

}