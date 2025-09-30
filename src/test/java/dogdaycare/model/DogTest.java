package dogdaycare.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DogTest {

    /**
     Unit tests for the Dog class
     Tests cover:
     - Getters, Setters, and toString
     - Eligibility for check-in based on vaccination
     - Correct owner for dog
     */

    @Test
    public void testDogPropertiesAndToString() {

        // Create Owner and dog
        Owner katie = new Owner();
        katie.setName("Katie");
        katie.setPhoneNumber("123-456-7890");

        Dog dog = new Dog();
        dog.setName("Lyla");
        dog.setBreed("Australian Shepherd");
        dog.setAge(8);
        dog.setVaccinated(true);
        dog.setOwner(katie);

        // Check of getters
        Assertions.assertEquals("Lyla", dog.getName());
        Assertions.assertEquals("Australian Shepherd", dog.getBreed());
        Assertions.assertEquals(8, dog.getAge());
        Assertions.assertTrue(dog.isVaccinated());
        Assertions.assertEquals(katie, dog.getOwner());
        Assertions.assertTrue(dog.isEligibleForCheckIn());

        // Change values to check setters
        dog.setName("Charlie");
        dog.setBreed("Boxer");
        dog.setAge(1);
        dog.setVaccinated(false);

        Owner Jim = new Owner();
        Jim.setName("Jim");
        Jim.setPhoneNumber("000-111-2222");
        dog.setOwner(Jim);

        // Check setters changed original values
        Assertions.assertNotEquals("Lyla", dog.getName());
        Assertions.assertNotEquals("Australian Shepherd", dog.getBreed());
        Assertions.assertNotEquals(8, dog.getAge());
        Assertions.assertFalse(dog.isVaccinated());
        Assertions.assertNotEquals(katie, dog.getOwner());
        Assertions.assertFalse(dog.isEligibleForCheckIn());

        // Check toString output
        String output = dog.toString();
        Assertions.assertTrue(output.contains("Charlie"));
        Assertions.assertTrue(output.contains("Owner: Jim"));
    }


    @Test
    public void testDogEligibilityForCheckIn() {

        // Create Owner
        Owner katie = new Owner();
        katie.setName("Katie");
        katie.setPhoneNumber("123-456-7890");

        // Created a vaccinated dog
        Dog vaccinatedDog = new Dog();
        vaccinatedDog.setName("Lyla");
        vaccinatedDog.setBreed("Australian Shepherd");
        vaccinatedDog.setAge(8);
        vaccinatedDog.setVaccinated(true);
        vaccinatedDog.setOwner(katie);

        // Created an unvaccinated dog
        Dog unvaccinatedDog = new Dog();
        unvaccinatedDog.setName("Fido");
        unvaccinatedDog.setBreed("poodle");
        unvaccinatedDog.setAge(1);
        unvaccinatedDog.setVaccinated(false);
        unvaccinatedDog.setOwner(katie);

        // Confirms only vaccinated dogs can be checked in.
        Assertions.assertTrue(vaccinatedDog.isEligibleForCheckIn());
        Assertions.assertFalse(unvaccinatedDog.isEligibleForCheckIn());
    }

    @Test
    public void testIsDogLinkedToOwner() {

        // Create Owner and dog
        Owner katie = new Owner();
        katie.setName("Katie");
        katie.setPhoneNumber("123-456-7890");

        Dog dog = new Dog();
        dog.setName("Lyla");
        dog.setBreed("Australian Shepherd");
        dog.setAge(8);
        dog.setVaccinated(true);
        dog.setOwner(katie);

        // shows dog is linked with correct owner
        Assertions.assertEquals(katie, dog.getOwner());
        Assertions.assertEquals("Katie", dog.getOwner().getName());

        // new owner to ensure dog not linked to different owner
        Owner wrongOwner = new Owner();
        wrongOwner.setName("NotKatie");
        wrongOwner.setPhoneNumber("111 222 3333");

        Assertions.assertNotEquals(wrongOwner,dog.getOwner());
    }

}
