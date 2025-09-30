package dogdaycare.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OwnerTest {

        /**
         Unit tests for the Owner class
         Tests cover:
         - Getters, Setters
         - Correct dog for owner
         */

        @Test
        public void testOwnerGettersAndSetters() {

            // Create Owner and dog
            Owner katie = new Owner();
            katie.setName("Katie");
            katie.setPhoneNumber("123-456-7890");

            // Check of getters
            Assertions.assertEquals("Katie", katie.getName());
            Assertions.assertEquals("123-456-7890",katie.getPhoneNumber());

            // Change values to check setters
            katie.setName("Linda");
            katie.setPhoneNumber("000-111-2222");

            // Check setters changed original values
            Assertions.assertEquals("Linda", katie.getName());
            Assertions.assertEquals("000-111-2222",katie.getPhoneNumber());
            Assertions.assertNotEquals("Katie", katie.getName());
            Assertions.assertNotEquals("123-456-7890",katie.getPhoneNumber());

        }

        @Test
    public void testDoesOwnerOwnDog(){
            // Create Owner
            Owner katie = new Owner();
            katie.setName("Katie");
            katie.setPhoneNumber("123-456-7890");

            // Create dog and link to owner
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
