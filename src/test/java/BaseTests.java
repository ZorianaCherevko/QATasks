import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class BaseTests {

    private final String BASE_URL = "https://petstore.swagger.io";

    @BeforeTest
    public void BaseTest() {
        RestAssured.baseURI = BASE_URL;
    }



}
