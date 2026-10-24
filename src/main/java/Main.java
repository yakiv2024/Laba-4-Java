import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Clothes> clothes = new ArrayList<>();

        while (true) {
            System.out.println("\n МЕНЮ ПРОГРАМИ");
            System.out.println("1. Створити новий об'єкт");
            System.out.println("2. Вивести інформацію про всі об'єкти");
            System.out.println("3. Завершити роботу");
            System.out.print("Виберіть дію: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Назва: ");
                        String name = scanner.nextLine();

                        System.out.print("Розмір: ");
                        String size = scanner.nextLine();

                        System.out.print("Ціна: ");
                        double price = Double.parseDouble(
                                scanner.nextLine().trim().replace(',', '.'));

                        System.out.print("Кількість: ");
                        int quantity = Integer.parseInt(
                                scanner.nextLine().trim());

                        Clothes item = new Clothes(name, size, price, quantity);
                        clothes.add(item);

                        System.out.println("Об'єкт успішно створено!");

                        Clothes copy = new Clothes(item);

                        System.out.println("Original: " + item);
                        System.out.println("Copy: " + copy);
                        System.out.println("Same object: " + (item == copy));
                        System.out.println("Created objects: " + Clothes.getObjectCount());

                    } catch (NumberFormatException e) {
                        System.out.println("Помилка! Введіть правильне число.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Помилка! " + e.getMessage());
                    }
                    break;

                case "2":
                    if (clothes.isEmpty()) {
                        System.out.println("Список одягу порожній.");
                    } else {
                        System.out.println("\nСписок одягу:");

                        for (Clothes item : clothes) {
                            System.out.println(item.toString());
                        }
                    }
                    break;

                case "3":
                    System.out.println("Роботу завершено.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Помилка. Виберіть пункт від 1 до 3");
            }
        }
    }
}




