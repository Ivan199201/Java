package Data;

public enum AnimalTypeData {
    CAT,
    DOG,
    DUCK;

    private String name;

    AnimalTypeData(String name) {

        this.name = name;
    }

    AnimalTypeData() {

    }

    public String getName() {

        return name;
    }
}




