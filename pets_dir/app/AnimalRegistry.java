import Animals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalRegistry {
    public List<Animal> animals = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        registry.menu();
    }

    public void menu() {
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Завести новое животное");
            System.out.println("2. Определить животное в правильный класс");
            System.out.println("3. Увидеть список команд, которое выполняет животное");
            System.out.println("4. Обучить животное новым командам");
            System.out.println("5. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewAnimal();
                    break;
                case 2:
                    determineAnimalClass();
                    break;
                case 3:
                    showAnimalCommands();
                    break;
                case 4:
                    trainAnimal();
                    break;
                case 5:
                    System.out.println("Выход из программы.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор. Введите число от 1 до 5");
            }
        }
    }

    private void addNewAnimal() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения животного (yyyy-mm-dd):");
        String birthDate = scanner.nextLine();
        System.out.println("Введите тип животного (собака, кошка, хомяк, лошадь, верблюд, осел):");
        String type = scanner.nextLine();

        Animal animal = null;
        switch (type.toLowerCase()) {
            case "собака":
                animal = new Dog(name, birthDate);
                break;
            case "кошка":
                animal = new Cat(name, birthDate);
                break;
            case "хомяк":
                animal = new Hamster(name, birthDate);
                break;
            case "лошадь":
                animal = new Horse(name, birthDate);
                break;
            case "верблюд":
                animal = new Camel(name, birthDate);
                break;
            case "осел":
                animal = new Donkey(name, birthDate);
                break;
            default:
                System.out.println("Неправильный тип животного.");
                return;
        }

        animals.add(animal);
        System.out.println(type + " " + name + " добавлен(а) в систему.");
    }

    private void determineAnimalClass() {
        System.out.println("Введите имя животного для поиска:");
        String name = scanner.nextLine();
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.println("Животное " + name + " относится к классу: " + animal.getAnimalType());
                return;
            }
        }
        System.out.println("Животное не найдено.");
    }

    private void showAnimalCommands() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                List<String> commands = animal.getCommands();
                if (commands.isEmpty()) {
                    System.out.println("Животное " + name + " не знает никаких команд.");
                } else {
                    System.out.println("Животное " + name + " знает следующие команды:");
                    for (String command : commands) {
                        System.out.println(command);
                    }
                }
                return;
            }
        }
        System.out.println("Животное не найдено.");
    }

    private void trainAnimal() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.println("Введите новую команду для животного:");
                String newCommand = scanner.nextLine();
                animal.addCommand(newCommand);
                System.out.println("Животное " + name + " обучено новой команде: " + newCommand);
                return;
            }
        }
        System.out.println("Животное не найдено.");
    }
}
