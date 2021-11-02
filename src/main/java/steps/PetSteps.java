package steps;

import builders.Pet;
import builders.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import static enpoints.Endpoints.*;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import utils.ApiUtils;
import utils.BuilderUtil;

public class PetSteps {

    private final BuilderUtil builderUtil = new BuilderUtil();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public Response addNewPetToStore(Integer id, String name, String photoUrl,
                                         Integer categoryId, String categoryName, Integer tagId,
                                         String tagName, Status status ){

        Pet pet = builderUtil.buildFullDataPet(id, name, photoUrl, categoryId, categoryName, tagId, tagName, status);

        return ApiUtils.post(CREATE_A_PET, objectMapper.writeValueAsString(pet));

    }

    @SneakyThrows
    public Response updatePetInfo(Integer id, String name, String photoUrl,
                             Integer categoryId, String categoryName, Integer tagId,
                             String tagName, Status updatedStatus ){

        Pet pet = builderUtil.buildFullDataPet(id, name, photoUrl, categoryId, categoryName, tagId, tagName, updatedStatus);

        return ApiUtils.put(UPDATE_A_PET, objectMapper.writeValueAsString(pet));

    }

    @SneakyThrows
    public Response getInfoByPetId(Integer id){
        return ApiUtils.get(GET_A_PET, id);
    }

    @SneakyThrows
    public Response deleteInfoByPetId(Integer id){
        return ApiUtils.delete(DELETE_A_PET, id);
    }




}
