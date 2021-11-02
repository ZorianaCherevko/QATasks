import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import jdk.jfr.Description;
import lombok.SneakyThrows;
import steps.GenSteps;
import steps.PetSteps;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static test.Cred.TestCred.*;

import static org.testng.Assert.assertEquals;
public class PetTests extends BaseTests{


    private final PetSteps petSteps = new PetSteps();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final GenSteps genSteps = new GenSteps();



    @Test
    @Description("POST /v2/pet")
    public void checkThatCreatePetWithValidDataReturns200(){
        assertEquals(petSteps.addNewPetToStore(PET_ID, PET_NAME,PET_PHOTO,
                PET_CATEGORY_ID, PET_CATEGORY_NAME,PET_TAG_ID,
                PET_TAG_NAME,PET_STATUS).getStatusCode(),200);
    }

    @Test
    @Description("PUT /v2/pet")
    public void checkThatUpdatePetReturns200(){
        assertEquals(petSteps.updatePetInfo(PET_ID, PET_NAME,PET_PHOTO,
                PET_CATEGORY_ID, PET_CATEGORY_NAME,PET_TAG_ID,
                PET_TAG_NAME,UPDATED_PET_STATUS).getStatusCode(),200);
    }

    @Test
    @Description("GET /v2/pet/{id}")
    public void checkThatGetPetByIdReturns200(){
        assertEquals(petSteps.getInfoByPetId(PET_ID).getStatusCode(),200);
    }

    @Test
    @Description("DELETE /v2/pet/{id}")
    public void checkThatDeletePetByIdReturns200(){
        assertEquals(petSteps.deleteInfoByPetId(PET_ID).getStatusCode(),200);
    }


    @SneakyThrows
    @Test
    public void checkTheMainFunctionalityOfApiRequests(){
        Response r =petSteps.addNewPetToStore(PET_ID, PET_NAME,PET_PHOTO,
                PET_CATEGORY_ID, PET_CATEGORY_NAME,PET_TAG_ID,
                PET_TAG_NAME,PET_STATUS);
        assertEquals(genSteps.getIdFromBody(r),PET_ID.toString());


                //.then()
               // .assertThat()
               // .body("id", equalTo(PET_ID))
               // .body("name", equalTo(PET_NAME))
               // .body("category.id", equalTo(PET_CATEGORY_ID))
               // .body("category.name", equalTo(PET_CATEGORY_NAME))
              //  .body("photoUrls[0]", equalTo(PET_PHOTO))
               // .body("tags[0].id", equalTo(PET_TAG_ID))
               // .body("tags[0].name", equalTo(PET_TAG_NAME))
               // .body("status", equalToCompressingWhiteSpace(PET_STATUS.toString()));


        petSteps.updatePetInfo(PET_ID, PET_NAME,PET_PHOTO,
                PET_CATEGORY_ID, PET_CATEGORY_NAME,PET_TAG_ID,
                PET_TAG_NAME,UPDATED_PET_STATUS).then().assertThat().body("status",
                equalToCompressingWhiteSpace(UPDATED_PET_STATUS.toString()));

        petSteps.getInfoByPetId(PET_ID).then().log().body();

        assertEquals(petSteps.deleteInfoByPetId(PET_ID).getStatusCode(),200);

    }


}
