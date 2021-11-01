package steps;

import builders.Pet;
import builders.Status;
import enpoints.Endpoints;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import utils.ApiUtils;
import utils.BuilderUtil;

public class PetSteps {

    private final BuilderUtil builderUtil = new BuilderUtil();
    private final ObjectMapper objectMapper = new ObjectMapper();


    @SneakyThrows
    public Response createPet(Integer id, String name, String photoUrl,
                                         Integer categoryId, String categoryName, Integer tagId,
                                         String tagName, Status status ){

        Pet pet = builderUtil.buildFullDataPet(id, name, photoUrl, categoryId, categoryName, tagId, tagName, status);

        return ApiUtils.post(Endpoints.CREATE_A_PET, objectMapper.writeValueAsString(pet));

    }

    @SneakyThrows
    public Response updatePet(Integer id, String name, String photoUrl,
                             Integer categoryId, String categoryName, Integer tagId,
                             String tagName, Status updatedStatus ){

        Pet pet = builderUtil.buildFullDataPet(id, name, photoUrl, categoryId, categoryName, tagId, tagName, updatedStatus);

        return ApiUtils.put(Endpoints.UPDATE_A_PET, objectMapper.writeValueAsString(pet));

    }

    @SneakyThrows
    public Response getPet(Integer id){
        return ApiUtils.get(Endpoints.GET_A_PET, id);
    }

    @SneakyThrows
    public Response deletePet(Integer id){
        return ApiUtils.delete(Endpoints.DELETE_A_PET, id);
    }




}
