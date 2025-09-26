package dogdaycare.model;
import org.junit.jupiter.api.Test;

public class DogTest {
    @Test
    void getName() {

        Owner Katie = new Owner();
        Katie.setName("Katie");
        Katie.setPhoneNumber("123-456-7890");

        Dog dog = new Dog();
        dog.setName("Buddy");
        dog.setBreed("Golden Retriever");
        dog.setAge(3);
        dog.setVaccinated(true);
        dog.setOwner(Katie);

        assert(dog.getName().equals("Buddy"));

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
//    @Test
//    void isVaccinated() {
//    }
//
//    @Test
//    void setVaccinated() {
//    }
//
//    @Test
//    void getOwner() {
//    }
//
//    @Test
//    void setOwner() {
//    }
//
//    @Test
//    void isEligibleForCheckIn() {
//    }
}
