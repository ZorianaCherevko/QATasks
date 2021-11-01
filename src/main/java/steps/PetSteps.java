package steps;

import builders.Category;
import builders.Pet;
import builders.Status;
import builders.Tag;
import enpoints.Endpoints;
import io.restassured.RestAssured;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import utils.ApiUtils;
import utils.BuilderUtil;


import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

public class PetSteps {

    private final BuilderUtil builderUtil = new BuilderUtil();
    private final ObjectMapper objectMapper = new ObjectMapper();


    @SneakyThrows
    public Response createPetWithBuilder(Integer id, String name, String photoUrl,
                                         Category category, List<Tag> tags, Status status){

        Pet pet = builderUtil.buildFullDataPet(id, name, photoUrl, category,tags, status);

        return ApiUtils.post(Endpoints.CREATE_A_PET, objectMapper.writeValueAsString(pet));

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
