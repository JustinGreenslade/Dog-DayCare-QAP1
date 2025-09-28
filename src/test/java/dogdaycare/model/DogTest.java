package dogdaycare.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DogTest {
/*TODO add more focused tests so it seems less like im just testing everything
     For Dog
         * testOwnerGettersAndSetters
         * testIsDogEligibleForCheckIn
         * testIsDogAttchedToCorrectOwner
     For Owner
        * testOwnerGettersAndSetters
        * testIsOwnerAttachedToDog
    For DaycareService
        * testCheckDogIn
        * testCheckDogOut
        * testCheckInDogAtMaxCapacity
        * testCannotCheckInUnvaccinatedDog
        * testAttendanceListUpdates
     */
    @Test
    public void testToGetNameOfDog() {

        Owner Katie = new Owner();
        Katie.setName("Katie");
        Katie.setPhoneNumber("123-456-7890");

        Dog dog = new Dog();
        dog.setName("Buddy");
        dog.setBreed("Golden Retriever");
        dog.setAge(3);
        dog.setVaccinated(true);
        dog.setOwner(Katie);

        Assertions.assertEquals("Buddy", dog.getName());
        Assertions.assertNotEquals("Max", dog.getName());

    }

    @Test
    void setName() {


    }

    @Test
    public void testIfDogIsVaccinated() {

        Owner Katie = new Owner();
        Katie.setName("Katie");
        Katie.setPhoneNumber("123-456-7890");

        Dog dog = new Dog();
        dog.setName("Buddy");
        dog.setBreed("Golden Retriever");
        dog.setAge(3);
        dog.setVaccinated(true);
        dog.setOwner(Katie);

        Assertions.assertTrue(dog.isVaccinated());
    }

    @Test
    public void testToGetDogOwner() {

        Owner Katie = new Owner();
        Katie.setName("Katie");
        Katie.setPhoneNumber("123-456-7890");

        Dog dog = new Dog();
        dog.setName("Buddy");
        dog.setBreed("Golden Retriever");
        dog.setAge(3);
        dog.setVaccinated(true);
        dog.setOwner(Katie);

        Assertions.assertEquals(Katie, dog.getOwner());
    }


    @Test
    public void testIfDogIsEligibleForCheckIn() {
        Owner Katie = new Owner();
        Katie.setName("Katie");
        Katie.setPhoneNumber("123-456-7890");

        Dog dog = new Dog();
        dog.setName("Buddy");
        dog.setBreed("Golden Retriever");
        dog.setAge(3);
        dog.setVaccinated(true);
        dog.setOwner(Katie);

        Assertions.assertTrue(dog.isEligibleForCheckIn());
    }
}
