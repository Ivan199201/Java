package animals;

import data.ColorData;

public abstract class Animal {

    private String name = "";
    private float age = -1;
    private float weight = -1;
    private ColorData color = null;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight =  weight;
    }

    public ColorData getColor() {

        return color;
    }

    public void setColor(ColorData color) {
        this.color = color;
    }

    public abstract void say();

    public String toString() {
        return String.format("Привет! меня зовут %s, мне %.1f %s, я вешу %.1f кг, мой цвет - %s.",
                name, age, setAgePd(), weight, (color != null ? color.getColor().toLowerCase():"неизвестно"));
    }


    private String setAgePd() {
        float remainder = age % 10;

        if (age >= 11 && age < 19) {
            return "лет";
        }
        if (remainder == 1) {
            return "год";
        }
        if (remainder >= 2 && remainder <= 4) {
            return "года";
        }
        return "лет";

    }
}