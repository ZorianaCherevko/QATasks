package api.petstore;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class PetTests {

    public static final Integer PET_ID = 245;

    private PetServiceHelper petServiceHelper;

    @BeforeClass
    public void setUp() {
        petServiceHelper = new PetServiceHelper();
    }

    @Test
    public void checkThatCreatePetWithValidDataReturns200(){
        petServiceHelper.createPet();
    }

    @Test
    public void checkThatUpdatePetReturns200(){
        petServiceHelper.updatePet();
    }

    @Test
    public void checkThatGetPetByIdReturns200(){
        petServiceHelper.getPet(PET_ID);
    }

    @Test
    public void checkThatDeletePetByIdReturns200(){
        petServiceHelper.deletePet(PET_ID);
    }

    @Test
    public void checkThatPetCanBeCreatedUpdatedReturnedAndDeletedSuccessfully(){
        petServiceHelper.createPet();
        petServiceHelper.updatePet().then().body("status", equalTo("sold"));
        petServiceHelper.getPet(PET_ID);
        petServiceHelper.deletePet(PET_ID);
    }


}
