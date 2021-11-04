package page.object.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static page.object.pages.CreateAccountPage.*;

public class CreateAccountPageSteps extends BasePageSteps {

    public CreateAccountPageSteps(WebDriver driver){
        super(driver);
    }

    public void fillInRegisterForm(final String fname,final String lname,final String password,
                                   final String address, final String city,final int pcode, final int phone){
        driver.findElement(By.xpath(FIRST_NAME_INPUT)).sendKeys(fname);
        driver.findElement(By.xpath(LAST_NAME_INPUT)).sendKeys(lname);
        driver.findElement(By.xpath(PASSWORD_INPUT)).sendKeys(password);
        driver.findElement(By.xpath(ADDRESS_INPUT)).sendKeys(address);
        driver.findElement(By.xpath(CITY_INPUT)).sendKeys(city);
        driver.findElement(By.xpath(POST_CODE_INPUT)).sendKeys(String.valueOf(pcode));
        driver.findElement(By.xpath(PHONE_INPUT)).sendKeys(String.valueOf(phone));
        driver.findElement(By.xpath(STATE_SELECTOR)).click();
        driver.findElement(By.xpath(STATE_OPTION)).click();
    }

    public By getInputFirstName(){
        return By.xpath(FIRST_NAME_INPUT);
    }

    public void clickRegisterButton(){
        driver.findElement(By.xpath(REGISTER_BUTTON)).click();
    }


}
