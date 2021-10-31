package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PetTests {

    private PetServiceHelper petServiceHelper;

    @BeforeClass
    public void setUp() {
        petServiceHelper = new PetServiceHelper();
    }




    @Test
    public void deletePetId(){
        serviceHelper.createPet();
        serviceHelper.updatePet().then().body("status", equalTo("sold"));
    }






}
