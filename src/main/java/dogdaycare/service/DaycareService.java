package dogdaycare.service;

import dogdaycare.model.Dog;

import java.util.ArrayList;
import java.util.List;

public class DaycareService {
    private static final int MAX_CAPACITY = 30;
    private List<Dog> checkedInDogs = new ArrayList<>();


    // Check-in dog
    public boolean checkInDog(Dog dog) {
        if (!dog.isEligibleForCheckIn()) {
            System.out.println(dog.getName() + " (Owner: " + dog.getOwner().getName() + ")" + " is not vaccinated and is not eligible to be checked in");
            return false;
        }
        if (checkedInDogs.size() >= MAX_CAPACITY) {
            System.out.println("We are at max capacity for the day. Please come back another day");
            return false;
        }
        if(checkedInDogs.contains(dog)){
            System.out.println(dog.getName() + " (Owner: " + dog.getOwner().getName() + ")" + " is already checked-in");
            return false;
        }
        checkedInDogs.add(dog);
        System.out.println("Successfully checked in " + dog.getName() + " (Owner: " + dog.getOwner().getName() + ")");
        return true;
    }

    // Check-out dog
    public boolean checkOutDog(Dog dog) {
        if (checkedInDogs.contains(dog)) {
            System.out.println("Successfully checked out " + dog.getName() + " (Owner: " + dog.getOwner().getName() + ")");
            checkedInDogs.remove(dog);
            return true;
        }
        System.out.println(dog.getName() + " (Owner: " + dog.getOwner().getName() + ")" + " not currently checked in");
        return false;
    }

    // Check list of all checked-in dogs
    public List<Dog> getCheckedInDogs(){
        return checkedInDogs;
    }
}
