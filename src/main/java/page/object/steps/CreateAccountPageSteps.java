package page.object.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static page.object.pages.CreateAccountPage.*;

public class CreateAccountPageSteps extends BasePageSteps {

    public CreateAccountPageSteps(WebDriver driver){
        super(driver);
    }

    public void inputFirstName(final String keyword){
        driver.findElement(By.xpath(FIRST_NAME_INPUT)).sendKeys(keyword);
    }

    public By getInputFirstName(){
        return By.xpath(FIRST_NAME_INPUT);
    }

    public void inputLastName(final String keyword){
        driver.findElement(By.xpath(LAST_NAME_INPUT)).sendKeys(keyword);
    }

    public void inputPassword(final String keyword){
        driver.findElement(By.xpath(PASSWORD_INPUT)).sendKeys(keyword);
    }

    public void inputAddress(final String keyword){
        driver.findElement(By.xpath(ADDRESS_INPUT)).sendKeys(keyword);
    }

    public void inputCity(final String keyword){
        driver.findElement(By.xpath(CITY_INPUT)).sendKeys(keyword);
    }

    public void inputPostCode(final int keyword){
        driver.findElement(By.xpath(POST_CODE_INPUT)).sendKeys(String.valueOf(keyword));
    }

    public void chooseState(){
        driver.findElement(By.xpath(STATE_SELECTOR)).click();
        driver.findElement(By.xpath(STATE_OPTION)).click();

    }

    public void clickRegisterButton(){
        driver.findElement(By.xpath(REGISTER_BUTTON)).click();

    }

    public void inputPhoneNumber(final int keyword){
        driver.findElement(By.xpath(PHONE_INPUT)).sendKeys(String.valueOf(keyword));
    }



}
