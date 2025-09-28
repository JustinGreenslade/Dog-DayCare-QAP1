package dogdaycare.model;

public class Dog {
    private String name;
    private String breed;
    private int age;
    private boolean isVaccinated;
    private Owner owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public  boolean isEligibleForCheckIn() {
        return isVaccinated;
    }

    @Override
    public String toString(){
        return name + " (" + " Owner: " + owner.getName() +" )";
    }
}






