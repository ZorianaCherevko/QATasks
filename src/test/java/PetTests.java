
import jdk.jfr.Description;
import steps.PetSteps;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import static org.hamcrest.Matchers.equalTo;

public class PetTests extends BaseTests{

    public static final Integer PET_ID = 245;

    private final PetSteps petSteps = new PetSteps();


    @Test
    @Description("POST /v2/pet")
    public void checkCreatePet(){
        assertEquals(petSteps.createPet(CredentialSystemPet));
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
        petSteps.getPet(PET_ID);
    }

    @Test
    public void checkThatDeletePetByIdReturns200(){
        petSteps.deletePet(PET_ID);
    }

    @Test
    public void checkThatPetCanBeCreatedUpdatedReturnedAndDeletedSuccessfully(){
        petSteps.createPet();
        petSteps.updatePet().then().body("status", equalTo("sold"));
        petSteps.getPet(PET_ID);
        petSteps.deletePet(PET_ID);
    }
}
