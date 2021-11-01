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

    @SneakyThrows
    public Response updatePetWithBuilder(Integer id, String name, String photoUrl,
                                         Category category, List<Tag> tags, Status updatedStatus){

        Pet pet = builderUtil.buildFullDataPet(id, name, photoUrl, category,tags, updatedStatus);

        return ApiUtils.put(Endpoints.CREATE_A_PET, objectMapper.writeValueAsString(pet));

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
