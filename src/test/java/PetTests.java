
import builders.Category;
import builders.Status;
import builders.Tag;
import enpoints.Endpoints;
import jdk.jfr.Description;
import steps.PetSteps;
import org.testng.annotations.Test;
import test.Cred.TestCred;

import java.util.List;

import static org.testng.Assert.assertEquals;

import static org.hamcrest.Matchers.equalTo;

public class PetTests extends BaseTests{


    private final PetSteps petSteps = new PetSteps();


    @Test
    @Description("POST /v2/pet")
    public void checkThatCreatePetWithValidDataReturns200(){
        assertEquals(petSteps.createPet(TestCred.PET_ID, TestCred.PET_NAME,TestCred.PET_PHOTO,
                TestCred.PET_CATEGORY_ID, TestCred.PET_CATEGORY_NAME,TestCred.PET_TAG_ID,
                TestCred.PET_TAG_NAME,TestCred.PET_STATUS).getStatusCode(),200);
    }

    @Test
    @Description("PUT /v2/pet")
    public void checkThatUpdatePetReturns200(){
        assertEquals(petSteps.updatePet(TestCred.PET_ID, TestCred.PET_NAME,TestCred.PET_PHOTO,
                TestCred.PET_CATEGORY_ID, TestCred.PET_CATEGORY_NAME,TestCred.PET_TAG_ID,
                TestCred.UPDATED_PET_TAG_NAME,TestCred.PET_STATUS).getStatusCode(),200);
    }

    @Test
    @Description("GET /v2/pet/{id}")
    public void checkThatGetPetByIdReturns200(){
        assertEquals(petSteps.getPet(TestCred.PET_ID).getStatusCode(),200);
    }

    @Test
    @Description("GET /v2/pet/{id}")
    public void checkThatDeletePetByIdReturns200(){
        assertEquals(petSteps.deletePet(TestCred.PET_ID).getStatusCode(),200);
    }




    @Test
    public void checkThatPetCanBeCreatedUpdatedReturnedAndDeletedSuccessfully(){
        //petSteps.createPet();
        //petSteps.updatePet().then().body("status", equalTo("sold"));
        //petSteps.getPet(456);
        //petSteps.deletePet();
    }
}
