package dogdaycare.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DogTest {
    @Test
    public void testGetName() {

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

//    @Test
//    void setName() {
//    }
//
//    @Test
//    void getBreed() {
//    }
//
//    @Test
//    void setBreed() {
//    }
//
//    @Test
//    void getAge() {
//    }
//
//    @Test
//    void setAge() {
//    }
//
    @Test
    public void testIsVaccinated() {

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
//
//    @Test
//    void setVaccinated() {
//    }
//
    @Test
    void getOwner() {

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


//
//    @Test
//    void setOwner() {
//    }
//
//    @Test
//    void isEligibleForCheckIn() {
//    }
}
