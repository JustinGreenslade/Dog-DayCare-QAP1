package dogdaycare.service;

import dogdaycare.model.Dog;

import java.util.List;

public class DaycareService {
    boolean isCheckedIn;
    List<Dog> checkedInDogs;

    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        isCheckedIn = checkedIn;
    }

    public List<Dog> getCheckedInDogs() {
        return checkedInDogs;
    }

    public void setCheckedInDogs(List<Dog> checkedInDogs) {
        this.checkedInDogs = checkedInDogs;
    }
}
