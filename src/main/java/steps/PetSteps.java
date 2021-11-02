package steps;

import builders.Pet;
import builders.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import utils.ApiUtils;
import utils.BuilderUtil;

import static enpoints.Endpoints.*;

public class PetSteps {

    private final BuilderUtil builderUtil = new BuilderUtil();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Step ("Add new pet to store")
    public Response addNewPetToStore(int id, String name, String photoUrl,
                                         int categoryId, String categoryName, int tagId,
                                         String tagName, Status status ){

        Pet pet = builderUtil.buildFullDataPet(id, name, photoUrl, categoryId, categoryName, tagId, tagName, status);

        return ApiUtils.post(CREATE_A_PET, objectMapper.writeValueAsString(pet));
    }

    @SneakyThrows
    @Step ("Update pet status")
    public Response updatePetStatus(int id, String name, String photoUrl,
                             int categoryId, String categoryName, int tagId,
                             String tagName, Status updatedStatus ){

        Pet pet = builderUtil.buildFullDataPet(id, name, photoUrl, categoryId, categoryName, tagId, tagName, updatedStatus);

        return ApiUtils.put(UPDATE_A_PET, objectMapper.writeValueAsString(pet));
    }

    @SneakyThrows
    @Step ("Get pet profile")
    public Response getInfoByPetId(Integer id){
        return ApiUtils.get(GET_A_PET, id);
    }

    @SneakyThrows
    @Step ("Delete pet profile")
    public Response deleteInfoByPetId(Integer id){
        return ApiUtils.delete(DELETE_A_PET, id);
    }




}
