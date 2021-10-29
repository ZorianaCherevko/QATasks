package swagger.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class tests {


    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }

    @Test
    public void getPetDataById(){
        given()
                .accept(ContentType.JSON)
                .when()
                .get("/v2/pet/236")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void deletePetDataById(){
        given()
                .accept(ContentType.JSON)
                .when()
                .delete("/v2/pet/236")
                .then()
                .statusCode(200);
    }


    @Test
    public void postNewPetData(){
        String data = "{\"id\": \"356\",\"name\": \"Jake\", \"status\": \"available\"}";
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("/v2/pet")
                .then().log().all()
                .assertThat().statusCode(200)
                .body("id", equalTo(356));
    }

    @Test
    public void updatePetDataStatus(){
        String data = "{\"id\": \"356\",\"name\": \"Jake\",\"status\": \"sold\"}";
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).log().all()
                .body(data)
                .when()
                .put("/v2/pet")
                .then().log().all()
                .assertThat().statusCode(200)
                .body("status", equalTo("sold"));
    }

    @Test
    public void createPetProfile(){
        RequestSpecification requestSpec = given()
                .baseUri("https://petstore.swagger.io")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);

        String data = "{\"id\": \"356\",\"name\": \"breed\", \"German Shepherd\": \"\",\"status\": \"available\"}";
        requestSpec.body(data)
                .when()
                .post("/v2/pet")
                .then()
                .assertThat().statusCode(200);

        String updatedData = "{\"id\": \"356\",\"name\": \"breed\", \"German Shepherd\": \"\",\"status\": \"sold\"}";
        requestSpec.body(updatedData)
                .when()
                .put("/v2/pet/356")
                .then()
                .assertThat()
                .statusCode(200);

        requestSpec.when()
                .get("/v2/pet/356")
                .then()
                .body("status", equalTo("sold"));



    }
}
