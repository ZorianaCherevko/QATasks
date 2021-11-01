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

        return ApiUtils.put(Endpoints.UPDATE_A_PET, objectMapper.writeValueAsString(pet));

    }

    @SneakyThrows
    public Response getPet(Integer id){
        return ApiUtils.get(Endpoints.GET_A_PET);

    }




}
