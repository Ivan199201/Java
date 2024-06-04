package animals.factory;

import Data.AnimalTypeData;
import animals.Animal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;



public class AnimalFactory {

    public Animal create(AnimalTypeData animalTypeData) {
        switch (animalTypeData) {
            case CAT:
                return new Cat();
            case DOG:
                return new Dog();
            case DUCK:
                return new Duck();

        }
        return null;
    }

}