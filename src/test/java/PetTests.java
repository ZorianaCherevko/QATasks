
import builders.Category;
import builders.Status;
import builders.Tag;
import enpoints.Endpoints;
import jdk.jfr.Description;
import steps.PetSteps;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

import static org.hamcrest.Matchers.equalTo;

public class PetTests extends BaseTests{


    private final PetSteps petSteps = new PetSteps();


    @Test
    @Description("POST /v2/pet")
    public void checkCreatePet(){
        assertEquals(petSteps.createPetWithBuilder(245, "Rocky",
                "https://highlandcanine.com/wp-content/uploads/2020/12/iStock-926735822.jpg",
                Category.builder().id(245).name("Dog").build(),
               (List<Tag>) Tag.builder().id(245).name("Hound").build(),
                Status.available).getStatusCode(),200);
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
