import Data.AnimalTypeData;
import Data.ColorData;
import Data.CommandsData;
import animals.Animal;
import animals.factory.AnimalFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String... args) {
        List<Animal> animals = new ArrayList();

        Scanner console = new Scanner(System.in);
        CommandsData[] commandsData = CommandsData.values();
        String [] commandsStr = new String[commandsData.length];

        for(int i = 0; i < commandsData.length; i++){
            commandsStr[i] = commandsData[i].name().toLowerCase();
        }

        while (true) {
            System.out.printf("Введите одну из команд: %s\n", String.join("/", commandsStr));
            String userCommand = console.next().trim().toUpperCase();


            boolean isCommandExist = Arrays.stream(commandsData)
                    .map(Enum::name)
                    .anyMatch(name -> name.equalsIgnoreCase(userCommand));


            if (!isCommandExist) {
                System.out.println("Неверная команда: " + userCommand.toUpperCase() + ". Повторите попытку.");
                continue;
            }
            CommandsData userCommandsData = CommandsData.valueOf(userCommand);

            switch (userCommandsData) {
                case ADD:
                    AnimalFactory animalFactory = new AnimalFactory();
                    AnimalTypeData[] animalTypeData = AnimalTypeData.values();
                    String[] userAnimal = new String[animalTypeData.length];
                    for (int i = 0; i < animalTypeData.length; i++) {
                        userAnimal[i] = animalTypeData[i].name().toLowerCase();

                    }

                    while (true) {
                        System.out.printf("Введите тип животного, которого хотите добавить: %s\n",
                                String.join("/", userAnimal));
                        String commandsName = console.next().trim().toUpperCase();

                        boolean isCommandExistName = Arrays.stream(animalTypeData)
                                .map(Enum::name)
                                .anyMatch(name -> name.equalsIgnoreCase(commandsName));

                        if (!isCommandExistName) {
                            System.out.println("Неверный тип: " + commandsName.toUpperCase() + ". Повторите попытку.");
                            continue;
                        }
                        System.out.println("Вы ввели тип: " + commandsName);


                        System.out.println("Введите имя животного:");
                        String nameAnimal = console.next().trim();
                        AnimalTypeData animalTypeDatas = AnimalTypeData.valueOf(commandsName);
                        Animal animalsName = animalFactory.create(animalTypeDatas);
                        animalsName.setName(nameAnimal);

                        System.out.println("Вы ввели имя: " + nameAnimal);


                        int age = -1;
                        boolean validAge = false;

                        while (!validAge) {
                            System.out.println("Введите возраст животного:");
                            String ageAnimal = console.next().trim();


                            try {
                                age = Integer.parseInt(ageAnimal);
                                animalsName.setAge(age);
                                validAge = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Некорректный ввод. Пожалуйста, введите число.");

                            }

                        }
                        System.out.println("Вы ввели возраст: " + age);


                        float weight = -1;
                        boolean validWeight = false;
                        while (!validWeight) {
                            System.out.println("Введите вес животного:");
                            String weightAnimal = console.next().trim();


                            try {
                                weight = Float.parseFloat(weightAnimal);
                                animalsName.setWeight(weight);
                                validWeight = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Некорректный ввод. Пожалуйста, введите число.");

                            }

                        }
                        System.out.println("Вы ввели вес: " + weight);


                        AnimalFactory animalFactoryColor = new AnimalFactory();
                        ColorData[] colorData = ColorData.values();
                        String[] userAnimalColor = new String[colorData.length];
                        for (int i = 0; i < colorData.length; i++) {
                            userAnimalColor[i] = colorData[i].name().toLowerCase();
                        }


                        while (true) {
                            System.out.printf("Введите цвет животного: %s\n", String.join("/", userAnimalColor));
                            String commandsNameColor = console.next().trim().toUpperCase();


                            boolean isCommandExistColor = Arrays.stream(colorData)
                                    .map(Enum::name)
                                    .anyMatch(name -> name.equalsIgnoreCase(commandsNameColor));

                            if (!isCommandExistColor) {
                                System.out.println("Неверный цвет: " + commandsNameColor.toUpperCase() + ". Повторите попытку.");
                                continue;
                            }


                            animalsName.setColor(ColorData.valueOf(commandsNameColor));
                            animals.add(animalsName);

                            System.out.println("Вы ввели цвет: " + commandsNameColor);
                            break;
                        }

                            break;
                    }

                            break;
                case LIST:
                    for(Animal animal: animals)  {
                        System.out.println(animal.toString());
                    }
                    break;
                case EXIT:
                    System.out.println("Программа завершается. Arrivederci!");
                    System.exit(0);
            }
        }
    }
}





