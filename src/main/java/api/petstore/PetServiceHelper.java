package api.petstore;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;

public class PetServiceHelper {

    private final String BASE_URL = "https://petstore.swagger.io";

    public PetServiceHelper() {
        RestAssured.baseURI = BASE_URL;
    }

    public RequestSpecification getCommonRequestSpec(){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setAccept(ContentType.JSON);
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec = builder.build();
        return requestSpec;
    }

    public Response createPet(){

        Category category = new Category();
        category.setId(345);
        category.setName("Dog");

        Tag tag = new Tag();
        tag.setId(345);
        tag.setName("Hound");

        Pet pet = new Pet();
        pet.setId(345);
        pet.setName("Rocky");
        pet.setStatus(Status.available);
        pet.setCategory(category);
        pet.setTags(Arrays.asList(tag));
        pet.setPhotoUrls(Arrays.asList("https://highlandcanine.com/wp-content/uploads/2020/12/iStock-926735822.jpg"));

        Response response = RestAssured
                .given()
                .spec(getCommonRequestSpec())
                .body(pet)
                .when()
                .post(Endpoints.CREATE_A_PET)
                .andReturn();
        assertEquals(response.statusCode(), 200);
        return  response;

    }

    public  Response updatePet(){

        Category category = new Category();
        category.setId(345);
        category.setName("Dog");

        Tag tag = new Tag();
        tag.setId(345);
        tag.setName("Sporting");

        Pet pet = new Pet();
        pet.setName("Rocky");
        pet.setStatus(Status.sold);
        pet.setCategory(category);
        pet.setTags(Arrays.asList(tag));
        pet.setPhotoUrls(Arrays.asList("https://highlandcanine.com/wp-content/uploads/2020/12/iStock-926735822.jpg"));

        Response response = RestAssured
                .given()
                .spec(getCommonRequestSpec())
                .when()
                .body(pet)
                .put(Endpoints.UPDATE_A_PET)
                .andReturn();
        assertEquals(response.statusCode(), 200);
        return  response;

    }

    public  Response getPet(Integer id){

        Response response = RestAssured
                .given()
                .spec(getCommonRequestSpec())
                .pathParam("id", id)
                .when()
                .get(Endpoints.GET_A_PET)
                .andReturn();
        assertEquals(response.statusCode(), 200);
        return  response;

    }

    public Response deletePet(Integer id){

        Response response = RestAssured
                .given()
                .spec(getCommonRequestSpec())
                .pathParam("id", id)
                .when()
                .delete(Endpoints.DELETE_A_PET)
                .andReturn();
        assertEquals(response.statusCode(), 200);
        return  response;

    }
}
