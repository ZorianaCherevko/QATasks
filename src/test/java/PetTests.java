import jdk.jfr.Description;
import steps.PetSteps;
import org.testng.annotations.Test;
import test.Cred.TestCred;

import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
public class PetTests extends BaseTests{


    private final PetSteps petSteps = new PetSteps();


    @Test
    @Description("POST /v2/pet")
    public void checkThatCreatePetWithValidDataReturns200(){
        assertEquals(petSteps.createPetWithValidData(TestCred.PET_ID, TestCred.PET_NAME,TestCred.PET_PHOTO,
                TestCred.PET_CATEGORY_ID, TestCred.PET_CATEGORY_NAME,TestCred.PET_TAG_ID,
                TestCred.PET_TAG_NAME,TestCred.PET_STATUS).getStatusCode(),200);
    }

    @Test
    @Description("PUT /v2/pet")
    public void checkThatUpdatePetReturns200(){
        assertEquals(petSteps.updatePetTagNameWithValidDaa(TestCred.PET_ID, TestCred.PET_NAME,TestCred.PET_PHOTO,
                TestCred.PET_CATEGORY_ID, TestCred.PET_CATEGORY_NAME,TestCred.PET_TAG_ID,
                TestCred.PET_TAG_NAME,TestCred.UPDATED_PET_STATUS).getStatusCode(),200);
    }

    @Test
    @Description("GET /v2/pet/{id}")
    public void checkThatGetPetByIdReturns200(){
        assertEquals(petSteps.getPetById(TestCred.PET_ID).getStatusCode(),200);
    }

    @Test
    @Description("DELETE /v2/pet/{id}")
    public void checkThatDeletePetByIdReturns200(){
        assertEquals(petSteps.deletePetById(TestCred.PET_ID).getStatusCode(),200);
    }


    @Test
    public void checkTheMainFunctionalityOfApiRequests(){
        petSteps.createPetWithValidData(TestCred.PET_ID, TestCred.PET_NAME,TestCred.PET_PHOTO,
                TestCred.PET_CATEGORY_ID, TestCred.PET_CATEGORY_NAME,TestCred.PET_TAG_ID,
                TestCred.PET_TAG_NAME,TestCred.PET_STATUS).then().assertThat().statusCode(200);

        petSteps.updatePetTagNameWithValidDaa(TestCred.PET_ID, TestCred.PET_NAME,TestCred.PET_PHOTO,
                TestCred.PET_CATEGORY_ID, TestCred.PET_CATEGORY_NAME,TestCred.PET_TAG_ID,
                TestCred.PET_TAG_NAME,TestCred.UPDATED_PET_STATUS).then().assertThat().body("status", equalTo("sold"));

        petSteps.getPetById(TestCred.PET_ID).then().log().body();

        assertEquals(petSteps.deletePetById(TestCred.PET_ID).getStatusCode(),200);

    }


}
