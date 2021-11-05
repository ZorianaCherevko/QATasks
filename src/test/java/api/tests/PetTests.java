package api.tests;

import utils.BaseTests;
import io.restassured.response.Response;
import jdk.jfr.Description;
import lombok.SneakyThrows;
import steps.GenStep;
import steps.PetSteps;
import org.testng.annotations.Test;

import static test.Cred.TestCred.*;

import static org.testng.Assert.assertEquals;
public class PetTests extends BaseTests {


    private final PetSteps petSteps = new PetSteps();
    private final GenStep genStep = new GenStep();


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
        assertEquals(petSteps.updatePetStatus(PET_ID, PET_NAME,PET_PHOTO,
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
        Response postResponse =petSteps.addNewPetToStore(PET_ID, PET_NAME,PET_PHOTO,
                PET_CATEGORY_ID, PET_CATEGORY_NAME,PET_TAG_ID,
                PET_TAG_NAME,PET_STATUS);

        assertEquals(genStep.getBodyValueInt(postResponse,"/id"),PET_ID);
        assertEquals(genStep.getBodyValue(postResponse,"/name"),PET_NAME);
        assertEquals(genStep.getBodyValueInt(postResponse,"/category/id"),PET_CATEGORY_ID);
        assertEquals(genStep.getBodyValue(postResponse,"/category/name"),PET_CATEGORY_NAME);
        assertEquals(genStep.getBodyValue(postResponse,"/photoUrls/0"),PET_PHOTO);
        assertEquals(genStep.getBodyValueInt(postResponse,"/tags/0/id"),PET_TAG_ID);
        assertEquals(genStep.getBodyValue(postResponse,"/tags/0/name"),PET_TAG_NAME);

        Response putResponse = petSteps.updatePetStatus(PET_ID, PET_NAME,PET_PHOTO,
                PET_CATEGORY_ID, PET_CATEGORY_NAME,PET_TAG_ID,
                PET_TAG_NAME,UPDATED_PET_STATUS);
        assertEquals(genStep.getBodyValue(putResponse, "/status"), UPDATED_PET_STATUS.toString());

        assertEquals(petSteps.getInfoByPetId(PET_ID).getStatusCode(),200);

        assertEquals(petSteps.deleteInfoByPetId(PET_ID).getStatusCode(),200);
    }


}
