import java.util.ArrayList;
import java.util.Scanner;

/**
 * Головний клас програми для роботи з одягом
 * Демонструє створення об'єктів та наслідування
 */
public class Main {

    /**
     * Точка входу в програму
     */
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
                        System.out.println("Тип одягу:");
                        System.out.println("1. Звичайний одяг");
                        System.out.println("2. Штани");
                        System.out.println("3. Сорочка");
                        System.out.print("Виберіть тип: ");

                        int type = Integer.parseInt(
                                scanner.nextLine().trim());

                        if (type < 1 || type > 3) {
                            throw new IllegalArgumentException(
                                    "Неправильний тип одягу");
                        }

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

                        Clothes item;

                        if (type == 1) {
                            System.out.println("Категорії:");
                            System.out.println("1. TSHIRT");
                            System.out.println("2. JACKET");
                            System.out.println("3. PANTS");
                            System.out.println("4. SHOES");
                            System.out.print("Виберіть категорію: ");

                            int categoryNumber = Integer.parseInt(
                                    scanner.nextLine().trim());

                            ClothingCategory category;

                            switch (categoryNumber) {
                                case 1:
                                    category = ClothingCategory.TSHIRT;
                                    break;
                                case 2:
                                    category = ClothingCategory.JACKET;
                                    break;
                                case 3:
                                    category = ClothingCategory.PANTS;
                                    break;
                                case 4:
                                    category = ClothingCategory.SHOES;
                                    break;
                                default:
                                    throw new IllegalArgumentException(
                                            "Неправильна категорія");
                            }

                            item = new Clothes(
                                    name, size, price, quantity, category);

                        } else if (type == 2) {
                            System.out.print("Фасон штанів: ");
                            String fit = scanner.nextLine();

                            item = new Pants(
                                    name, size, price, quantity, fit);

                        } else {
                            System.out.print("Тип рукава: ");
                            String sleeveLength = scanner.nextLine();

                            item = new Shirts(
                                    name, size, price, quantity, sleeveLength);
                        }

                        clothes.add(item);
                        System.out.println("Об'єкт успішно створено!");
                        System.out.println(item.toString());

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



