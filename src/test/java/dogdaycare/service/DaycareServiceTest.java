package dogdaycare.service;
import dogdaycare.model.Dog;
import dogdaycare.model.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DaycareServiceTest {
    /**
     Unit tests for the DaycareService class
     Tests cover:
     - Checking dogs in/out
     - Capacity limits
     - Vaccination eligibility
     - Attendance list updates
     */

    @Test
    public void testCheckDogInSuccessfully(){
        // Create a new daycare service
        DaycareService daycare = new DaycareService();

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

        boolean result = daycare.checkInDog(dog);

        Assertions.assertTrue(result);
        Assertions.assertTrue(daycare.getCheckedInDogs().contains(dog));
    }

    @Test
    public void testCheckDogOutSuccessfully(){
        // Create a new daycare service
        DaycareService daycare = new DaycareService();

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

        daycare.checkInDog(dog);

        boolean result = daycare.checkOutDog(dog);

        Assertions.assertTrue(result);
        Assertions.assertFalse(daycare.getCheckedInDogs().contains(dog));

    }

    @Test
    public void testCannotCheckInDogAtMaxCapacity(){
        // Create daycare
        DaycareService daycare = new DaycareService();

        // Fill the daycare to max capacity 30 dogs
        for (int i = 0; i < 30; i ++){
            Owner owner = new Owner();
            owner.setName("Owner" + (i + 1));
            Dog dog = new Dog();
            dog.setName("Dog" + (i + 1));
            dog.setVaccinated(true);
            dog.setOwner(owner);
            daycare.checkInDog(dog);
        }

        // Try to add extra dog
        Owner newOwner = new Owner();
        newOwner.setName("NewOwner");
        newOwner.setPhoneNumber("111-222-3333");

        Dog dog = new Dog();
        dog.setName("Lyla");
        dog.setBreed("Australian Shepherd");
        dog.setAge(8);
        dog.setVaccinated(true);
        dog.setOwner(newOwner);

        boolean result = daycare.checkInDog(dog);

        Assertions.assertFalse(result);
        Assertions.assertFalse(daycare.getCheckedInDogs().contains(dog));
        Assertions.assertEquals(30,daycare.getCheckedInDogs().size());

    }

    @Test
    public void testCannotCheckInUnvaccinatedDog(){
        DaycareService daycare = new DaycareService();

        // Create Owner and  unvaccinated dog
        Owner katie = new Owner();
        katie.setName("Katie");
        katie.setPhoneNumber("123-456-7890");

        Dog dog = new Dog();
        dog.setName("Lyla");
        dog.setBreed("Australian Shepherd");
        dog.setAge(8);
        dog.setVaccinated(false);
        dog.setOwner(katie);

        boolean result = daycare.checkInDog(dog);

        Assertions.assertFalse(result);
        Assertions.assertFalse(daycare.getCheckedInDogs().contains(dog));
    }

    @Test
    public void testAttendanceListUpdatesCheckInAndCheckOut(){
        DaycareService daycare = new DaycareService();

        // Create Owner and dogs
        Owner katie = new Owner();
        katie.setName("Katie");
        katie.setPhoneNumber("123-456-7890");

        Dog dog1 = new Dog();
        dog1.setName("Lyla");
        dog1.setBreed("Australian Shepherd");
        dog1.setAge(8);
        dog1.setVaccinated(true);
        dog1.setOwner(katie);

        Dog dog2 = new Dog();
        dog2.setName("Fido");
        dog2.setBreed("Australian Shepherd");
        dog2.setAge(8);
        dog2.setVaccinated(true);
        dog2.setOwner(katie);

        daycare.checkInDog(dog1);
        daycare.checkInDog(dog2);

        List<Dog> attendance = daycare.getCheckedInDogs();
        Assertions.assertEquals(2,attendance.size());
        Assertions.assertTrue(daycare.getCheckedInDogs().contains(dog1));
        Assertions.assertTrue(daycare.getCheckedInDogs().contains(dog2));

        daycare.checkOutDog(dog1);
        attendance = daycare.getCheckedInDogs();
        Assertions.assertEquals(1, attendance.size());
        Assertions.assertFalse(attendance.contains(dog1));
        Assertions.assertTrue(attendance.contains(dog2));

    }

}
