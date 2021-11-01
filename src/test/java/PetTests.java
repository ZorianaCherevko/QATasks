
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
    public void checkCreatePet(){
        assertEquals(petSteps.createPetWithBuilder(TestCred.PET_ID, TestCred.PET_NAME,TestCred.PET_PHOTO,
                TestCred.PET_CATEGORY,TestCred.PET_TAGS,TestCred.PET_STATUS).getStatusCode(),200);
    }












    @Test
    public void checkThatCreatePetWithValidDataReturns200(){
        petSteps.createPet();
    }

    @Test
    public void checkThatUpdatePetReturns200(){
        petSteps.updatePet();
    }

    @Test
    public void checkThatGetPetByIdReturns200(){
        petSteps.getPet();
    }

    @Test
    public void checkThatDeletePetByIdReturns200(){
        petSteps.deletePet();
    }

    @Test
    public void checkThatPetCanBeCreatedUpdatedReturnedAndDeletedSuccessfully(){
        petSteps.createPet();
        petSteps.updatePet().then().body("status", equalTo("sold"));
        petSteps.getPet();
        petSteps.deletePet();
    }
}
