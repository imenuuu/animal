package handler.dto;


public class GetAnimalRes {
    private String animalName;
    private String animalBirth;
    private String animalType;
    private String animalKind;
    private String master;
    private String phoneNumber;

    public GetAnimalRes(String animalName, String animalBirth, String animalType, String animalKind, String master, String phoneNumber) {
        this.animalName = animalName;
        this.animalBirth = animalBirth;
        this.animalType = animalType;
        this.animalKind = animalKind;
        this.master = master;
        this.phoneNumber = phoneNumber;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalBirth() {
        return animalBirth;
    }

    public void setAnimalBirth(String animalBirth) {
        this.animalBirth = animalBirth;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalKind() {
        return animalKind;
    }

    public void setAnimalKind(String animalKind) {
        this.animalKind = animalKind;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
